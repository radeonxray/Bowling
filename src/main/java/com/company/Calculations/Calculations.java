package com.company.Calculations;

import com.company.ObjectClasses.DataObject;
import com.company.ObjectClasses.ScoreAndPrevScoresObject;
import com.company.ObjectClasses.ScoreFrameObject;

//-------------------------------------------------------------!
//VERY BLOATED CLASS! NEEDS MORE WORK, STREAMLINING, TESTABILITY AND CLEANUP!
//-------------------------------------------------------------!

/**
 * Class for handling and executing the calculations of the score
 * */
public class Calculations {

    private DataObject dataObj;
    /**
     * Method for using the current ScoreFrameObject to retrieve the left ScoreFrameObject from the current one
     * Ex: Current #5, returns #4
     * Method retrieves the first left ScoreFrameObject, by looking at the currentScoreFrameObject.getFrameID() - 2,
     * due to .getFrameID() being based on i+1 in JSONHandler.convert_JSONArray_to_List
     * @param currentScoreFrameObject: Provide the current ScoreFrameObject
     * @return Returns the previous ScoreFrameObject */
    public ScoreFrameObject getFirstLeftScoreFrame(ScoreFrameObject currentScoreFrameObject){
        ScoreFrameObject previousScoreFrameObject = dataObj.getListOfFrameScores().get(currentScoreFrameObject.getFrameID()-2);
        return previousScoreFrameObject;
    }

    /**
     * Method for using the current ScoreFrameObject to retrieve the ScoreFrameObject 2 spots left from the current one
     * Ex: Current #5, returns #3
     * Method retrieves the second left ScoreFrameObject, by looking at the currentScoreFrameObject.getFrameID() - 3,
     * due to .getFrameID() being based on i+1 in JSONHandler.convert_JSONArray_to_List
     * @param currentScoreFrameObject: Provide the current ScoreFrameObject
     * @return Returns the previous ScoreFrameObject */
    public ScoreFrameObject getSecondLeftScoreFrame(ScoreFrameObject currentScoreFrameObject){
        ScoreFrameObject secondPreviousScoreFrameObject = dataObj.getListOfFrameScores().get(currentScoreFrameObject.getFrameID()-3);
        return secondPreviousScoreFrameObject;
    }

    /**
     * Method for using the current ScoreFrameObject to retrieve the ScoreFrameObject 3 spots left from the current one
     * Ex: Current #5, returns #2
     * Method retrieves the third left ScoreFrameObject, by looking at the currentScoreFrameObject.getFrameID() - 4,
     * due to .getFrameID() being based on i+1 in JSONHandler.convert_JSONArray_to_List
     * @param currentScoreFrameObject: Provide the current ScoreFrameObject
     * @return Returns the previous ScoreFrameObject */
    public ScoreFrameObject getThirdLeftScoreFrame(ScoreFrameObject currentScoreFrameObject){
        ScoreFrameObject secondPreviousScoreFrameObject = dataObj.getListOfFrameScores().get(currentScoreFrameObject.getFrameID()-4);
        return secondPreviousScoreFrameObject;
    }


