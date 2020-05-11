package com.company.Calculations;

import com.company.ObjectClasses.ScoreFrameObject;

public class CheckType {
    /**
     * Method for checking if the provided single ScoreFrameObject is a Spare
     * @param scoreFrameObject: A single ScoreFrameObject
     * @return Returns a boolean*/
    public Boolean checkIsSpare(ScoreFrameObject scoreFrameObject){

        if(scoreFrameObject.getFirstScoreFramePoint() + scoreFrameObject.getSecondScoreFramePoint() == 10){
            scoreFrameObject.setSpare(true);
            scoreFrameObject.setStrike(false);
            scoreFrameObject.setNormal(false);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method for checking if the provided single ScoreFrameObject is a Strike
     * @param scoreFrameObject: A single ScoreFrameObject
     * @return Returns a boolean*/
    public Boolean checkIsStrike(ScoreFrameObject scoreFrameObject){

        if(scoreFrameObject.getFirstScoreFramePoint() == 10){
            scoreFrameObject.setStrike(true);
            scoreFrameObject.setSpare(false);
            scoreFrameObject.setNormal(false);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method for checking if the provided single ScoreFrameObject is a normal, thus not a strike or a spare
     * @param scoreFrameObject: A single ScoreFrameObject
     * @return Returns a boolean*/
    public Boolean checkIsNormalPoints(ScoreFrameObject scoreFrameObject){
        ScoreFrameObject currentSc = scoreFrameObject;

        int currentPointSum = currentSc.getFirstScoreFramePoint() + currentSc.getSecondScoreFramePoint();

        if(currentPointSum != 10){
            scoreFrameObject.setNormal(true);
            scoreFrameObject.setStrike(false);
            scoreFrameObject.setSpare(false);
            return true;
        } else {
            return false;
        }
    }
}
