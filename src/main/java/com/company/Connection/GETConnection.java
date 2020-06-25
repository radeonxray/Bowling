package com.company.Connection;

import com.company.ObjectClasses.DataObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Class for handling the GET-api call and retrieving the data
 * */
public class GETConnection {

    private DataObject dataObj;
    private String stringBufferResponse;

    /**Method for Calling the pre-defined API, read the content and return the response
     * Uses the old HttpURLConnection
     *@return Returns the response as a String */
    public String getData_HttpURLConnection(String apiURL) throws IOException{
        dataObj = new DataObject();
        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        //Sets the retrieved responseCode in the dataObj
        dataObj.setResponseCode(con.getResponseCode());

        //If the getResponseCode == 200, the response data managed to instantiate and create the dataObj
        if(dataObj.getResponseCode() == HttpURLConnection.HTTP_OK){

            //
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            //Read the incoming data as long as response is not null
            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }

            //Close the String
            in.close();

            //Assign the response to a String
            stringBufferResponse = response.toString();

            //Return the String
            return stringBufferResponse;

        } else {

            //If Responsecode != 200, the function fails
            System.out.println("GET REQUEST DID NOT WORK AS INTENDED!");
            return null;
        }
    }
}
