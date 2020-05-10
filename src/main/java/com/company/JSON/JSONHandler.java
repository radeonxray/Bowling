package com.company.JSON;

import com.company.ObjectClasses.DataObject;
import com.company.ObjectClasses.ScoreFrameObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Class for handling the JSON conversion of the retrieved response
 * */
public class JSONHandler {

    /** Method for converting the JSONArray containing the list of bowling scores, to a list of more managable object (ScoreFrame)
     * @param  jsonArrScores: JSONArray object
     * @return Returns a object of type List<ScoreFrame>*/
    public List<ScoreFrameObject> convert_JSONArray_to_List (JSONArray jsonArrScores) {

        Random rand = new Random();

        //Instantiate a List of <ScoreFrameObject>, as an ArrayList
        List<ScoreFrameObject> listArrScores = new ArrayList<ScoreFrameObject>();

        //For-loop going through all the content of the provided JSONArray
        for (int i=0; i < jsonArrScores.length() ; i++ ){

            //Instantiate a single string of a score from the data
            String singleFrameScoreString = (jsonArrScores.get(i).toString());

            //Convert the content of the string singleFrameScoreString to an int[], by regex removing unnecessary symbols and splitting the content
            int[] arr = Arrays.stream(singleFrameScoreString.substring(1, singleFrameScoreString.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();

            //Adding the converted int[] to the List as a new ScoreFrameObject
            listArrScores.add(new ScoreFrameObject(new int[]{arr[0],arr[1]}));

            //Assigning a frameID
            //Note that the frameID is assigned as i+1. to better simulate a scoreboard going from 1 to 10, instead of 0-9 used by the ArrayList
            listArrScores.get(i).setFrameID(i+1);

            //NEEDS TO BE REMOVED AT THE END!
            //listArrScores.get(i).setPoints(rand.nextInt(11));

        }

        //Return the List when done
        return listArrScores;
    }

    /**
     * Method for Converting the provided responseString into a Dataobject that can be accessed and used
     * @param  stringBufferResponse: String containing the content from the API GET response call
     * @param  dataObj: Need an empty DataObject, which will be filled with data (scores)
     * @return Returns a DataObject*/
    public DataObject convertResponseStringToObject(String stringBufferResponse, DataObject dataObj){

        //Convert StringBufferResponse to JSONObject
        JSONObject jsonResponse = new JSONObject(stringBufferResponse);

        //Instantiate JSONHandler for use in the next-step
        JSONHandler jsonHandler = new JSONHandler();

        //Converts the JSONArray-content, to a List<ScoreFrame> for better handling and management, in the dataObject
        dataObj.setListOfFrameScores(jsonHandler.convert_JSONArray_to_List(jsonResponse.getJSONArray("points")));

        //Sets the retrieve response token in the dataObject
        dataObj.setToken(jsonResponse.get("token").toString());

        //Returns a dataobject
        return dataObj;

    }
}