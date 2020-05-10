package com.company.Misc;

import com.company.Connection.GETConnection;
import com.company.JSON.JSONHandler;
import com.company.ObjectClasses.DataObject;
import com.company.ObjectClasses.ScoreFrameObject;

import java.util.List;
import com.company.Calculations.Calculations;
import com.company.JSON.JSONHandler;
import com.company.ObjectClasses.DataObject;
import com.company.Connection.GETConnection;
import com.company.ObjectClasses.ScoreFrameObject;

import java.io.IOException;

public class GETOperations {

    public DataObject getData() throws IOException {

        //Instantiate DataObject, that will contain all the incoming data
        DataObject dataObj = new DataObject();

        //Instantiate the GETConnection class, that will handle the GET-api call
        GETConnection con = new GETConnection();

        //Instantiate the JSONHandler, to convert the incoming data from the GET API call to the DataObject
        JSONHandler jsonHandler = new JSONHandler();

        //Call the getData() method in GETConnection-class, and assign the results to a String
        String responseObject = con.getData();

        //Take the string containing the response from the GET API-call, and convert and assign the results to the DataObject
        dataObj = jsonHandler.convertResponseStringToObject(responseObject, dataObj);

        return dataObj;

    }


}
