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
    private StrikeCalculationVerTwo strikeCalcTwo = new StrikeCalculationVerTwo();
    private SpareCalculationsVerTwo spareCalcTwo = new SpareCalculationsVerTwo();
    private NormalCalculationsVerTwo normalCalcTwo = new NormalCalculationsVerTwo();
    private CheckScoreType cst = new CheckScoreType();

    /**
     * Method for calculating the individual score of a scoreobject
     * @param  currentScoreObj: Requires a ScoreFrameObject
     * @return Returns an int */
    public void calculateIndividualScore(ScoreFrameObject currentScoreObj){


        currentAndPrevObjList.setCurrentScore(currentScoreObj);
        cst.identifyScoreType(currentScoreObj);

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
     * Method that handles running the list of scores through the CalculateIndividualScore-method */
    public void calculationsLoops(){

        if(getGameSize() == 1){
            singleRound_Game(0);
        }

        for (int currentScoreID = 0; currentScoreID < getGameSize(); currentScoreID++) {

            if(dataObj.getListOfFrameScores().get(currentScoreID).getFrameID() < getGameSize()){

                calculationPreparations(currentScoreID);
                resetObjList(currentAndPrevObjList);
            }
            if(dataObj.getListOfFrameScores().get(currentScoreID).getFrameID() == 10){
                calculationPreparations(currentScoreID);
            }
            if(dataObj.getListOfFrameScores().get(currentScoreID).getFrameID() == 11) {
                bonusRoundCalculation(currentScoreID);
            }
            if(isShortGame && getGameSize() != 1 && dataObj.getListOfFrameScores().get(currentScoreID).getFrameID() == getGameSize()){
                shortGame_BelowTenRounds(currentScoreID);
            }
        }
        if(!isFinalScoreDone()){
            setFinalListOfScores(getDataObj());
            removeEleventhScore();
        }

    }

    /**Method for running the assignPreviousScoresObjects-method and the calculateIndividualScoreObjects-method
     * @param  currentScoreID: Requires the current score ID */
    public void calculationPreparations(int currentScoreID){
        assignPreviousScoreObjects(currentScoreID);
        calculateIndividualScore(dataObj.getListOfFrameScores().get(currentScoreID));
    }

    /**Method for calculating the games score, if the game length is only 1 round*/
    public void singleRound_Game(int currentScoreID){
        int finalPoints = calculateFramePoints(dataObj.getListOfFrameScores().get(currentScoreID));
        dataObj.getFinalScoreList().add(finalPoints);
        finalScoreDone = true;
    }

    /**Method for running the assignPreviousScoresObjects-method and the shortGame_finishNonCalcPoints_V2-method
     *@param  currentScoreID: Requires the current score ID */
    public void shortGame_BelowTenRounds(int currentScoreID){
        assignPreviousScoreObjects(currentScoreID);
        shortGame_finishNonCalcPoints_V2(currentAndPrevObjList);

    }

    /**Method for calculating the final score, if the game has a bonus round, also known as the "11th" round
     *@param  currentScoreID: Requires the current score ID */
    public void bonusRoundCalculation(int currentScoreID){

        currentAndPrevObjList.setCurrentScore(dataObj.getListOfFrameScores().get(currentScoreID));
        assignPreviousScoreObjects(currentScoreID);
        calculateIndividualScore(dataObj.getListOfFrameScores().get(currentScoreID));

        if(dataObj.getListOfFrameScores().get(currentScoreID-1).getScoreType().toString() == "STRIKE") {
            if (dataObj.getListOfFrameScores().get(currentScoreID).getScoreType().toString() == "STRIKE") {
                strikeCalcTwo.strikeBonusFrame(currentAndPrevObjList);
            }
        }

        if(dataObj.getListOfFrameScores().get(currentScoreID).getScoreType().toString() == "NORMAL"){
            normalCalcTwo.calculateNormal(currentAndPrevObjList);
        }
    }

    /**If the game has a bonus score (Spare or strike in the tenth framescore),
     * this method will remove the empty or 0 score that will appear as a eleventh frame score at the end of the final score list*/
    public void removeEleventhScore(){
        if(gameSize > 10){
            getDataObj().getFinalScoreList().remove((10));
        }
    }

    /**
     * Method to set the list of the scores final points
     * @param  dataObj: Requires an object of type DataObject*/
    public void setFinalListOfScores(DataObject dataObj){
        for (int i = 0; i < getGameSize(); i++) {
            dataObj.getFinalScoreList().add(dataObj.getListOfFrameScores().get(i).getPoints());
        }
    }

    /**Method that assigns the currentScore and potential previous scores, based on the current round of the game
     * @param currentScoreID: Requires an int that represents the ID of the current score object*/
    public void assignPreviousScoreObjects(int currentScoreID){

        currentAndPrevObjList.setCurrentScore(dataObj.getListOfFrameScores().get(currentScoreID));

        if(currentScoreID > 0){
            currentAndPrevObjList.setFirstLeftScore(dataObj.getListOfFrameScores().get(currentScoreID-1));
        }
        if(currentScoreID > 1){
            currentAndPrevObjList.setSecondLeftScore(dataObj.getListOfFrameScores().get(currentScoreID-2));
        }
        if(currentScoreID > 2){
            currentAndPrevObjList.setThirdLeftScore(dataObj.getListOfFrameScores().get(currentScoreID-3));
        }
    }


    /**Private method that takes a {@link ScoreFrameObject} and calculates its total value, by adding its two frame together
     *@param curScoObj Requires a ScoreFrameObject
     *@return Returns an int with the accumulated score*/
    private int calculateFramePoints(ScoreFrameObject curScoObj){
        return curScoObj.getFirstScoreFramePoint() + curScoObj.getSecondScoreFramePoint();
    }

    /**
     * Method that resets the objList, to make sure that the next CurrentScore knows the correct previous objects
     * @param objList: Requires a object of type ScoreAndPrevScoresObject */
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
