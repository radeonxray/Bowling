package com.company.Calculations;


import com.company.ObjectClasses.ScoreAndPrevScoresObject;
import com.company.ObjectClasses.ScoreFrameObject;

//-------------------------------------------------------------!
//VERY BLOATED CLASS! NEEDS MORE WORK, STREAMLINING, TESTABILITY AND CLEANUP!
//-------------------------------------------------------------!

/**
 * Class for calculating the Strike scores*/
public class StrikeCalculations {

    /**Method for calculating the provided score, if it is a Strike
     */
    public void Calculating_Strike(ScoreAndPrevScoresObject scoresObject, int gameLength){

        CheckType ct = new CheckType();
        BowlingPoints bp = new BowlingPoints();

        boolean finalRound = false;

        if(gameLength == scoresObject.getCurrentScore().getFrameID()){
            finalRound = true;
        }
        //Check if current score is a strike
        if (ct.checkIsStrike(scoresObject.getCurrentScore())) {

            if(finalRound){

                if(calcCurrentScoreFramePointSum(scoresObject.getCurrentScore()) == 20){

                    int pointsSecond = scoresObject.getThirdLeftScore().getPoints() + bp.getTripleStrikePoints();
                    scoresObject.getSecondLeftScore().setPoints(pointsSecond);
                    int pointsFirst = scoresObject.getSecondLeftScore().getPoints() + bp.getTripleStrikePoints();
                    scoresObject.getFirstLeftScore().setPoints(pointsFirst);
                    scoresObject.getCurrentScore().setPoints(pointsFirst + bp.getTripleStrikePoints());

                } else if(ct.checkIsSpare(scoresObject.getFirstLeftScore())) {
                    int pointsFirst = bp.getStrikeFullPoints();
                    scoresObject.getFirstLeftScore().setPoints(pointsFirst);

                    int pointCurrent = calcCurrentScoreFramePointSum(scoresObject.getCurrentScore());
                    scoresObject.getCurrentScore().setPoints(pointCurrent);

                }else{

                    int points = scoresObject.getFirstLeftScore().getPoints() + calcCurrentScoreFramePointSum(scoresObject.getCurrentScore());
                    scoresObject.getCurrentScore().setPoints(points);
                }

            } else if(scoresObject.getCurrentScore().getFrameID() >= 2) {


                //Check if previous was a strike
                if (scoresObject.getFirstLeftScore() != null && ct.checkIsStrike(scoresObject.getFirstLeftScore()) && scoresObject.getCurrentScore().getFrameID() != 11) {

                    //Check for if the score before previous was a strike
                    if (scoresObject.getSecondLeftScore() != null && ct.checkIsStrike(scoresObject.getSecondLeftScore())) {

                        int points = scoresObject.getSecondLeftScore().getPoints() + bp.getTripleStrikePoints();
                        scoresObject.getSecondLeftScore().setPoints(points);

                        //Set points on the thirdLeft frame, if 3 strikes in a row!
                        if(scoresObject.getCurrentScore().getFrameID() >= 4 && scoresObject.getThirdLeftScore() != null && ct.checkIsStrike(scoresObject.getThirdLeftScore())){

                            int pointsThird = scoresObject.getThirdLeftScore().getPoints() + bp.getTripleStrikePoints();;
                            scoresObject.getSecondLeftScore().setPoints(pointsThird);
                        }
                    }
                }

                //No double strike, check if previous score was a spare
                else if (scoresObject.getFirstLeftScore() != null && ct.checkIsSpare(scoresObject.getFirstLeftScore())) {

                    //if secondLeft is available
                    if(scoresObject.getSecondLeftScore() != null){
                        int points = scoresObject.getSecondLeftScore().getPoints() + bp.getStrikeFullPoints();
                        scoresObject.getFirstLeftScore().setPoints(points);
                    }
                    else {

                        int points = scoresObject.getFirstLeftScore().getPoints() + bp.getStrikeFullPoints();
                        scoresObject.getFirstLeftScore().setPoints(points);
                    }

                }
                //Previous was not spare, do nothing then
                else if (scoresObject.getFirstLeftScore() != null && ct.checkIsNormalPoints(scoresObject.getFirstLeftScore())) {

                    //Do Nothing
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
