package com.company.Calculations;

import com.company.ObjectClasses.ScoreAndPrevScoresObject;
import com.company.ObjectClasses.ScoreFrameObject;

//-------------------------------------------------------------!
//VERY BLOATED CLASS! NEEDS MORE WORK, STREAMLINING, TESTABILITY AND CLEANUP!
//-------------------------------------------------------------!

/**
 * Class for calculating the non-spare and non-strike scores*/
public class NonSpareStrikeCalculations {

    /**
     * Method for calculating the provided score, if it is not a spare or a strike */
    public void Calculating_NonSpareStrike(ScoreAndPrevScoresObject scoresObject, int gameLength){

        boolean finalRound = false;

        CheckType ct = new CheckType();
        BowlingPoints bp = new BowlingPoints();

        if(gameLength == scoresObject.getCurrentScore().getFrameID()){
            finalRound = true;
        }

        //If current score is not strike or spare
        if (ct.checkIsNormalPoints(scoresObject.getCurrentScore())) {
            if(finalRound){

                int points = scoresObject.getFirstLeftScore().getPoints() + calcCurrentScoreFramePointSum(scoresObject.getCurrentScore());
                scoresObject.getCurrentScore().setPoints(points);
            }
            //Check if previous was a strike
            if (scoresObject.getFirstLeftScore() != null && ct.checkIsStrike(scoresObject.getFirstLeftScore())) {

                //Check if left score is available
                if (scoresObject.getSecondLeftScore() != null) {

                    //Check if secondLeft also was a strike
                    if(ct.checkIsStrike(scoresObject.getSecondLeftScore())){

                        //Check if thirdleftscore is available
                        if(scoresObject.getThirdLeftScore() != null){


                            int pointsSec = scoresObject.getThirdLeftScore().getPoints() + scoresObject.getSecondLeftScore().getPoints() + bp.getStrikeFullPoints() + scoresObject.getCurrentScore().getFirstScoreFramePoint();
                            scoresObject.getSecondLeftScore().setPoints(pointsSec);

                            int pointFirst = scoresObject.getFirstLeftScore().getPoints() + scoresObject.getSecondLeftScore().getPoints() + calcCurrentScoreFramePointSum(scoresObject.getCurrentScore());
                            scoresObject.getFirstLeftScore().setPoints(pointFirst);

                        } else {

                            int pointsSec = scoresObject.getSecondLeftScore().getPoints() + bp.getStrikeFullPoints() + scoresObject.getCurrentScore().getFirstScoreFramePoint();
                            scoresObject.getSecondLeftScore().setPoints(pointsSec);

                            int pointFirst = scoresObject.getSecondLeftScore().getPoints() + bp.getStrikeTenPoints() + calcCurrentScoreFramePointSum(scoresObject.getCurrentScore());
                            scoresObject.getFirstLeftScore().setPoints(pointFirst);

                            int pointCurrent = scoresObject.getFirstLeftScore().getPoints() + calcCurrentScoreFramePointSum(scoresObject.getCurrentScore());
                            scoresObject.getCurrentScore().setPoints(pointCurrent);
                        }
                    }
                    //PRev Was a strike, but no thirdLeft
                    else {

                        int pointsFirstLeft = scoresObject.getSecondLeftScore().getPoints() + calcCurrentScoreFramePointSum(scoresObject.getCurrentScore()) + bp.getStrikeTenPoints();
                        scoresObject.getFirstLeftScore().setPoints(pointsFirstLeft);
                        int pointsCurrent = scoresObject.getFirstLeftScore().getPoints() + calcCurrentScoreFramePointSum(scoresObject.getCurrentScore());
                        scoresObject.getCurrentScore().setPoints(pointsCurrent);
                    }
                }
                //No second Left available
                else {

                    int pointsFirstLeft = scoresObject.getFirstLeftScore().getPoints() + calcCurrentScoreFramePointSum(scoresObject.getCurrentScore()) + bp.getStrikeTenPoints();
                    scoresObject.getFirstLeftScore().setPoints(pointsFirstLeft);
                    int pointsCurrent = scoresObject.getFirstLeftScore().getPoints() + calcCurrentScoreFramePointSum(scoresObject.getCurrentScore());
                    scoresObject.getCurrentScore().setPoints(pointsCurrent);
                }
            }
            //Check if previous was a spare
            else if (scoresObject.getFirstLeftScore() != null && ct.checkIsSpare(scoresObject.getFirstLeftScore())) {

                if (scoresObject.getSecondLeftScore() != null) {

                    int firstPoints = scoresObject.getSecondLeftScore().getPoints() + bp.getSparePoints() + scoresObject.getCurrentScore().getFirstScoreFramePoint();
                    scoresObject.getFirstLeftScore().setPoints(firstPoints);

                    int currentPoints = scoresObject.getFirstLeftScore().getPoints() + calcCurrentScoreFramePointSum(scoresObject.getCurrentScore());
                    scoresObject.getCurrentScore().setPoints(currentPoints);
                } else {

                    int firstPoints = scoresObject.getFirstLeftScore().getPoints() + bp.getSparePoints() + scoresObject.getCurrentScore().getFirstScoreFramePoint();
                    scoresObject.getFirstLeftScore().setPoints(firstPoints);

                    int currentPoints = scoresObject.getFirstLeftScore().getPoints() + calcCurrentScoreFramePointSum(scoresObject.getCurrentScore());
                    scoresObject.getCurrentScore().setPoints(currentPoints);
                }
            }
            //Check if previous was not a strike or spare
            else if (scoresObject.getFirstLeftScore() != null && ct.checkIsNormalPoints(scoresObject.getFirstLeftScore())) {
                int points = scoresObject.getFirstLeftScore().getPoints() + calcCurrentScoreFramePointSum(scoresObject.getCurrentScore());
                scoresObject.getCurrentScore().setPoints(points);
            } else {
                int points = calcCurrentScoreFramePointSum(scoresObject.getCurrentScore());
                scoresObject.getCurrentScore().setPoints(points);
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
