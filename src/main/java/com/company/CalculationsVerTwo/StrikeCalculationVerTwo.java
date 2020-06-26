package com.company.CalculationsVerTwo;
import com.company.Calculations.BowlingPoints;
import com.company.ObjectClasses.ScoreAndPrevScoresObject;


/**Class for calculating a scoreobject that has been identified as a STRIKE*/
public class StrikeCalculationVerTwo {

    BowlingPoints bp = new BowlingPoints();

    /** Method that calculates the points for the provided Strike object*/
    public void calculateStrike(ScoreAndPrevScoresObject objList){

        if(objList.getFirstLeftScore() != null){
            if ( objList.getFirstLeftScore().getScoreType().toString() == "STRIKE") {
                checkIfTripleStrike(objList);
            }
            if (objList.getFirstLeftScore().getScoreType().toString() == "SPARE"){
                checkIfPreviousWasSpare(objList);
            }
        }
    }

    /**Method that checks for bonus point calculations, if the current score and the 2 previous scores all are strikes*/
    public void checkIfTripleStrike(ScoreAndPrevScoresObject objList) {
        if (objList.getThirdLeftScore() != null) {

            if (objList.getFirstLeftScore() != null && objList.getFirstLeftScore().getScoreType().toString() == "STRIKE") {

                if (objList.getSecondLeftScore() != null && objList.getSecondLeftScore().getScoreType().toString() == "STRIKE") {

                    int threeOrAboveScores_firstStrikeInTripleStrike_points = objList.getThirdLeftScore().getPoints() + bp.getTripleStrikePoints();
                    objList.getSecondLeftScore().setPoints(threeOrAboveScores_firstStrikeInTripleStrike_points);
                }
            }
        } else {

            if (objList.getFirstLeftScore() != null && objList.getFirstLeftScore().getScoreType().toString() == "STRIKE") {

                if (objList.getSecondLeftScore() != null && objList.getSecondLeftScore().getScoreType().toString() == "STRIKE") {

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

    /**
     * Method for checking and calculating potential bonus points in the bonus frame of the 10 or "11th" score frame*/
    public void strikeBonusFrame(ScoreAndPrevScoresObject objList){

        bonusFrame_doubleStrike(objList);
        bonusFrame_singleStrike(objList);

    }

    /**Method for calculating the "11th" bonus frame, if it contains a double strike*/
    public void bonusFrame_doubleStrike(ScoreAndPrevScoresObject objList){
        if(objList.getCurrentScore().getFirstScoreFramePoint() == 10 && objList.getCurrentScore().getSecondScoreFramePoint() == 10 ){
            if(objList.getFirstLeftScore().getScoreType().toString() == "STRIKE"){

                int tenthBonusFrame_theEleventhFrame_points = objList.getSecondLeftScore().getPoints() + bp.getTripleStrikePoints();
                objList.getFirstLeftScore().setPoints(tenthBonusFrame_theEleventhFrame_points);
            }
        }
    }

    /**Method for calculating the "11th" bonus frame, if it contains a single strike, at frame 1*/
    public void bonusFrame_singleStrike(ScoreAndPrevScoresObject objList){
        if(objList.getCurrentScore().getFirstScoreFramePoint() == 10 && objList.getCurrentScore().getSecondScoreFramePoint() != 10 ){
            if(objList.getFirstLeftScore().getScoreType().toString() == "STRIKE"){
                int tenthFrameScorePoints = objList.getThirdLeftScore().getPoints() + bp.getTripleStrikePoints();
                objList.getSecondLeftScore().setPoints(tenthFrameScorePoints);

                int tenthBonusFrame_theEleventhFrame_points = objList.getSecondLeftScore().getPoints() + bp.getStrikeFullPoints() + objList.getCurrentScore().getSecondScoreFramePoint();
                objList.getFirstLeftScore().setPoints(tenthBonusFrame_theEleventhFrame_points);
            }
        }
    }




}
