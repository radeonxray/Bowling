package com.company.CalculationsVerTwo;
import com.company.Calculations.BowlingPoints;
import com.company.ObjectClasses.ScoreAndPrevScoresObject;


/**Class for calculating a scoreobject that has been identified as a STRIKE*/
public class StrikeCalculationVerTwo {

    BowlingPoints bp = new BowlingPoints();
    /**
     * Method that calculates the points for the provided Strike object*/
    public void calculateStrike(ScoreAndPrevScoresObject objList){

        if(objList.getFirstLeftScore() != null){
            if ( objList.getFirstLeftScore().getScoreType().toString() == "STRIKE") {
                checkIfTripleStrike(objList);
            }
            if (objList.getFirstLeftScore().getScoreType().toString() == "SPARE"){
                checkIfPreviousWasSpare(objList);
            }
        }

        /*No need to check for:
        SingleStrike
        DoubleStrike
        Normal Score
        * */
    }

    /**
     * Method that checks for bonus point calculations, if the current score and the 2 previous scores all are strikes*/
    public void checkIfTripleStrike(ScoreAndPrevScoresObject objList) {

        if (objList.getThirdLeftScore() != null) {

            if (objList.getFirstLeftScore() != null && objList.getFirstLeftScore().getScoreType().toString() == "STRIKE") {

                System.out.println("Current is " + objList.getCurrentScore().getScoreType().toString() +
                        ", FirstLeft is " + objList.getFirstLeftScore().getScoreType().toString());

                if (objList.getSecondLeftScore() != null && objList.getSecondLeftScore().getScoreType().toString() == "STRIKE") {
                    System.out.println("Current is " + objList.getCurrentScore().getScoreType().toString() +
                            ", FirstLeft is " + objList.getFirstLeftScore().getScoreType().toString() +
                            ", SecondLeft is " + objList.getSecondLeftScore().getScoreType().toString());
                    int threeOrAboveScores_firstStrikeInTripleStrike_points = objList.getThirdLeftScore().getPoints() + bp.getTripleStrikePoints();
                    objList.getSecondLeftScore().setPoints(threeOrAboveScores_firstStrikeInTripleStrike_points);
                }
            }
        } else {

            if (objList.getFirstLeftScore() != null && objList.getFirstLeftScore().getScoreType().toString() == "STRIKE") {

                System.out.println("Current is " + objList.getCurrentScore().getScoreType().toString() +
                        ", FirstLeft is " + objList.getFirstLeftScore().getScoreType().toString());

                if (objList.getSecondLeftScore() != null && objList.getSecondLeftScore().getScoreType().toString() == "STRIKE") {
                    System.out.println("Current is " + objList.getCurrentScore().getScoreType().toString() +
                            ", FirstLeft is " + objList.getFirstLeftScore().getScoreType().toString() +
                            ", SecondLeft is " + objList.getSecondLeftScore().getScoreType().toString());

                    int threeOrBelowScores_firstStrikeInTripleStrike_points = objList.getSecondLeftScore().getPoints() + bp.getTripleStrikePoints();
                    objList.getSecondLeftScore().setPoints(threeOrBelowScores_firstStrikeInTripleStrike_points);
                }
            }
        }
    }

    /**
     * Method that checks for bonus point calculations, if the current score is a strike and the previous score was a spare*/
    public void checkIfPreviousWasSpare(ScoreAndPrevScoresObject objList){

        if(objList.getSecondLeftScore() != null){
            if(objList.getFirstLeftScore().getScoreType().toString() == "SPARE"){
                int twoOrBelowScores_strikeAfterSpare_points = objList.getSecondLeftScore().getPoints() + bp.getStrikeFullPoints();
                objList.getFirstLeftScore().setPoints( twoOrBelowScores_strikeAfterSpare_points);
            }
        } else {
            if(objList.getFirstLeftScore().getScoreType().toString() == "SPARE"){
                int oneOrBelowScores_strikeAfterSpare_points = bp.getStrikeFullPoints();
                objList.getFirstLeftScore().setPoints(oneOrBelowScores_strikeAfterSpare_points);
            }
        }
    }



}
