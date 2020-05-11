package com.company.Calculations;
import com.company.ObjectClasses.ScoreFrameObject;

//-------------------------------------------------------------!
//VERY BLOATED CLASS! NEEDS MORE WORK, STREAMLINING, TESTABILITY AND CLEANUP!
//-------------------------------------------------------------!

/**
 * Class for calculating the Spare Scores*/
public class SpareCalculations {

    /**
     * Method for calculating the provided score, if it is a Spare*/
    public void Calculating_Spare(ScoreFrameObject currentScoreFrameObject,
                                  int gameLength, ScoreFrameObject firstLeftScore,
                                  ScoreFrameObject secondLeftScore, ScoreFrameObject thirdLeftScore){

        ScoreFrameObject currentSc = currentScoreFrameObject;
        CheckType ct = new CheckType();
        BowlingPoints bp = new BowlingPoints();

        boolean finalRound = false;

        if(gameLength == currentSc.getFrameID()){
            finalRound = true;
        }
        //Check if current score is a spare
            if (ct.checkIsSpare(currentSc)) {

            if(finalRound){

                //Check if firstLeft was a strike
                if (firstLeftScore != null && ct.checkIsStrike(firstLeftScore)) {
                    int points = secondLeftScore.getPoints() + bp.getStrikeFullPoints();
                    firstLeftScore.setPoints(points);
                    //This will fuck up if prev is id1, a strike, but there is not second
                }

                //Check if previous was a spare
                else if (firstLeftScore != null && ct.checkIsSpare(firstLeftScore)) {
                    if(secondLeftScore != null){
                        int points = secondLeftScore.getPoints() + bp.getSparePoints() + currentSc.getFirstScoreFramePoint();
                        firstLeftScore.setPoints(points);
                    } else {
                        int points = firstLeftScore.getPoints() + bp.getSparePoints() + currentSc.getFirstScoreFramePoint();
                        firstLeftScore.setPoints(points);
                    }

                }

                int points = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc);
                currentSc.setPoints(points);

            } else {
                //Check if previous was a strike
                if (firstLeftScore != null && ct.checkIsStrike(firstLeftScore)) {
                    int points = secondLeftScore.getPoints() + bp.getStrikeFullPoints();
                    firstLeftScore.setPoints(points);
                }

                //Check if previous was a spare
                else if (firstLeftScore != null && ct.checkIsSpare(firstLeftScore)) {
                    if(secondLeftScore != null){
                        int points = secondLeftScore.getPoints() + bp.getSparePoints() + currentSc.getFirstScoreFramePoint();
                        firstLeftScore.setPoints(points);
                    } else {
                        int points = firstLeftScore.getPoints() + bp.getSparePoints() + currentSc.getFirstScoreFramePoint();
                        firstLeftScore.setPoints(points);
                    }

                    int points = firstLeftScore.getPoints() + bp.getSparePoints() + calcCurrentScoreFramePointSum(currentSc);
                    firstLeftScore.setPoints(points);
                }

                //if previous was a spare, but game is short
                else if (firstLeftScore != null && ct.checkIsNormalPoints(firstLeftScore)) {
                    if (finalRound) {
                        int points = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc);
                        currentSc.setPoints(points);
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
