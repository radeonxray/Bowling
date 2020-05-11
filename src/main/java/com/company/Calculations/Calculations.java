package com.company.Calculations;

import com.company.ObjectClasses.DataObject;
import com.company.ObjectClasses.ScoreFrameObject;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;

/**
 * Class for handling and executing the calculations of the score
 * */
public class Calculations {

    private DataObject dataObj;
    private int sparePoints = 10;
    private int strikeTenPoints = 10;
    private int strikeFullPoints = 20;
    private int tripleStrikePoints = 30;

    /**
     * Method for checking if the provided single ScoreFrameObject is a Spare
     * @param scoreFrameObject: A single ScoreFrameObject
     * @return Returns a boolean*/
    public Boolean checkIsSpare(ScoreFrameObject scoreFrameObject){

        if(scoreFrameObject.getFirstScoreFramePoint() + scoreFrameObject.getSecondScoreFramePoint() == 10){
            //Boolean
            scoreFrameObject.setSpare(true);
            scoreFrameObject.setStrike(false);
            scoreFrameObject.setNormal(false);
            System.out.println("Score ID" + scoreFrameObject.getFrameID()+ ": SPARE!");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method for checking if the provided single ScoreFrameObject is a Strike
     * @param scoreFrameObject: A single ScoreFrameObject
     * @return Returns a boolean*/
    public Boolean checkIsStrike(ScoreFrameObject scoreFrameObject){

        if(scoreFrameObject.getFirstScoreFramePoint() == 10){
            //Boolean
            scoreFrameObject.setStrike(true);
            scoreFrameObject.setSpare(false);
            scoreFrameObject.setNormal(false);
            System.out.println("Score ID" + scoreFrameObject.getFrameID()+ ": STRIKE!");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method for checking if the provided single ScoreFrameObject is a normal, thus not a strike or a spare
     * @param scoreFrameObject: A single ScoreFrameObject
     * @return Returns a boolean*/
    public Boolean checkIsNormalPoints(ScoreFrameObject scoreFrameObject){

        if(calcCurrentScoreFramePointSum(scoreFrameObject) != 10){
            //Boolean
            System.out.println("WHY ARE YOU IN NORMAL!?");
            scoreFrameObject.setNormal(true);
            scoreFrameObject.setStrike(false);
            scoreFrameObject.setSpare(false);
            System.out.println("Score ID" + scoreFrameObject.getFrameID()+ ": Normal!");
            return true;
        } else {
            return false;
        }
    }


    /**
     * Method for calculating and assigning the points to the given ScoreFrameObject.
     * Runs the provided ScoreFrameObject through checks to see if the score is a Strike, Spare or just needs to award normal points
     * @param scoreFrameObject: Calculating on the provided ScoreFrameObject*/
    public void calculateSingleFrameScore(ScoreFrameObject scoreFrameObject){
        if(checkIsStrike(scoreFrameObject)){
            //Add to final list as Strike
            //Check previous Score for Strike or Spare
        } else if(checkIsSpare(scoreFrameObject)){
            //Add to final list as Spare
            //Check previous scores for Strike or Spare
        } else {
            scoreFrameObject.setNormal(true);
            //Check previous score for Strike or Spare
            int frameScore = scoreFrameObject.getFirstScoreFramePoint() + scoreFrameObject.getSecondScoreFramePoint();
            scoreFrameObject.setPoints(frameScore);
            System.out.println("NO STRIKE OR SPARE! Normal points");
        }
    }

    /**
     * Method for using the current ScoreFrameObject to retrieve the left ScoreFrameObject from the current one
     * Ex: Current #5, returns #4
     * Method retrieves the first left ScoreFrameObject, by looking at the currentScoreFrameObject.getFrameID() - 2,
     * due to .getFrameID() being based on i+1 in JSONHandler.convert_JSONArray_to_List
     * @param currentScoreFrameObject: Provide the current ScoreFrameObject
     * @return Returns the previous ScoreFrameObject */
    public ScoreFrameObject getFirstLeftScoreFrame(ScoreFrameObject currentScoreFrameObject){
        ScoreFrameObject previousScoreFrameObject = dataObj.getListOfFrameScores().get(currentScoreFrameObject.getFrameID()-2);
        return previousScoreFrameObject;
    }

    /**
     * Method for using the current ScoreFrameObject to retrieve the ScoreFrameObject 2 spots left from the current one
     * Ex: Current #5, returns #3
     * Method retrieves the second left ScoreFrameObject, by looking at the currentScoreFrameObject.getFrameID() - 3,
     * due to .getFrameID() being based on i+1 in JSONHandler.convert_JSONArray_to_List
     * @param currentScoreFrameObject: Provide the current ScoreFrameObject
     * @return Returns the previous ScoreFrameObject */
    public ScoreFrameObject getSecondLeftScoreFrame(ScoreFrameObject currentScoreFrameObject){
        ScoreFrameObject secondPreviousScoreFrameObject = dataObj.getListOfFrameScores().get(currentScoreFrameObject.getFrameID()-3);
        return secondPreviousScoreFrameObject;
    }

    /**
     * Method for using the current ScoreFrameObject to retrieve the ScoreFrameObject 3 spots left from the current one
     * Ex: Current #5, returns #2
     * Method retrieves the third left ScoreFrameObject, by looking at the currentScoreFrameObject.getFrameID() - 4,
     * due to .getFrameID() being based on i+1 in JSONHandler.convert_JSONArray_to_List
     * @param currentScoreFrameObject: Provide the current ScoreFrameObject
     * @return Returns the previous ScoreFrameObject */
    public ScoreFrameObject getThirdLeftScoreFrame(ScoreFrameObject currentScoreFrameObject){
        ScoreFrameObject secondPreviousScoreFrameObject = dataObj.getListOfFrameScores().get(currentScoreFrameObject.getFrameID()-4);
        return secondPreviousScoreFrameObject;
    }


    public void bowlingScoreCalculations(ScoreFrameObject currentScoreFrameObject, int i, int gameLength){
        ScoreFrameObject currentSc = currentScoreFrameObject;
        ScoreFrameObject firstLeftScore = null;
        ScoreFrameObject secondLeftScore = null;
        ScoreFrameObject thirdLeftScore  = null;
        boolean finalRound = false;

        System.out.println("Game length: " + gameLength + " - "+ "i :" + currentSc.getFrameID());
        if(gameLength == currentSc.getFrameID()){
            finalRound = true;
        }

        if(gameLength <= 1 ){
            System.out.println("DIED IN FIRST ROUND!");
            int points = calcCurrentScoreFramePointSum(currentScoreFrameObject);
            currentSc.setPoints(points);

        } else {

            if (currentSc.getFrameID() >= 2) {
                firstLeftScore = getFirstLeftScoreFrame(currentSc);

                if (currentSc.getFrameID() >= 3) {
                    secondLeftScore = getSecondLeftScoreFrame(currentSc);
                }

                if (currentSc.getFrameID() >= 4) {
                    thirdLeftScore = getThirdLeftScoreFrame(currentScoreFrameObject);
                }
            }

            System.out.println("IN HERE!");
            //Check if current score is a strike
            if (checkIsStrike(currentSc)) {

                System.out.println("IN Strike!");

                if(finalRound){

                    if(calcCurrentScoreFramePointSum(currentSc) == 20){

                        int pointsSecond = thirdLeftScore.getPoints() + tripleStrikePoints;
                        secondLeftScore.setPoints(pointsSecond);
                        int pointsFirst = secondLeftScore.getPoints() + tripleStrikePoints;
                        firstLeftScore.setPoints(pointsFirst);
                        currentSc.setPoints(pointsFirst + tripleStrikePoints);

                    } else if(checkIsSpare(firstLeftScore)) {
                        int pointsFirst = strikeFullPoints;
                        firstLeftScore.setPoints(pointsFirst);

                        int pointCurrent = calcCurrentScoreFramePointSum(currentSc);
                        currentSc.setPoints(pointCurrent);

                    }else{
                        System.out.println("STRIKE: FINAL ROUND!");
                        int points = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc);
                        currentSc.setPoints(points);
                    }


                } else if(currentSc.getFrameID() >= 2) {


                    //Check if previous was a strike
                    if (firstLeftScore != null && checkIsStrike(firstLeftScore) && currentSc.getFrameID() != 11) {
                        System.out.println("STRIKE: PREVIOUS WAS A STRIKE!");
                        //Check for if the score before previous was a strike
                        if (secondLeftScore != null && checkIsStrike(secondLeftScore)) {
                            System.out.println("STRIKE: PREVIOUS AND 2 PREV WAS A STRIKE!");
                            int points = secondLeftScore.getPoints() + tripleStrikePoints;
                            secondLeftScore.setPoints(points);

                            //Set points on the thirdLeft frame, if 3 strikes in a row!
                            if(currentSc.getFrameID() >= 4 && thirdLeftScore != null && checkIsStrike(thirdLeftScore)){
                                System.out.println("THE TRIPLE STRIKE SYSTEM!");
                                int pointsThird = thirdLeftScore.getPoints() + tripleStrikePoints;
                                secondLeftScore.setPoints(pointsThird);
                            }
                        }
                    }

                    //No double strike, check if previous score was a spare
                    else if (firstLeftScore != null && checkIsSpare(firstLeftScore)) {

                        //if secondLeft is available
                        if(secondLeftScore != null){
                            int points = secondLeftScore.getPoints() + strikeFullPoints;
                            firstLeftScore.setPoints(points);
                        }
                        else {
                            System.out.println("STRIKE: Previous was a Spare!");
                            int points = firstLeftScore.getPoints() + strikeFullPoints;
                            firstLeftScore.setPoints(points);
                        }

                    }
                    //Previous was not spare, do nothing then
                    else if (firstLeftScore != null && checkIsNormalPoints(firstLeftScore)) {
                        System.out.println("STRIKE: Previous was a not Spare! NOTHING HAPPENS");
                        //Do Nothing
                    }
                }
            }

            //Check if current score is a spare
            else if (checkIsSpare(currentSc)) {

                System.out.println("IN Spare!");
                if(finalRound){
                    System.out.println("SPARE: FINAL ROUND!");

                    //Check if firstLeft was a strike
                    if (firstLeftScore != null && checkIsStrike(firstLeftScore)) {
                        System.out.println("SPARE: PREVIOUS WAS A STRIKE!");
                        int points = secondLeftScore.getPoints() + strikeFullPoints;
                        firstLeftScore.setPoints(points);
                        //This will fuck up if prev is id1, a strike, but there is not second
                    }

                    //Check if previous was a spare
                    else if (firstLeftScore != null && checkIsSpare(firstLeftScore)) {
                        if(secondLeftScore != null){
                            System.out.println("SPARE: PREVIOUS WAS A SPARE!");
                            System.out.println("SPARE: PREVIOUS WAS A SPARE! CHECKING FOR SECOND SPARE");
                            int points = secondLeftScore.getPoints() + sparePoints + currentSc.getFirstScoreFramePoint();
                            firstLeftScore.setPoints(points);
                        } else {
                            System.out.println("DON't TAKE ");
                            int points = firstLeftScore.getPoints() + sparePoints + currentSc.getFirstScoreFramePoint();
                            firstLeftScore.setPoints(points);
                        }

                    }

                    int points = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc);
                    currentSc.setPoints(points);

                } else {

                    System.out.println("Here atleast");
                    //Check if previous was a strike
                    if (firstLeftScore != null && checkIsStrike(firstLeftScore)) {
                        System.out.println("SPARE: PREVIOUS WAS A STRIKE!");
                        int points = secondLeftScore.getPoints() + strikeFullPoints;
                        firstLeftScore.setPoints(points);
                    }

                    //Check if previous was a spare
                    else if (firstLeftScore != null && checkIsSpare(firstLeftScore)) {
                        if(secondLeftScore != null){
                            System.out.println("WTF doing here!?");
                            System.out.println("SPARE: PREVIOUS WAS A SPARE!");
                            System.out.println("SPARE: PREVIOUS WAS A SPARE! Followed by another spare!");
                            int points = secondLeftScore.getPoints() + sparePoints + currentSc.getFirstScoreFramePoint();
                            firstLeftScore.setPoints(points);
                        } else {
                            System.out.println("DON't TAKE ");
                            int points = firstLeftScore.getPoints() + sparePoints + currentSc.getFirstScoreFramePoint();
                            firstLeftScore.setPoints(points);
                        }

                            int points = firstLeftScore.getPoints() + sparePoints+ calcCurrentScoreFramePointSum(currentSc);
                            firstLeftScore.setPoints(points);
                        }

                    //if previous was a spare, but game is short
                    else if (firstLeftScore != null && checkIsNormalPoints(firstLeftScore)) {
                        if (finalRound) {
                            System.out.println("SPARE: PREVIOUS WAS A SPARE!");
                            int points = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc);
                            currentSc.setPoints(points);
                        }

                    }
                }
            }

            //If current score is not strike or spare
            else if (checkIsNormalPoints(currentSc)) {
                System.out.println("IN Normal Points!");

                if(finalRound){
                    System.out.println("NORMAL: FINAL ROUND!");
                    int points = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc);
                    currentSc.setPoints(points);

                }

                //Check if previous was a strike
                if (firstLeftScore != null && checkIsStrike(firstLeftScore)) {

                    //Check if left score is available
                    if (secondLeftScore != null) {

                        //Check if secondLeft also was a strike
                        if(checkIsStrike(secondLeftScore)){

                            //Check if thirdleftscore is available
                            if(thirdLeftScore != null){

                                System.out.println("NORMAL: Third left is on, double strike");
                                int pointsSec = thirdLeftScore.getPoints() + secondLeftScore.getPoints() + strikeFullPoints + currentSc.getFirstScoreFramePoint();
                                secondLeftScore.setPoints(pointsSec);

                                int pointFirst = firstLeftScore.getPoints() + secondLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc);
                                firstLeftScore.setPoints(pointFirst);

                            } else {
                                System.out.println("NORMAL: Third left is NOT on, double strike");
                                int pointsSec = secondLeftScore.getPoints() + strikeFullPoints + currentSc.getFirstScoreFramePoint();
                                secondLeftScore.setPoints(pointsSec);

                                int pointFirst = secondLeftScore.getPoints() + strikeTenPoints + calcCurrentScoreFramePointSum(currentSc);
                                firstLeftScore.setPoints(pointFirst);

                                int pointCurrent = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc);
                                currentSc.setPoints(pointCurrent);
                            }


                        }
                        //PRev Was a strike, but no thirdLeft
                        else {

                            System.out.println("NORMAL: PREVIOUS WAS A STRIKE, but no third left");
                            int pointsFirstLeft = secondLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc) + strikeTenPoints;
                            firstLeftScore.setPoints(pointsFirstLeft);
                            int pointsCurrent = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentScoreFrameObject);
                            currentSc.setPoints(pointsCurrent);
                        }
                    }
                    //No second Left available
                    else {
                        System.out.println("NORMAL: PREVIOUS WAS A STRIKE, but no 2Left");
                        int pointsFirstLeft = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc) + strikeTenPoints;
                        firstLeftScore.setPoints(pointsFirstLeft);
                        int pointsCurrent = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentScoreFrameObject);
                        currentSc.setPoints(pointsCurrent);
                    }
                }



                //Check if previous was a spare
                else if (firstLeftScore != null && checkIsSpare(firstLeftScore)) {

                    if (secondLeftScore != null) {
                        System.out.println("NORMAL: PREVIOUS WAS A SPARE");
                        System.out.println("NORMAL: FIRST SCORE WAS SPARE!");
                        int firstPoints = secondLeftScore.getPoints() + sparePoints + currentSc.getFirstScoreFramePoint();
                        firstLeftScore.setPoints(firstPoints);

                        int currentPoints = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentScoreFrameObject);
                        currentSc.setPoints(currentPoints);
                    } else {

                        int firstPoints = firstLeftScore.getPoints() + sparePoints + currentSc.getFirstScoreFramePoint();
                        firstLeftScore.setPoints(firstPoints);

                        int currentPoints = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentScoreFrameObject);
                        currentSc.setPoints(currentPoints);
                    }

                }

                //Check if previous was not a strike or spare
                else if (firstLeftScore != null && checkIsNormalPoints(firstLeftScore)) {
                    System.out.println("NORMAL: PREVIOUS WAS NOT A SPARE OR STRIKE");
                    int points = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentScoreFrameObject);
                    currentSc.setPoints(points);
                } else {
                    int points = calcCurrentScoreFramePointSum(currentScoreFrameObject);
                    currentSc.setPoints(points);
                }
            }
        }


    currentSc = null;
    firstLeftScore = null;
    secondLeftScore = null;
    thirdLeftScore  = null;

    }

    public boolean checkFrameElevenStrikes(ScoreFrameObject currentScoreFrameObject){
        if(currentScoreFrameObject.getFirstScoreFramePoint() == 10 && currentScoreFrameObject.getFirstScoreFramePoint() == 10){
            System.out.println("SPECIAL BONUS STRIKE!!!!");
            return true;
        }
        System.out.println("No special bonus strike ):");
        return false;
    }

    public void assignDataObject(DataObject dataObject){
        dataObj = dataObject;
    }

    public int calcCurrentScoreFramePointSum(ScoreFrameObject currentScoreFrameObject){
        return currentScoreFrameObject.getFirstScoreFramePoint() + currentScoreFrameObject.getSecondScoreFramePoint();
    }

    public void temp_addToFinalPoints(DataObject dataObject){
        Random rand = new Random();
        System.out.println();

        for (int i = 0; i < dataObject.getListOfFrameScores().size(); i++) {
            dataObject.getFinalScoreList().add(rand.nextInt(11));
        }
    }

    public void notFinal_addToFinalPoints(Integer points, DataObject dataObject){
        dataObject.getFinalScoreList().add(points);
    }

    public void checkStrikes(ScoreFrameObject currentScoreFrameObject){
        if(checkTripleStrike(currentScoreFrameObject)){

        } else if(checkDoubleStrike(currentScoreFrameObject)) {

        }
    }


    public boolean checkTripleStrike(ScoreFrameObject currentScoreFrameObject){
        ScoreFrameObject prevScoreFrame = getFirstLeftScoreFrame(currentScoreFrameObject);
        ScoreFrameObject secondPrevScoreFrame = getSecondLeftScoreFrame(currentScoreFrameObject);
        if(checkIsStrike(currentScoreFrameObject) && prevScoreFrame != null && secondPrevScoreFrame != null && checkIsStrike(prevScoreFrame) && checkIsStrike(secondPrevScoreFrame)){

            secondPrevScoreFrame.setPoints(tripleStrikePoints);
            System.out.println("TRIPLE STRIKE!");
            return true;
        } else {
            System.out.println("NO TRIPLE STRIKE!");
            return false;
        }
    }

    public boolean checkDoubleStrike(ScoreFrameObject currentScoreFrameObject){

        ScoreFrameObject prevScoreFrame = getFirstLeftScoreFrame(currentScoreFrameObject);

        if(checkIsStrike(currentScoreFrameObject) && prevScoreFrame != null && checkIsStrike(prevScoreFrame)){
            System.out.println("Current and PRev was strike!");
            return true;
        } else {
            prevScoreFrame.setPoints(currentScoreFrameObject.getFirstScoreFramePoint() + sparePoints);
            System.out.println("PRev was NOT strike and current frame was not!");
            return false;
        }
    }

    public boolean checkCurrentFrameScore(ScoreFrameObject currentScoreFrameObject) {

        if (currentScoreFrameObject.getFrameID() > 2) {

            if (checkIsStrike(currentScoreFrameObject)) {
                checkSecondPreviousFrameScore(currentScoreFrameObject);
            } else if (checkIsSpare(currentScoreFrameObject)) {
                //Do nothing, because it's  it's a spare, nothing to calculate yet
                return true;
            } else {
                int points = calcCurrentScoreFramePointSum(currentScoreFrameObject);
                currentScoreFrameObject.setPoints(points);
                return true;
            }
        } else if (currentScoreFrameObject.getFrameID() > 1){

        }
        return false;
    }

    public void checkPreviousFrameScore(ScoreFrameObject currentScoreFrameObject){
        ScoreFrameObject prevScoreFrame = getFirstLeftScoreFrame(currentScoreFrameObject);
        ScoreFrameObject secondPrevScoreFrame = getSecondLeftScoreFrame(currentScoreFrameObject);

        if(checkIsStrike(prevScoreFrame)){

            //If prev is a strike, check for Triple strike
            checkSecondPreviousFrameScore(currentScoreFrameObject);

        } else if (checkIsSpare(prevScoreFrame)){
            if(secondPrevScoreFrame != null && checkIsStrike(secondPrevScoreFrame) ){
                int points = currentScoreFrameObject.getFirstScoreFramePoint() + secondPrevScoreFrame.getPoints() + sparePoints;
                prevScoreFrame.setPoints(points);
            } else {
                int points = secondPrevScoreFrame.getPoints() + calcCurrentScoreFramePointSum(currentScoreFrameObject) + sparePoints;
                prevScoreFrame.setPoints(points);
            }

        } else {

            currentScoreFrameObject.setPoints(prevScoreFrame.getPoints() + calcCurrentScoreFramePointSum(currentScoreFrameObject));
        }
    }

    public boolean checkSecondPreviousFrameScore(ScoreFrameObject currentScoreFrameObject){
        ScoreFrameObject secondPrevScoreFrame = getSecondLeftScoreFrame(currentScoreFrameObject);

        //If Triple strike in a row, 30 points to secondPrev, on top of the points of ThirdPrev
        if(secondPrevScoreFrame != null && checkIsStrike(secondPrevScoreFrame)){
            int points = getThirdLeftScoreFrame(currentScoreFrameObject).getPoints() + tripleStrikePoints;
            secondPrevScoreFrame.setPoints(points);
            return true;

        }
        //No triple strike in a row, third prev + curremt first frame + strikepoints bonus
        else if(secondPrevScoreFrame != null){
            int points = getThirdLeftScoreFrame(currentScoreFrameObject).getPoints() + currentScoreFrameObject.getFirstScoreFramePoint() + strikeFullPoints;
            getFirstLeftScoreFrame(currentScoreFrameObject).setPoints(points);
            return true;
        }
        return false;
    }

    public void checkingStrikes(){

    }

    public void checkIfPreviousStrike(ScoreFrameObject currentScoreFrameObject){

        //checkDoubleOrTripleStrike

        //Check that currentScore is not the first score, to avoid checking for strikes at -1, when trying to calculate for a series of Strikes
        if(currentScoreFrameObject.getFrameID() > 1){
            ScoreFrameObject prevScoreFrame = getFirstLeftScoreFrame(currentScoreFrameObject);

            if(checkIsStrike(currentScoreFrameObject)) {
                System.out.println("NICE! You got a strike!");

                //If prevScore is not null and is either a Strike (or Spare ?)
                if (prevScoreFrame != null && checkIsStrike(prevScoreFrame) /*|| prevScoreFrame != null && prevScoreFrame.isSpare()*/) {

                    //Check that currentScore is not the second score, to avoid checking for strikes at -1
                    if (currentScoreFrameObject.getFrameID() > 2) {
                        ScoreFrameObject secondPrevScoreFrame = getSecondLeftScoreFrame(currentScoreFrameObject);

                        //Third Strike in a row!
                        if (secondPrevScoreFrame != null && checkIsStrike(secondPrevScoreFrame)) {
                            secondPrevScoreFrame.setPoints(30);
                            System.out.println("THIRD STRIKE IN A ROW!");

                        } else {
                            System.out.println("NO STRIKE AT SECOND PREV!");
                        }
                    } else {

                        System.out.println("This is the second Score, no need to check for a series of strikes now");
                        System.out.println("MIGHT check for Spare or normal score!");
                    }
                } else {
                    System.out.println("NO STRIKE AT PREV!");
                }
            } else {

                System.out.println("NO STRIKE! GTFO!");

            }

        } else {
            System.out.println("This is the first Score, no need to check for a series of strikes now");
        }


    }

}
