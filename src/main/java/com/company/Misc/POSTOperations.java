package com.company.Misc;

import com.company.Connection.POSTConnection;
import com.company.ObjectClasses.POSTObject;
import org.json.JSONObject;

import java.io.IOException;

public class POSTOperations {

    public String prepareJSONString_toPost(POSTObject postObject){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", postObject.getToken());
        jsonObject.put("points", postObject.getPoints());

        String jsonString = jsonObject.toString();

        return jsonString;
    }

    public void postToAPI(String postObjectJsonString) throws IOException {
        POSTConnection postCon = new POSTConnection();

        //postCon.POST(postObjectJsonString);

        // To be removed later!
        System.out.println("The following JSON string has been sent: \n" + postObjectJsonString);
    }



}
