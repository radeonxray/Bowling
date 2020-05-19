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

        assertEquals("[30, 60, 80, 90]",calcTwo.getDataObj().getFinalScoreList().toString());

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

        assertEquals("[30, 50, 60]",calcTwo.getDataObj().getFinalScoreList().toString());

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

        assertEquals("[7, 27, 52, 69, 76]",calcTwo.getDataObj().getFinalScoreList().toString());

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

        assertEquals("[30, 60, 85, 102, 109, 139, 159, 169]",calcTwo.getDataObj().getFinalScoreList().toString());

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

        assertEquals("[7, 37, 67, 87, 97]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /**
     * Test that the calculations are correct, if all scores, including the bonus scores, are strikes!
     * [[10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 10]]*/
    @Test
    void ifAllScoreAreStrikes() {

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,5, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,6, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,7, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,8, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,9, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,10, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,10},0,11, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[30, 60, 90, 120, 150, 180, 210, 240, 270, 300]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /**
     * Test that the calculations are correct, if all scores, except for the very final bonus score which is 0, are strikes!
     * [[10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0]]*/
    @Test
    void ifElevenOutOfTwelveScoreAreStrikes_finalIsZero() {

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,5, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,6, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,7, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,8, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,9, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,10, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,11, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[30, 60, 90, 120, 150, 180, 210, 240, 270, 290]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /**
     * Test that the calculations are correct, if all scores, except for the very final bonus score which is 7, are strikes!
     * [[10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 7]]*/
    @Test
    void ifElevenOutOfTwelveScoreAreStrikes_finalIsSeven() {

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,5, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,6, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,7, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,8, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,9, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,10, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,7},0,11, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[30, 60, 90, 120, 150, 180, 210, 240, 270, 297]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /**
     * Test that the calculations are correct, if all scores, except for the very final bonus score which is 7, are strikes!
     * [[10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [2, 7]]*/
    @Test
    void ifTenOutOfTwelveScoreAreStrikes_finalIsNormalScore() {

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,5, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,6, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,7, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,8, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,9, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,10, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{2,7},0,11, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[30, 60, 90, 120, 150, 180, 210, 240, 262, 281]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

}