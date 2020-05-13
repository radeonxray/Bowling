package com.company.CalculationsVerTwo;

import com.company.ObjectClasses.ScoreFrameObject;

/**Class for identifying and assigning the correct scoreType to the individual scoreObject */
public class CheckScoreType {

    /**
     * Method checking if the scoreObject is a Strike
     * @param curScoObj: Requires a ScoreFrameObject
     * @return Returns a boolean*/
    public boolean isScoreTypeStrike(ScoreFrameObject curScoObj){

        if(curScoObj.getFirstScoreFramePoint() == 10){
            curScoObj.setScoreType(ScoreFrameObject.ScoreType.STRIKE);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method checking if the scoreObject is a Spare
     * @param curScoObj: Requires a ScoreFrameObject
     * @return Returns a boolean*/
    public boolean isScoreTypeSpare(ScoreFrameObject curScoObj){

        if(calculateFramePoints(curScoObj) == 10){
            curScoObj.setScoreType(ScoreFrameObject.ScoreType.SPARE);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method checking if the scoreObject is Normal (not a Spare or a Strike)
     * @param curScoObj: Requires a ScoreFrameObject
     * @return Returns a boolean*/
    public boolean isScoreTypeNormal(ScoreFrameObject curScoObj){

        if(calculateFramePoints(curScoObj) != 10){
            curScoObj.setScoreType(ScoreFrameObject.ScoreType.NORMAL);
            return true;
        } else {
            return false;
        }
    }

    /**Method for taking a {@link ScoreFrameObject} and running it through all the methods, identifying what type of scoreType the given scoreObject is
     * @param  curScoObj: Requires a ScoreFrameObject
     * @return Returns a boolean*/
    public boolean identifyScoreType(ScoreFrameObject curScoObj){

        if(isScoreTypeStrike(curScoObj)){
            return true;
        } else if (isScoreTypeSpare(curScoObj)) {
            return true;
        } else if (isScoreTypeNormal(curScoObj)){
            return true;
        }

        return false;
    }

    /**Private method that takes a {@link ScoreFrameObject} and calculates its total value, by adding its two frame together
     *@param curScoObj Requires a ScoreFrameObject
     *@return Returns an int with the accumulated score*/
    private int calculateFramePoints(ScoreFrameObject curScoObj){
        System.out.println(curScoObj.getFirstScoreFramePoint() + curScoObj.getSecondScoreFramePoint());
        return curScoObj.getFirstScoreFramePoint() + curScoObj.getSecondScoreFramePoint();
    }

}
