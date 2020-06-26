package com.company.CalculationsVerTwo;

import com.company.ObjectClasses.DataObject;
import com.company.ObjectClasses.ScoreFrameObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpareCalculationsVerTwoTest {

    /**Test that the current SPARE correctly awards the correct points, if the previous score was a STRIKE in the first round*/
    @Test
    void ifPreviousWasStrike_firstScore() {
        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{8,2},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,5, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,6, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[20, 40, 65, 82, 89, 96]",calcTwo.getDataObj().getFinalScoreList().toString());

    }

    /**Test that the current SPARE correctly awards the correct points, if the previous score was a STRIKE*/
    @Test
    void ifPreviousWasStrike() {
        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{8,0},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{8,2},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{6,0},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,5, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,6, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,7, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[8, 28, 44, 50, 57, 64, 71]",calcTwo.getDataObj().getFinalScoreList().toString());

    }

    /**Test that the current SPARE correctly awards the correct points, if the previous 2 score were both STRIKE in the beginning of the game*/
    @Test
    void ifPreviousWasDoubleStrike_twoStrikesFirstScores() {

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{8,2},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{9,0},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,5, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,6, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[28, 48, 67, 76, 83, 90]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /** Test that the current SPARE correctly awards the correct points, if the previous 2 score were both STRIKE*/
    @Test
    void ifPreviousWasDoubleStrike() {

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{8,2},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,5, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{3,2},0,6, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{3,2},0,7, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[7, 35, 55, 70, 77, 82, 87]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /**Test that the calculations are correct, when the first score was a Spare*/
    @Test
    void ifFirstScoreWasSpare() {

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{9,1},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{8,2},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,5, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{3,2},0,6, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{3,2},0,7, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[20, 48, 68, 83, 90, 95, 100]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /** Test that the calculations are correct, if there is only one round, and the only score was a SPARE*/
    @Test
    void ifFirstScoreWasSpare_SingleRoundGame() {

        DataObject dataObj = new DataObject();
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{9,1},0,1, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[10]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /** Test that if the 10th score is a SPARE, that the game correctly calculates the bonus score(11th score), if that bonus score is a NORMAL [6,0] */
    @Test
    void spare_checkEleventhScore_NORMAL() {

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
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{7,3},0,10, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{6,0},0,11, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[8, 33, 52, 61, 64, 72, 97, 116, 125, 141]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /** Test that if the 10th score is a SPARE, that the game correctly calculates the bonus score(11th score) if that bonus score is a NORMAL [6,3], and that the calculations
     * correctly ignores the second frame of the bonus score, since its not possible to bowl a second frame in this scenario */
    @Test
    void spare_checkEleventhScore_NORMAL_errorScore() {

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
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{7,3},0,10, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{6,2},0,11, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[8, 33, 52, 61, 64, 72, 97, 116, 125, 141]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /** Test that if the 10th score is a SPARE, that the game correctly calculates the bonus score (11th score), if that bonus score is a STRIKE */
    @Test
    void spare_checkEleventhScore_STRIKE() {

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
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{7,3},0,10, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,11, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[8, 33, 52, 61, 64, 72, 97, 116, 125, 145]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /** Test that if the 10th score is a STRIKE, that the game correctly calculates the bonus score(11th score), if that bonus score is a SPARE [9,1] */
    @Test
    void spare_checkEleventhScore_SPARE() {

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
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{9,1},0,11, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[8, 33, 52, 61, 64, 72, 97, 116, 125, 145]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /** Test that a Triple Spare-game is correctly calculated */
    @Test
    void spare_checkTripleScoresAreSpares() {

        DataObject dataObj = new DataObject();

        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,5},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{7,3},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{9,1},0,3, ScoreFrameObject.ScoreType.UNKNOWN));


        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[17, 36, 46]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /** Larger test of triple spare caulculations */
    @Test
    void spare_checkCoupleScoresAreSpares() {

        DataObject dataObj = new DataObject();

        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,5},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{7,3},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{9,1},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{9,0},0,5, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{4,2},0,6, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,7, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,8, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,2},0,9, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,0},0,10, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{10,10},0,11, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[17, 36, 51, 58, 67, 73, 98, 115, 122, 152]",calcTwo.getDataObj().getFinalScoreList().toString());
    }

    /** Larger test of triple spare caulculations */
    @Test
    void spare_checkAllScoresAreSpares() {

        DataObject dataObj = new DataObject();

        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,5},0,1, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{7,3},0,2, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{9,1},0,3, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,5},0,4, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{9,1},0,5, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{4,6},0,6, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{1,9},0,7, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{3,7},0,8, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{2,8},0,9, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{6,4},0,10, ScoreFrameObject.ScoreType.UNKNOWN));
        dataObj.getListOfFrameScores().add(new ScoreFrameObject(new int[]{5,0},0,11, ScoreFrameObject.ScoreType.UNKNOWN));

        CalculationsVerTwo calcTwo = new CalculationsVerTwo();

        calcTwo.setDataObj(dataObj);

        calcTwo.runCalculations();

        assertEquals("[17, 36, 51, 70, 84, 95, 108, 120, 136, 151]",calcTwo.getDataObj().getFinalScoreList().toString());
    }


}