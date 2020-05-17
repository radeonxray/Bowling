package com.company.CalculationsVerTwo;

import com.company.Calculations.SpareCalculations;
import com.company.ObjectClasses.DataObject;
import com.company.ObjectClasses.ScoreAndPrevScoresObject;
import com.company.ObjectClasses.ScoreFrameObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Class for calculating the scores of the bowling game*/
public class CalculationsVerTwo {

    private DataObject dataObj;
    private int gameSize;
    private boolean isShortGame, finalScoreDone;
    private ScoreAndPrevScoresObject currentAndPrevObjList = new ScoreAndPrevScoresObject();
    private StrikeCalculationVerTwo strikeCalcTwo;
    private SpareCalculationsVerTwo spareCalcTwo;
    private NormalCalculationsVerTwo normalCalcTwo;

    /**
     * Method for calculating the individual score of a scoreobject
     * @param  currentScoreObj: Requires a ScoreFrameObject
     * @return Returns an int */
    public void calculateIndividualScore(ScoreFrameObject currentScoreObj){
        CheckScoreType cst = new CheckScoreType();
        strikeCalcTwo = new StrikeCalculationVerTwo();
        spareCalcTwo = new SpareCalculationsVerTwo();
        normalCalcTwo = new NormalCalculationsVerTwo();

        currentAndPrevObjList.setCurrentScore(currentScoreObj);
        cst.identifyScoreType(currentScoreObj);

/*
        System.out.println("----------");
        System.out.println("Current ID: " + currentScoreObj.getFrameID());
        if(currentScoreObj.getFrameID() > 1) {
            System.out.println("Prev ID: " + currentAndPrevObjList.getFirstLeftScore().getFrameID());
        }
        if(currentScoreObj.getFrameID() > 2) {
            System.out.println("2Prev ID: " + currentAndPrevObjList.getSecondLeftScore().getFrameID());
        }
        if (currentScoreObj.getFrameID() > 3) {
            System.out.println("3Prev ID: " + currentAndPrevObjList.getThirdLeftScore().getFrameID());
        }

        System.out.println("----------");
*/
        if(currentScoreObj.getScoreType().toString() == "STRIKE"){
            strikeCalcTwo.calculateStrike(currentAndPrevObjList);
        } else

        if(currentScoreObj.getScoreType().toString() == "SPARE"){
            spareCalcTwo.calculateSpare(currentAndPrevObjList);

        } else

        if(currentScoreObj.getScoreType().toString() == "NORMAL"){
            normalCalcTwo.calculateNormal(currentAndPrevObjList);
        }
    }

    /**
     * Method that executes the entire calculation operation
     * @return Returns a DataObject*/
    public DataObject runCalculations(){
        setupGameSize();
        calculationsLoops();
        return getDataObj();
    }

    /**Method for assigning the gamesize to the gameSize-variable by the dataObj, as well as determining if the game is a short/incomplete/unfinished game*/
    public void setupGameSize(){
        setGameSize(dataObj.getListOfFrameScores().size());
        if(getGameSize() < 10){
            setShortGame(true);
        }
    }

    /**
     * Method that handles running the list of scores through the CalculateIndividualScore-method
     * @return Returns a DataObject*/
    public void calculationsLoops(){


        for (int i = 0; i < getGameSize(); i++) {

            if(dataObj.getListOfFrameScores().get(i).getFrameID() < getGameSize()){

                assignPreviousScoreObjects(i);
                calculateIndividualScore(dataObj.getListOfFrameScores().get(i));

                System.out.println("RUNNING " + gameSize + " : " + dataObj.getListOfFrameScores().get(i).getFrameID());

                resetObjList(currentAndPrevObjList);
            }
            else if (dataObj.getListOfFrameScores().get(i).getFrameID() == getGameSize()){

                if(isShortGame && getGameSize() != 1){
                    assignPreviousScoreObjects(i);
                    System.out.println("Final Round - SHORT GAME " + gameSize + " : " + dataObj.getListOfFrameScores().get(i).getFrameID());

                    shortGame_finishNonCalcPoints_V2(currentAndPrevObjList);
                    //shortGame_finishNonCalcPoints(currentAndPrevObjList);

                } else {

                   System.out.println("Final Round " + gameSize + " : " + dataObj.getListOfFrameScores().get(i).getFrameID());
                   int finalPoints = calculateFramePoints(dataObj.getListOfFrameScores().get(i));

                   dataObj.getFinalScoreList().add(finalPoints);
                   finalScoreDone = true;
                }
            }

        }

        if(!isFinalScoreDone()){
            setFinalListOfScores(getDataObj());
        }

    }

    /**
     * Method to set the list of the scores final points*/
    public void setFinalListOfScores(DataObject dataObj){
        for (int i = 0; i < getGameSize(); i++) {
            dataObj.getFinalScoreList().add(dataObj.getListOfFrameScores().get(i).getPoints());
        }
    }

    /**Method that assigns the currentScore and potential previous scores, based on the current round of the game*/
    public void assignPreviousScoreObjects(int i){

        currentAndPrevObjList.setCurrentScore(dataObj.getListOfFrameScores().get(i));

        if(i > 0){
            currentAndPrevObjList.setFirstLeftScore(dataObj.getListOfFrameScores().get(i-1));
        }
        if(i > 1){
            currentAndPrevObjList.setSecondLeftScore(dataObj.getListOfFrameScores().get(i-2));
        }
        if(i > 2){
            currentAndPrevObjList.setThirdLeftScore(dataObj.getListOfFrameScores().get(i-3));
        }
    }


    /**Private method that takes a {@link ScoreFrameObject} and calculates its total value, by adding its two frame together
     *@param curScoObj Requires a ScoreFrameObject
     *@return Returns an int with the accumulated score*/
    private int calculateFramePoints(ScoreFrameObject curScoObj){
        return curScoObj.getFirstScoreFramePoint() + curScoObj.getSecondScoreFramePoint();
    }

    /**
     * Method that resets the objList, to make sure that the next CurrentScore knows the correct previous objects*/
    public void resetObjList(ScoreAndPrevScoresObject objList){
        objList.setCurrentScore(null);
        objList.setSecondLeftScore(null);
        objList.setFirstLeftScore(null);
        objList.setThirdLeftScore(null);

    }

    /**Method that is used for calculating any non-calculated scores, if the game ends abruptly (due to a short game (gameSize() < 10))
     * Method takes the current (and final) score of the game, and forces it to become a score of type NORMAL (no matter its calculated type),
     * then runs the method for calculating normal scores */
    public void shortGame_finishNonCalcPoints_V2(ScoreAndPrevScoresObject objList) {
        objList.getCurrentScore().setScoreType(ScoreFrameObject.ScoreType.NORMAL);
        normalCalcTwo.calculateNormal(currentAndPrevObjList);

    }

    public DataObject getDataObj() {
        return dataObj;
    }

    public void setDataObj(DataObject dataObj) {
        this.dataObj = dataObj;
    }

    public int getGameSize() {
        return gameSize;
    }

    public void setGameSize(int gameSize) {
        this.gameSize = gameSize;
    }

    public boolean isShortGame() {
        return isShortGame;
    }

    public void setShortGame(boolean shortGame) {
        isShortGame = shortGame;
    }


    public boolean isFinalScoreDone() {
        return finalScoreDone;
    }

    public void setFinalScoreDone(boolean finalScoreDone) {
        this.finalScoreDone = finalScoreDone;
    }
}
