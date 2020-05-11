package com.company.Calculations;

import com.company.ObjectClasses.ScoreFrameObject;

//-------------------------------------------------------------!
//VERY BLOATED CLASS! NEEDS MORE WORK, STREAMLINING, TESTABILITY AND CLEANUP!
//-------------------------------------------------------------!

/**
 * Class for calculating the non-spare and non-strike scores*/
public class NonSpareStrikeCalculations {

    /**
     * Method for calculating the provided score, if it is not a spare or a strike */
    public void Calculating_NonSpareStrike(ScoreFrameObject currentScoreFrameObject,
                                           int gameLength, ScoreFrameObject firstLeftScore,
                                           ScoreFrameObject secondLeftScore, ScoreFrameObject thirdLeftScore){

        ScoreFrameObject currentSc = currentScoreFrameObject;

        boolean finalRound = false;

        CheckType ct = new CheckType();
        BowlingPoints bp = new BowlingPoints();

        if(gameLength == currentSc.getFrameID()){
            finalRound = true;
        }

        //If current score is not strike or spare
        if (ct.checkIsNormalPoints(currentSc)) {
            if(finalRound){

                int points = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc);
                currentSc.setPoints(points);
            }
            //Check if previous was a strike
            if (firstLeftScore != null && ct.checkIsStrike(firstLeftScore)) {

                //Check if left score is available
                if (secondLeftScore != null) {

                    //Check if secondLeft also was a strike
                    if(ct.checkIsStrike(secondLeftScore)){

                        //Check if thirdleftscore is available
                        if(thirdLeftScore != null){


                            int pointsSec = thirdLeftScore.getPoints() + secondLeftScore.getPoints() + bp.getStrikeFullPoints() + currentSc.getFirstScoreFramePoint();
                            secondLeftScore.setPoints(pointsSec);

                            int pointFirst = firstLeftScore.getPoints() + secondLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc);
                            firstLeftScore.setPoints(pointFirst);

                        } else {

                            int pointsSec = secondLeftScore.getPoints() + bp.getStrikeFullPoints() + currentSc.getFirstScoreFramePoint();
                            secondLeftScore.setPoints(pointsSec);

                            int pointFirst = secondLeftScore.getPoints() + bp.getStrikeTenPoints() + calcCurrentScoreFramePointSum(currentSc);
                            firstLeftScore.setPoints(pointFirst);

                            int pointCurrent = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc);
                            currentSc.setPoints(pointCurrent);
                        }
                    }
                    //PRev Was a strike, but no thirdLeft
                    else {

                        int pointsFirstLeft = secondLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc) + bp.getStrikeTenPoints();
                        firstLeftScore.setPoints(pointsFirstLeft);
                        int pointsCurrent = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentScoreFrameObject);
                        currentSc.setPoints(pointsCurrent);
                    }
                }
                //No second Left available
                else {

                    int pointsFirstLeft = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc) + bp.getStrikeTenPoints();
                    firstLeftScore.setPoints(pointsFirstLeft);
                    int pointsCurrent = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentScoreFrameObject);
                    currentSc.setPoints(pointsCurrent);
                }
            }
            //Check if previous was a spare
            else if (firstLeftScore != null && ct.checkIsSpare(firstLeftScore)) {

                if (secondLeftScore != null) {

                    int firstPoints = secondLeftScore.getPoints() + bp.getSparePoints() + currentSc.getFirstScoreFramePoint();
                    firstLeftScore.setPoints(firstPoints);

                    int currentPoints = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentScoreFrameObject);
                    currentSc.setPoints(currentPoints);
                } else {

                    int firstPoints = firstLeftScore.getPoints() + bp.getSparePoints() + currentSc.getFirstScoreFramePoint();
                    firstLeftScore.setPoints(firstPoints);

                    int currentPoints = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentScoreFrameObject);
                    currentSc.setPoints(currentPoints);
                }
            }
            //Check if previous was not a strike or spare
            else if (firstLeftScore != null && ct.checkIsNormalPoints(firstLeftScore)) {
                int points = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentScoreFrameObject);
                currentSc.setPoints(points);
            } else {
                int points = calcCurrentScoreFramePointSum(currentScoreFrameObject);
                currentSc.setPoints(points);
            }
        }
    }
    /**
     * Method for calculating the score frame 1 and 2 of a single score, used for when calculating non strikes or spares
     * @param  currentScoreFrameObject Takes a ScoreFrameObject
     * @return Returns the calculated score as an int*/
    public int calcCurrentScoreFramePointSum(ScoreFrameObject currentScoreFrameObject) {
        return currentScoreFrameObject.getFirstScoreFramePoint() + currentScoreFrameObject.getSecondScoreFramePoint();
    }
}
