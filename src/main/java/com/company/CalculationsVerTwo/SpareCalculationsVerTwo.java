package com.company.CalculationsVerTwo;

import com.company.Calculations.BowlingPoints;
import com.company.ObjectClasses.ScoreAndPrevScoresObject;
import com.company.ObjectClasses.ScoreFrameObject;

/**Class for calculating a scoreobject that has been identified as a SPARE*/
public class SpareCalculationsVerTwo {

    BowlingPoints bp = new BowlingPoints();

    /**
     * Method that calculates the points for the provided SPARE object*/
    public void calculateSpare(ScoreAndPrevScoresObject objList){

        if(objList.getFirstLeftScore() != null){
            if(objList.getFirstLeftScore().getScoreType().toString() == "STRIKE") {
                if(objList.getSecondLeftScore() != null && objList.getSecondLeftScore().getScoreType().toString() == "STRIKE"){
                    ifPreviousWasDoubleStrike(objList);
                } else {
                    ifPreviousWasStrike(objList);
                }
            }

            if(objList.getFirstLeftScore().getScoreType().toString() == "SPARE"){
                if( objList.getSecondLeftScore() != null && objList.getSecondLeftScore().getScoreType().toString() == "SPARE"){
                    ifPreviousDoubleSpare(objList);
                } else if(objList.getSecondLeftScore() != null && objList.getSecondLeftScore().getScoreType().toString() == "STRIKE"){
                    ifStrikeBeforePreviousSpare(objList);
                }
                else {
                    ifPreviousWasSpare(objList);
                }
                }
        }

    }

    /**Method for calculating the current score of type SPARE, if the previous score was of type STRIKE*/
    public void ifPreviousWasStrike(ScoreAndPrevScoresObject objList){

        if(objList.getSecondLeftScore() != null){

            int pointsStrikeBeforeSpare_secondNotNull = objList.getSecondLeftScore().getPoints() + bp.getStrikeFullPoints();
            objList.getFirstLeftScore().setPoints(pointsStrikeBeforeSpare_secondNotNull);

        } else {

            int pointsStrikeBeforeSpare = bp.getStrikeFullPoints();
            objList.getFirstLeftScore().setPoints(pointsStrikeBeforeSpare);
        }
    }

    /** Method for calculating the current score, if the current score is of type SPARE and the previous two scores were both of type STRIKE*/
    public void ifPreviousWasDoubleStrike(ScoreAndPrevScoresObject objList) {
        if (objList.getThirdLeftScore() != null) {

            int points_secondLeft_DoubleStrikeBeforeSPARE_thirdNotNull = objList.getThirdLeftScore().getPoints() + objList.getCurrentScore().getFirstScoreFramePoint() + bp.getStrikeFullPoints();
            objList.getSecondLeftScore().setPoints(points_secondLeft_DoubleStrikeBeforeSPARE_thirdNotNull);

            int points_firstLeft_DoubleStrikeBeforeSPARE_thirdNotNull = objList.getSecondLeftScore().getPoints() + bp.getStrikeFullPoints();
            objList.getFirstLeftScore().setPoints(points_firstLeft_DoubleStrikeBeforeSPARE_thirdNotNull);

        } else {

            int points_secondLeft_DoubleStrikeBeforeSPARE = objList.getSecondLeftScore().getPoints() + objList.getCurrentScore().getFirstScoreFramePoint() + bp.getStrikeFullPoints();
            objList.getSecondLeftScore().setPoints(points_secondLeft_DoubleStrikeBeforeSPARE);

            int points_firstLeft_DoubleStrikeBeforeSPARE = objList.getSecondLeftScore().getPoints() + bp.getStrikeFullPoints();
            objList.getFirstLeftScore().setPoints(points_firstLeft_DoubleStrikeBeforeSPARE);

        }
    }

    /**Method for calculating the current score if it was of type SPARE, and the previous score also was of type SPARE*/
    public void ifPreviousWasSpare(ScoreAndPrevScoresObject objList){

        if(objList.getFirstLeftScore() !=  null){
            int pointsForSpareBeforeSpare = objList.getFirstLeftScore().getPoints() + objList.getCurrentScore().getFirstScoreFramePoint() + bp.getSparePoints();
            objList.getFirstLeftScore().setPoints(pointsForSpareBeforeSpare);
        }
    }

    /**Method for calculating, if the previous 2 scores was of type SPARE*/
    public void ifPreviousDoubleSpare(ScoreAndPrevScoresObject objList){

        if(objList.getSecondLeftScore() != null){
            int pointsForSpareBeforeSpare = objList.getSecondLeftScore().getPoints() + objList.getCurrentScore().getFirstScoreFramePoint() + bp.getSparePoints();
            objList.getFirstLeftScore().setPoints(pointsForSpareBeforeSpare);
        }
    }

    /**Method for calculating the current score if the previous score was a SPARE and the score before that SPARE was a STRIKE*/
    public void ifStrikeBeforePreviousSpare(ScoreAndPrevScoresObject objList){

            int pointsForStrikeBeforePreviousSpare = objList.getSecondLeftScore().getPoints() + bp.getSparePoints()  + objList.getCurrentScore().getFirstScoreFramePoint();
            objList.getFirstLeftScore().setPoints(pointsForStrikeBeforePreviousSpare);
    }


}
