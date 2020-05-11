package com.company;

import com.company.Calculations.Calculations;
import com.company.JSON.JSONHandler;
import com.company.Misc.GETOperations;
import com.company.Misc.POSTOperations;
import com.company.ObjectClasses.DataObject;
import com.company.Connection.GETConnection;
import com.company.ObjectClasses.POSTObject;
import com.company.ObjectClasses.ScoreFrameObject;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        // ------------- GET DATA -------------- //
        GETOperations getOps = new GETOperations();

        DataObject dataObj = getOps.getData();

        // ------------- Calculations ------------ //
        Calculations calc = new Calculations();
        calc.assignDataObject(dataObj);

        DataObject calculatedDataObj =  calc.runCalculations();

        // ------------- POST Data ------------ //

        POSTOperations postOPS = new POSTOperations();

        String jsonString = postOPS.prepareJSONString_toPost(new POSTObject(calculatedDataObj.getToken(), calculatedDataObj.getFinalScoreList()));

        postOPS.postToAPI(jsonString);


    }



}