    public void bowlingScoreCalculations(ScoreFrameObject currentScoreFrameObject, int i, int gameLength){
        SpareCalculations spareCalc = new SpareCalculations();
        StrikeCalculations strikeCalc = new StrikeCalculations();
        NonSpareStrikeCalculations nonSpaStrCalc = new NonSpareStrikeCalculations();
        ScoreAndPrevScoresObject scoPrevScoObj = new ScoreAndPrevScoresObject();

        scoPrevScoObj.setCurrentScore(currentScoreFrameObject);
        scoPrevScoObj.setFirstLeftScore(null);
        scoPrevScoObj.setSecondLeftScore(null);
        scoPrevScoObj.setThirdLeftScore(null);


        if(gameLength <= 1 ){
            int points = calcCurrentScoreFramePointSum(currentScoreFrameObject);
            scoPrevScoObj.getCurrentScore().setPoints(points);

        } else {

            if (scoPrevScoObj.getCurrentScore().getFrameID() >= 2) {
                scoPrevScoObj.setFirstLeftScore(getFirstLeftScoreFrame(scoPrevScoObj.getCurrentScore()));

                if (scoPrevScoObj.getCurrentScore().getFrameID() >= 3) {
                    scoPrevScoObj.setSecondLeftScore(getSecondLeftScoreFrame(scoPrevScoObj.getCurrentScore()));
                }

                if (scoPrevScoObj.getCurrentScore().getFrameID() >= 4) {
                    scoPrevScoObj.setThirdLeftScore(getThirdLeftScoreFrame(scoPrevScoObj.getCurrentScore()));
                }
            }

            strikeCalc.Calculating_Strike(scoPrevScoObj, gameLength);
            spareCalc.Calculating_Spare(scoPrevScoObj, gameLength);
            nonSpaStrCalc.Calculating_NonSpareStrike(scoPrevScoObj, gameLength);

        }

        scoPrevScoObj.setCurrentScore(null);
        scoPrevScoObj.setFirstLeftScore(null);
        scoPrevScoObj.setSecondLeftScore(null);
        scoPrevScoObj.setThirdLeftScore(null);

    }
    /**
     * Public method used to assign the DataObject to the Calculations-class
     * @param dataObject Requires a dataObject*/
    public void assignDataObject(DataObject dataObject){
        dataObj = dataObject;
    }

    /**
     * Method for calculating the score frame 1 and 2 of a single score, used for when calculating non strikes or spares
     * @param  currentScoreFrameObject Takes a ScoreFrameObject
     * @return Returns the calculated score as an int*/
    public int calcCurrentScoreFramePointSum(ScoreFrameObject currentScoreFrameObject) {
        return currentScoreFrameObject.getFirstScoreFramePoint() + currentScoreFrameObject.getSecondScoreFramePoint();
    }

    /**Method used to execute and run the calculations
     * @return Returns a DataObject*/
    public DataObject runCalculations(){

        for (int i = 0; i < dataObj.getListOfFrameScores().size(); i++) {
            bowlingScoreCalculations(dataObj.getListOfFrameScores().get(i),i, dataObj.getListOfFrameScores().size());
        }
        for (int i = 0; i < dataObj.getListOfFrameScores().size(); i++) {
            dataObj.getFinalScoreList().add(dataObj.getListOfFrameScores().get(i).getPoints());
        }

        return dataObj;
    }

    /**Method used to inspect some of the mechanics when running the calculations*/
    public DataObject runCalculations_ConsoleInspector(){

        for (int i = 0; i < dataObj.getListOfFrameScores().size(); i++) {
            bowlingScoreCalculations(dataObj.getListOfFrameScores().get(i),i, dataObj.getListOfFrameScores().size());

            System.out.println("Frame ID:" + dataObj.getListOfFrameScores().get(i).getFrameID());
            System.out.println("Frame Numbers: " + dataObj.getListOfFrameScores().get(i).getFirstScoreFramePoint() + " : " + dataObj.getListOfFrameScores().get(i).getSecondScoreFramePoint());
            System.out.println("Frame Score: " + dataObj.getListOfFrameScores().get(i).getPoints());

            System.out.println("--------------");
        }

        for (int i = 0; i < dataObj.getListOfFrameScores().size(); i++) {
            System.out.println(dataObj.getListOfFrameScores().get(i).getPoints());
        }

        for (int i = 0; i < dataObj.getListOfFrameScores().size(); i++) {
            dataObj.getFinalScoreList().add(dataObj.getListOfFrameScores().get(i).getPoints());
        }
        return dataObj;
    }

    public boolean checkFrameElevenStrikes(ScoreFrameObject currentScoreFrameObject){
        if(currentScoreFrameObject.getFirstScoreFramePoint() == 10 && currentScoreFrameObject.getFirstScoreFramePoint() == 10){
            System.out.println("SPECIAL BONUS STRIKE!!!!");
            return true;
        }
        System.out.println("No special bonus strike ):");
        return false;
    }

}
