package com.company.CalculationsVerTwo;

import com.company.Calculations.BowlingPoints;
import com.company.ObjectClasses.ScoreAndPrevScoresObject;
import com.company.ObjectClasses.ScoreFrameObject;

/**Class for calculating a scoreobject that has been identified as a SPARE
 * WARNING! NOT WORKING AS INTENDED ACCORDING TO SOME TEST!*/
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
                ifPreviousWasSpare(objList);
            }
        }




    }

    /**
     * Method for calculating the current SPARE, if the previous score was a STRIKE*/
    public void ifPreviousWasStrike(ScoreAndPrevScoresObject objList){

        if(objList.getSecondLeftScore() != null){

            //System.out.println("NOT NULL! " + objList.getSecondLeftScore().getPoints() + " : " );
            int pointsStrikeBeforeSpare_secondNotNull = objList.getSecondLeftScore().getPoints() + bp.getStrikeFullPoints();
            objList.getFirstLeftScore().setPoints(pointsStrikeBeforeSpare_secondNotNull);
            System.out.println(objList.getFirstLeftScore().getPoints());

        } else {

            int pointsStrikeBeforeSpare = bp.getStrikeFullPoints();
            objList.getFirstLeftScore().setPoints(pointsStrikeBeforeSpare);
        }


    }

    /**
     * NOT WORKING AS INTENDED!
     * Should calculate the score of the two preceeding STRIKES, if the current is a SPARE*/
    public void ifPreviousWasDoubleStrike(ScoreAndPrevScoresObject objList) {
        if (objList.getThirdLeftScore() != null) {

            int points_secondLeft_DoubleStrikeBeforeSPARE_thirdNotNull = objList.getThirdLeftScore().getPoints() + objList.getCurrentScore().getFirstScoreFramePoint() + bp.getStrikeFullPoints();
            objList.getSecondLeftScore().setPoints(points_secondLeft_DoubleStrikeBeforeSPARE_thirdNotNull);

            int points_firstLeft_DoubleStrikeBeforeSPARE_thirdNotNull = objList.getSecondLeftScore().getPoints() + bp.getStrikeFullPoints();
            objList.getFirstLeftScore().setPoints(points_firstLeft_DoubleStrikeBeforeSPARE_thirdNotNull);
            System.out.println(points_firstLeft_DoubleStrikeBeforeSPARE_thirdNotNull + " first! NOT NULL");
            System.out.println(points_secondLeft_DoubleStrikeBeforeSPARE_thirdNotNull + " SECOND! NOT NULL");

        } else {

            int points_secondLeft_DoubleStrikeBeforeSPARE = objList.getSecondLeftScore().getPoints() + objList.getCurrentScore().getFirstScoreFramePoint() + bp.getStrikeFullPoints();
            objList.getSecondLeftScore().setPoints(points_secondLeft_DoubleStrikeBeforeSPARE);

            int points_firstLeft_DoubleStrikeBeforeSPARE = objList.getSecondLeftScore().getPoints() + bp.getStrikeFullPoints();
            objList.getFirstLeftScore().setPoints(points_firstLeft_DoubleStrikeBeforeSPARE);

            System.out.println(points_firstLeft_DoubleStrikeBeforeSPARE + " first!");
            System.out.println(points_secondLeft_DoubleStrikeBeforeSPARE + " SECOND!");
        }
    }

    /**NO TEST CREATED OR TESTED!!
     * Method for calculating*/
    public void ifPreviousWasSpare(ScoreAndPrevScoresObject objList){

        if(objList.getFirstLeftScore() !=  null){
            int pointsForSpareBeforeSpare = objList.getFirstLeftScore().getPoints() + objList.getCurrentScore().getFirstScoreFramePoint() + bp.getSparePoints();
            objList.getFirstLeftScore().setPoints(pointsForSpareBeforeSpare);
        }

    }




}
