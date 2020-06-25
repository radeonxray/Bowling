package com.company.Misc;

import com.company.CalculationsVerTwo.CalculationsVerTwo;
import com.company.Connection.APIConnection;
import com.company.ObjectClasses.DataObject;
import com.company.ObjectClasses.POSTObject;

import java.io.IOException;

public class AppStart {


    /**
     * Method for Executing and running all the operations of the application, from start ot finish
     * @param apiURL Requires a String with the api URL*/
    public void ExecuteApp(String apiURL) throws IOException, InterruptedException {
        // ------------- GET DATA -------------- //
        GETOperations getOps = new GETOperations();

        DataObject dataObj = getOps.getData(apiURL);

        // ------------- Calculations ------------ //

        CalculationsVerTwo calcV2 = new CalculationsVerTwo();

        calcV2.setDataObj(dataObj);

        System.out.println("Retrieved list of scores: " + dataObj.getListOfFrameScores());

        calcV2.setupGameSize();

        calcV2.runCalculations();

        // ------------- POST Data ------------ //

        POSTOperations postOPS = new POSTOperations();

        String jsonString = postOPS.prepareJSONString_toPost(new POSTObject(dataObj.getToken(), dataObj.getFinalScoreList()));

        System.out.println(jsonString);

        postOPS.postToAPI_httpclient(jsonString, apiURL);
    }

}
