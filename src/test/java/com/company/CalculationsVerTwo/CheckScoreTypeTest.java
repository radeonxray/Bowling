package com.company.CalculationsVerTwo;

import com.company.ObjectClasses.ScoreFrameObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**Test that the application can correctly identify and assign the different score types to a scoreObject*/
class CheckScoreTypeTest {

    /**
     * Test that the isScoreTypeStrike-method can correctly identify and assign a scoreobject as a Strike, if the score is correct */
    @Test
    void test_isScoreTypeStrike_true() {
        ScoreFrameObject newScoreObject = new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.UNKNOWN);

        CheckScoreType cst = new CheckScoreType();

        cst.isScoreTypeStrike(newScoreObject);

        assertEquals("STRIKE", newScoreObject.getScoreType().toString());
    }

    /**
     * Test that the isScoreTypeStrike-method can correctly identify a non-strike scoreobject and not assign as a Strike */
    @Test
    void test_isScoreTypeStrike_false() {
        ScoreFrameObject newScoreObject = new ScoreFrameObject(new int[]{8,2},0,1, ScoreFrameObject.ScoreType.UNKNOWN);

        CheckScoreType cst = new CheckScoreType();

        cst.isScoreTypeStrike(newScoreObject);

        assertNotEquals("STRIKE", newScoreObject.getScoreType().toString());
    }

    /**
     * Test that the isScoreTypeSpare-method can correctly identify and assign the SPARE-type, based on the score*/
    @Test
    void test_isScoreTypeSpare_true() {
        ScoreFrameObject newScoreObject = new ScoreFrameObject(new int[]{8,2},0,1, ScoreFrameObject.ScoreType.UNKNOWN);

        CheckScoreType cst = new CheckScoreType();

        cst.isScoreTypeSpare(newScoreObject);

        assertEquals("SPARE", newScoreObject.getScoreType().toString());
    }

    /**
     * Test that the isScoreTypeSpare-method can correctly identify and NOT assign the SPARE-type, based on the score*/
    @Test
    void test_isScoreTypeSpare_false() {
        ScoreFrameObject newScoreObject = new ScoreFrameObject(new int[]{2,2},0,1, ScoreFrameObject.ScoreType.UNKNOWN);

        CheckScoreType cst = new CheckScoreType();

        cst.isScoreTypeSpare(newScoreObject);

        assertNotEquals("SPARE", newScoreObject.getScoreType().toString());
    }

    /**
     * Test that the isScoreTypeNormal-method can correctly identify and assign the NORMAL-type, based on the score*/
    @Test
    void test_isScoreTypeNormal_true() {
        ScoreFrameObject newScoreObject = new ScoreFrameObject(new int[]{6,3},0,1, ScoreFrameObject.ScoreType.UNKNOWN);

        CheckScoreType cst = new CheckScoreType();

        cst.isScoreTypeNormal(newScoreObject);

        assertNotEquals("SPARE", newScoreObject.getScoreType().toString());
    }

    /**
     * Test that the isScoreTypeNormal-method can correctly identify and NOT assign the Normal-type, based on the score*/
    @Test
    void test_isScoreTypeNormal_false() {
        ScoreFrameObject newScoreObject = new ScoreFrameObject(new int[]{5,5},0,1, ScoreFrameObject.ScoreType.UNKNOWN);

        CheckScoreType cst = new CheckScoreType();

        cst.isScoreTypeNormal(newScoreObject);

        assertNotEquals("SPARE", newScoreObject.getScoreType().toString());
    }


    @Test
    /**
     * Test that the identifyScoreType-method correctly can take a scoreObj and get the correct scoreType assigned to it */
    void test_identifyScoreType_strike_true(){
        ScoreFrameObject newScoreObject = new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.UNKNOWN);

        CheckScoreType cst = new CheckScoreType();

        cst.identifyScoreType(newScoreObject);

        assertEquals("STRIKE", newScoreObject.getScoreType().toString());
    }

    @Test
    /**
     * Test that the identifyScoreType-method correctly can take a scoreObj and get the correct scoreType assigned to it */
    void test_identifyScoreType_spare_true(){
        ScoreFrameObject newScoreObject = new ScoreFrameObject(new int[]{5,5},0,1, ScoreFrameObject.ScoreType.UNKNOWN);

        CheckScoreType cst = new CheckScoreType();

        cst.identifyScoreType(newScoreObject);

        assertEquals("SPARE", newScoreObject.getScoreType().toString());
    }

    @Test
    /**
     * Test that the identifyScoreType-method correctly can take a scoreObj and get the correct scoreType assigned to it */
    void test_identifyScoreType_normal_true(){
        ScoreFrameObject newScoreObject = new ScoreFrameObject(new int[]{2,5},0,1, ScoreFrameObject.ScoreType.UNKNOWN);

        CheckScoreType cst = new CheckScoreType();

        cst.identifyScoreType(newScoreObject);

        assertEquals("NORMAL", newScoreObject.getScoreType().toString());
    }
}