package com.company.CalculationsVerTwo;

import com.company.ObjectClasses.DataObject;
import com.company.ObjectClasses.ScoreFrameObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalCalculationsVerTwoTest {


    /**Test that a given list with NORMAL scores and a single strike, is calculated correctly*/
    @Test
    void ifPreviousWasStrike() {

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,3},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{9,0},0,4, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[7, 25, 33, 42]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /**Test that a given list with NORMAL scores and a single SPARE, is calculated correctly*/
    @Test
    void ifPreviousWasSpare() {

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{8,2},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,3},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{9,0},0,4, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[7, 22, 30, 39]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /**Test that given a list of scores that are NORMAL, that the results will also reflect so*/
    @Test
    void ifPreviousWasNormal() {

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{1,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,3},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{9,0},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{0,0},0,5, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{0,3},0,6, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{2,5},0,7, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[7, 8, 16, 25, 25, 28, 35]",calcTwo.getDataObj().getFinalScoreList().toString());

    }

    /**Check if two STRIKES at the beginning of the game is calculated correctly, if the Third score is a NORMAL*/
    @Test
    void ifPreviousWasDoubleStrike_strikesFirstTwoScores() {

        DataObject dataObj = new DataObject();

        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,4},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{0,3},0,4, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[25, 44, 53, 56]",calcTwo.getDataObj().getFinalScoreList().toString());

    }

    /**Check if two STRIKES in the game is calculated correctly, if they are followed by a NORMAL score */
    @Test
    void ifPreviousWasDoubleStrike() {

        DataObject dataObj = new DataObject();

        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,3},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,4},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{0,3},0,5, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[8, 33, 52, 61, 64]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /**Test that the calculations are correct, if there is only one round, and the only score was of type NORMAL*/
    @Test
    void ifFirstScoreWasNormal_SingleRoundGame() {

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,1},0,1, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[6]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /**Test that if the 10th score is a STRIKE, that the game correctly calculate the bonus score, when the bonus score (11th score) is NORMAL of [5,2] */
    @Test
    void Normal_11thRoundGame() {

        DataObject dataObj = new DataObject();

        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,3},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,4},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{0,3},0,5, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,3},0,6, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,7, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,8, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,4},0,9, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,10, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,11, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[8, 33, 52, 61, 64, 72, 97, 116, 125, 142]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /** Test that the game correctly calculates the scores after 10 rounds, when the game ends on a NORMAL score, resulting in NO BONUS (11th) score*/
    @Test
    void Normal_10thRoundGame() {

        DataObject dataObj = new DataObject();

        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,3},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,4},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{0,3},0,5, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,3},0,6, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,7, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,8, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,4},0,9, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{2,3},0,10, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[8, 33, 52, 61, 64, 72, 97, 116, 125, 130]",calcTwo.getDataObj().getFinalScoreList().toString());
    }



}