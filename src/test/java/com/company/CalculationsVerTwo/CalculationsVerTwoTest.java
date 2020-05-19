package com.company.CalculationsVerTwo;

import com.company.ObjectClasses.DataObject;
import com.company.ObjectClasses.ScoreFrameObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationsVerTwoTest {

    /**
     * Test that the isShortGame-boolean is set to true, if the gameSize is < 10*/
    @Test
    void test_setupGameSize_isShortGame_true() {

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.SPARE));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.NORMAL));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.STRIKE));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,4, ScoreFrameObject.ScoreType.STRIKE));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,5, ScoreFrameObject.ScoreType.NORMAL));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.setupGameSize();

        assertEquals(true, calcTwo.isShortGame());
    }

    /** Test that the isShortGame-boolean is set to false, if the gameSize is not less than 10*/
    @Test
    void test_setupGameSize_isShortGame_false() {

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.SPARE));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.NORMAL));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.STRIKE));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,4, ScoreFrameObject.ScoreType.STRIKE));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,5, ScoreFrameObject.ScoreType.NORMAL));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,6, ScoreFrameObject.ScoreType.SPARE));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,7, ScoreFrameObject.ScoreType.NORMAL));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,8, ScoreFrameObject.ScoreType.STRIKE));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,9, ScoreFrameObject.ScoreType.STRIKE));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,10, ScoreFrameObject.ScoreType.NORMAL));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.setupGameSize();

        assertEquals(false, calcTwo.isShortGame());
    }

    /**
     * Test that a gamesize of 1 ends the game with 1 element in the FinalScoreList, a final score that is the sum of the ScoreFrame 1 and 2 from a NORMAL scoreType
     * Ex of a Normal type: (2,4) should return 6*/
    @Test
    void calculationsLoops_gamesize_one_normalScore(){
        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{2,4},0,1, ScoreFrameObject.ScoreType.NORMAL));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.setupGameSize();

        assertEquals("[6]",calcTwo.runCalculations().getFinalScoreList().toString());
    }

    /**
     * Test that a gamesize of 1 ends the game with 1 element in the FinalScoreList, a final score that is the sum of the ScoreFrame 1 and 2 from a STRIKE scoreType
     * Ex of a Strike: (10,0) should return 10*/
    @Test
    void calculationsLoops_gamesize_one_strike(){
        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.STRIKE));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.setupGameSize();

        assertEquals("[10]",calcTwo.runCalculations().getFinalScoreList().toString());
    }

    /**
     * Test that a gamesize of 1 ends the game with 1 element in the FinalScoreList, a final score that is the sum of the ScoreFrame 1 and 2 from a SPARE scoreType
     * Ex of a Strike: (2,8) should return 10*/
    @Test
    void calculationsLoops_gamesize_one_spare(){
        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{3,7},0,1, ScoreFrameObject.ScoreType.SPARE));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.setupGameSize();

        assertEquals("[10]",calcTwo.runCalculations().getFinalScoreList().toString());
    }

}