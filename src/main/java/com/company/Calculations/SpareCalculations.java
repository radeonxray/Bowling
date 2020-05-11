package com.company.Calculations;
import com.company.ObjectClasses.ScoreAndPrevScoresObject;
import com.company.ObjectClasses.ScoreFrameObject;

//-------------------------------------------------------------!
//VERY BLOATED CLASS! NEEDS MORE WORK, STREAMLINING, TESTABILITY AND CLEANUP!
//-------------------------------------------------------------!

/**
 * Class for calculating the Spare Scores*/
public class SpareCalculations {

    /**
     * Method for calculating the provided score, if it is a Spare*/
    public void Calculating_Spare(ScoreAndPrevScoresObject scoresObject, int gameLength){

        CheckType ct = new CheckType();
        BowlingPoints bp = new BowlingPoints();

        boolean finalRound = false;

        if(gameLength == scoresObject.getCurrentScore().getFrameID()){
            finalRound = true;
        }
        //Check if current score is a spare
            if (ct.checkIsSpare(scoresObject.getCurrentScore())) {

            if(finalRound){

                //Check if firstLeft was a strike
                if (scoresObject.getFirstLeftScore() != null && ct.checkIsStrike(scoresObject.getFirstLeftScore())) {
                    int points = scoresObject.getSecondLeftScore().getPoints() + bp.getStrikeFullPoints();
                    scoresObject.getFirstLeftScore().setPoints(points);
                    //This will fuck up if prev is id1, a strike, but there is not second
                }

                //Check if previous was a spare
                else if (scoresObject.getFirstLeftScore() != null && ct.checkIsSpare(scoresObject.getFirstLeftScore())) {
                    if(scoresObject.getSecondLeftScore() != null){
                        int points = scoresObject.getSecondLeftScore().getPoints() + bp.getSparePoints() + scoresObject.getCurrentScore().getFirstScoreFramePoint();
                        scoresObject.getFirstLeftScore().setPoints(points);
                    } else {
                        int points = scoresObject.getFirstLeftScore().getPoints() + bp.getSparePoints() + scoresObject.getCurrentScore().getFirstScoreFramePoint();
                        scoresObject.getFirstLeftScore().setPoints(points);
                    }

                }

                int points = scoresObject.getFirstLeftScore().getPoints() + calcCurrentScoreFramePointSum(scoresObject.getCurrentScore());
                scoresObject.getCurrentScore().setPoints(points);

            } else {
                //Check if previous was a strike
                if (scoresObject.getFirstLeftScore() != null && ct.checkIsStrike(scoresObject.getFirstLeftScore())) {
                    int points = scoresObject.getSecondLeftScore().getPoints() + bp.getStrikeFullPoints();
                    scoresObject.getFirstLeftScore().setPoints(points);
                }

                //Check if previous was a spare
                else if (scoresObject.getFirstLeftScore() != null && ct.checkIsSpare(scoresObject.getFirstLeftScore())) {
                    if(scoresObject.getSecondLeftScore() != null){
                        int points = scoresObject.getSecondLeftScore().getPoints() + bp.getSparePoints() + scoresObject.getCurrentScore().getFirstScoreFramePoint();
                        scoresObject.getFirstLeftScore().setPoints(points);
                    } else {
                        int points = scoresObject.getFirstLeftScore().getPoints() + bp.getSparePoints() + scoresObject.getCurrentScore().getFirstScoreFramePoint();
                        scoresObject.getFirstLeftScore().setPoints(points);
                    }

                    int points = scoresObject.getFirstLeftScore().getPoints() + bp.getSparePoints() + calcCurrentScoreFramePointSum(scoresObject.getCurrentScore());
                    scoresObject.getFirstLeftScore().setPoints(points);
                }

                //if previous was a spare, but game is short
                else if (scoresObject.getFirstLeftScore() != null && ct.checkIsNormalPoints(scoresObject.getFirstLeftScore())) {
                    if (finalRound) {
                        int points = scoresObject.getFirstLeftScore().getPoints() + calcCurrentScoreFramePointSum(scoresObject.getCurrentScore());
                        scoresObject.getCurrentScore().setPoints(points);
                    }

                }
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
