package com.company.CalculationsVerTwo;

import com.company.Calculations.BowlingPoints;
import com.company.ObjectClasses.ScoreAndPrevScoresObject;
import com.company.ObjectClasses.ScoreFrameObject;

/**Class for calculating a scoreobject that has been identified as NORMAL (Not a STRIKE or SPARE)*/
public class NormalCalculationsVerTwo {

    BowlingPoints bp = new BowlingPoints();

    /**
     * Method that calculates the points for the provided NORMAL object*/
    public void calculateNormal(ScoreAndPrevScoresObject objList){

        if(objList.getFirstLeftScore() != null){

            if(objList.getSecondLeftScore() != null && objList.getSecondLeftScore().getScoreType().toString() == "STRIKE"){
                ifPreviousWasDoubleStrike(objList);
            } else if(objList.getFirstLeftScore().getScoreType().toString() == "STRIKE") {
                ifPreviousWasStrike(objList);
            }

            if(objList.getFirstLeftScore().getScoreType().toString() == "SPARE"){
            ifPreviousWasSpare(objList);
            }

            if(objList.getFirstLeftScore().getScoreType().toString() == "NORMAL"){
            ifPreviousWasNormal(objList);
            }

        } else {
        setFirstScore(objList);
        }
    }

    /**
     * Method for Calculating points if previous score was a STRIKE*/
    public void ifPreviousWasStrike(ScoreAndPrevScoresObject objList){

        if(objList.getSecondLeftScore() != null){

                int pointsStrikeBeforeNormal_SecondNotNull = objList.getSecondLeftScore().getPoints() + calculateFramePoints(objList.getCurrentScore()) + bp.getStrikeTenPoints();
                objList.getFirstLeftScore().setPoints(pointsStrikeBeforeNormal_SecondNotNull);

                int pointsForNormalAfterStrike_SecondNotNull = objList.getFirstLeftScore().getPoints() + calculateFramePoints(objList.getCurrentScore());
                objList.getCurrentScore().setPoints(pointsForNormalAfterStrike_SecondNotNull);

        } else {

                int pointsStrikeBeforeNormal = calculateFramePoints(objList.getCurrentScore()) + bp.getStrikeTenPoints();
                objList.getFirstLeftScore().setPoints(pointsStrikeBeforeNormal);

                int pointsForNormalAfterStrike = objList.getFirstLeftScore().getPoints() + calculateFramePoints(objList.getCurrentScore());
                objList.getCurrentScore().setPoints(pointsForNormalAfterStrike);
        }

    }

    /**Method for Calculating if a current score is NORMAL and the previous 2 scores were both Strikes*/
    public void ifPreviousWasDoubleStrike(ScoreAndPrevScoresObject objList){

        if(objList.getThirdLeftScore() != null){

            int points_secondLeft_DoubleStrikeBeforeNormal_thirdNotNull = objList.getThirdLeftScore().getPoints() + objList.getCurrentScore().getFirstScoreFramePoint() + bp.getStrikeFullPoints();
            objList.getSecondLeftScore().setPoints(points_secondLeft_DoubleStrikeBeforeNormal_thirdNotNull);

            int points_firstLeft_DoubleStrikeBeforeNormal_thirdNotNull = objList.getSecondLeftScore().getPoints() + calculateFramePoints(objList.getCurrentScore()) + bp.getStrikeTenPoints();
            objList.getFirstLeftScore().setPoints(points_firstLeft_DoubleStrikeBeforeNormal_thirdNotNull);

            int pointsForNormalAfterDoubleStrike_thirdNotNull = objList.getFirstLeftScore().getPoints() + calculateFramePoints(objList.getCurrentScore());
            objList.getCurrentScore().setPoints(pointsForNormalAfterDoubleStrike_thirdNotNull);

        } else {

            int points_secondLeft_DoubleStrikeBeforeNormal = objList.getSecondLeftScore().getPoints() + objList.getCurrentScore().getFirstScoreFramePoint() + bp.getStrikeFullPoints();
            objList.getSecondLeftScore().setPoints(points_secondLeft_DoubleStrikeBeforeNormal);

            int points_firstLeft_DoubleStrikeBeforeNormal = objList.getSecondLeftScore().getPoints() + calculateFramePoints(objList.getCurrentScore()) + bp.getStrikeTenPoints();
            objList.getFirstLeftScore().setPoints(points_firstLeft_DoubleStrikeBeforeNormal);

            int pointsForNormalAfterDoubleStrike = objList.getFirstLeftScore().getPoints() + calculateFramePoints(objList.getCurrentScore());
            objList.getCurrentScore().setPoints(pointsForNormalAfterDoubleStrike);

        }

    }

    /**
     * Method for Calculating the score, if the current is a NORMAL score and the previous was a SPARE*/
    public void ifPreviousWasSpare(ScoreAndPrevScoresObject objList){

        if(objList.getSecondLeftScore() != null){
            System.out.println("No WAY!");
            int pointsSpareBeforeNormal_SecondNotNull = objList.getSecondLeftScore().getPoints() + objList.getCurrentScore().getFirstScoreFramePoint() + bp.getSparePoints();
            objList.getFirstLeftScore().setPoints(pointsSpareBeforeNormal_SecondNotNull);

            int pointsForNormalAfterSpare_SecondNotNull = objList.getFirstLeftScore().getPoints() + calculateFramePoints(objList.getCurrentScore());
            objList.getCurrentScore().setPoints(pointsForNormalAfterSpare_SecondNotNull);

        } else {

            int pointsSpareBeforeNormal_SecondNotNull = objList.getFirstLeftScore().getPoints() + objList.getCurrentScore().getFirstScoreFramePoint() + bp.getSparePoints();
            objList.getFirstLeftScore().setPoints(pointsSpareBeforeNormal_SecondNotNull);

            int pointsForNormalAfterSpare_SecondNotNull = objList.getFirstLeftScore().getPoints() + calculateFramePoints(objList.getCurrentScore());
            objList.getCurrentScore().setPoints(pointsForNormalAfterSpare_SecondNotNull);
        }
    }

    /**
     * Method for calculating the score, if the current and previous score were a NORMAL score*/
    public void ifPreviousWasNormal(ScoreAndPrevScoresObject objList){

        int pointsForNormalAfterNormal = objList.getFirstLeftScore().getPoints() + calculateFramePoints(objList.getCurrentScore());
        objList.getCurrentScore().setPoints(pointsForNormalAfterNormal);

    }

    /**
     * Method for setting the score, if the current score is NORMAL and is the first of the round!*/
    public void setFirstScore(ScoreAndPrevScoresObject objList){

        int pointsForFirstNormal =  calculateFramePoints(objList.getCurrentScore());
        objList.getCurrentScore().setPoints(pointsForFirstNormal);
    }

    /**Private method that takes a {@link ScoreFrameObject} and calculates its total value, by adding its two frame together
     *@param curScoObj Requires a ScoreFrameObject
     *@return Returns an int with the accumulated score*/
    private int calculateFramePoints(ScoreFrameObject curScoObj){
        return curScoObj.getFirstScoreFramePoint() + curScoObj.getSecondScoreFramePoint();
    }
}
