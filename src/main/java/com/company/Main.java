package com.company;

import com.company.CalculationsVerTwo.CalculationsVerTwo;
import com.company.Misc.GETOperations;
import com.company.Misc.POSTOperations;
import com.company.ObjectClasses.DataObject;
import com.company.ObjectClasses.POSTObject;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        // ------------- GET DATA -------------- //
        GETOperations getOps = new GETOperations();

        DataObject dataObj = getOps.getData();

        // ------------- Calculations ------------ //

        CalculationsVerTwo calcV2 = new CalculationsVerTwo();

        calcV2.setDataObj(dataObj);


        calcV2.setupGameSize();

        System.out.println( calcV2.getDataObj().getListOfFrameScores());
        calcV2.runCalculations();



        // ------------- POST Data ------------ //

        POSTOperations postOPS = new POSTOperations();

        String jsonString = postOPS.prepareJSONString_toPost(new POSTObject(dataObj.getToken(), dataObj.getFinalScoreList()));

        postOPS.postToAPI(jsonString);


    }



}
