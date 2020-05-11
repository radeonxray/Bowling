package com.company.Calculations;


import com.company.ObjectClasses.ScoreFrameObject;

//-------------------------------------------------------------!
//VERY BLOATED CLASS! NEEDS MORE WORK, STREAMLINING, TESTABILITY AND CLEANUP!
//-------------------------------------------------------------!

/**
 * Class for calculating the Strike scores*/
public class StrikeCalculations {

    /**Method for calculating the provided score, if it is a Strike
     */
    public void Calculating_Strike(ScoreFrameObject currentScoreFrameObject, int gameLength,
                                   ScoreFrameObject firstLeftScore,
                                   ScoreFrameObject secondLeftScore,
                                   ScoreFrameObject thirdLeftScore){

        ScoreFrameObject currentSc = currentScoreFrameObject;

        CheckType ct = new CheckType();
        BowlingPoints bp = new BowlingPoints();

        boolean finalRound = false;

        if(gameLength == currentSc.getFrameID()){
            finalRound = true;
        }
        //Check if current score is a strike
        if (ct.checkIsStrike(currentSc)) {

            if(finalRound){

                if(calcCurrentScoreFramePointSum(currentSc) == 20){

                    int pointsSecond = thirdLeftScore.getPoints() + bp.getTripleStrikePoints();
                    secondLeftScore.setPoints(pointsSecond);
                    int pointsFirst = secondLeftScore.getPoints() + bp.getTripleStrikePoints();
                    firstLeftScore.setPoints(pointsFirst);
                    currentSc.setPoints(pointsFirst + bp.getTripleStrikePoints());

                } else if(ct.checkIsSpare(firstLeftScore)) {
                    int pointsFirst = bp.getStrikeFullPoints();
                    firstLeftScore.setPoints(pointsFirst);

                    int pointCurrent = calcCurrentScoreFramePointSum(currentSc);
                    currentSc.setPoints(pointCurrent);

                }else{

                    int points = firstLeftScore.getPoints() + calcCurrentScoreFramePointSum(currentSc);
                    currentSc.setPoints(points);
                }

            } else if(currentSc.getFrameID() >= 2) {


                //Check if previous was a strike
                if (firstLeftScore != null && ct.checkIsStrike(firstLeftScore) && currentSc.getFrameID() != 11) {

                    //Check for if the score before previous was a strike
                    if (secondLeftScore != null && ct.checkIsStrike(secondLeftScore)) {

                        int points = secondLeftScore.getPoints() + bp.getTripleStrikePoints();
                        secondLeftScore.setPoints(points);

                        //Set points on the thirdLeft frame, if 3 strikes in a row!
                        if(currentSc.getFrameID() >= 4 && thirdLeftScore != null && ct.checkIsStrike(thirdLeftScore)){

                            int pointsThird = thirdLeftScore.getPoints() + bp.getTripleStrikePoints();;
                            secondLeftScore.setPoints(pointsThird);
                        }
                    }
                }

                //No double strike, check if previous score was a spare
                else if (firstLeftScore != null && ct.checkIsSpare(firstLeftScore)) {

                    //if secondLeft is available
                    if(secondLeftScore != null){
                        int points = secondLeftScore.getPoints() + bp.getStrikeFullPoints();
                        firstLeftScore.setPoints(points);
                    }
                    else {

                        int points = firstLeftScore.getPoints() + bp.getStrikeFullPoints();
                        firstLeftScore.setPoints(points);
                    }

                }
                //Previous was not spare, do nothing then
                else if (firstLeftScore != null && ct.checkIsNormalPoints(firstLeftScore)) {

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
