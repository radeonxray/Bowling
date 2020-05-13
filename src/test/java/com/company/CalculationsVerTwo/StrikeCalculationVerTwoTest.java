package com.company.CalculationsVerTwo;

import com.company.ObjectClasses.DataObject;
import com.company.ObjectClasses.ScoreFrameObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrikeCalculationVerTwoTest {

    /**
     * Testing that in a short game of 4 rounds with 4 strikes, the first strike is correctly calculated with bonus, but the remaining 3 are not*/
    @Test
    void checkIfTripleStrike_firstFourShots_fourStrikes() {
        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,4, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[30, 40, 50, 60]",calcTwo.getDataObj().getFinalScoreList().toString());

    }

    /**
     * Test that in a short game of 3 rounds with 3 strikes, that none of the strikes are calculated with a bonus in the end*/
    @Test
    void checkIfTripleStrike_firstThreeShots_threeStrikes() {
        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[10, 20, 30]",calcTwo.getDataObj().getFinalScoreList().toString());

    }

    /**
     * Test that in a short game of 1 round with 1 strike, that the strike is calculated without any bonus*/
    @Test
    void checkIfSingleStrike_firstShot_short1RoundGame() {
        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[10]",calcTwo.getDataObj().getFinalScoreList().toString());

    }

    /**
     * Test that the STRIKE is correctly calculated, if the previous was a SPARE*/
    @Test
    void checkIfPreviousWasSpare() {

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{8,2},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,5, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[7, 27, 37, 47, 54]",calcTwo.getDataObj().getFinalScoreList().toString());

    }

    /**
     * Test if the previous score was NORMAL*/
    @Test
    void checkIfPreviousWasNormal(){

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,5, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,6, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,7, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,8, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[30, 60, 85, 102, 109, 119, 129, 139]",calcTwo.getDataObj().getFinalScoreList().toString());

    }

    /**
     * Test if the previous score was NORMAL in the first round*/
    @Test
    void checkIfPreviousWasNormal_NORMALFirstRound(){

        DataObject dataObj = new DataObject();

        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,5, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[7, 37, 47, 57, 67]",calcTwo.getDataObj().getFinalScoreList().toString());

    }

}