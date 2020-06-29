package com.company.Misc;

import com.company.Connection.APIConnection;
import com.company.Connection.POSTConnection;
import com.company.ObjectClasses.POSTObject;
import com.company.ObjectClasses.PostResponseObject;
import org.json.JSONObject;

import java.io.IOException;

public class POSTOperations {

    private APIConnection apiConn;
    private POSTConnection postCon = new POSTConnection();

    /**
     * Method for preparing the PostObject and return it as a JSON String
     * @param postObject Requires a POSTObject
     * @return (json)String*/
    public String prepareJSONString_toPost(POSTObject postObject){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", postObject.getToken());
        jsonObject.put("points", postObject.getPoints());

        return jsonObject.toString();
    }

    /**
     * Method for Posting the provided JSONString to the provided String apiURL
     * Note that this method is using the old HttpURLConnection method, which is not compatible with CeoBackend, perhaps due to issues with modern backends
     * @param apiURL Requires a String containing the api url
     * @param postObjectJsonString Requires a (json)String with the data to be send*/
    public void postToAPI_httpurlconnection(String postObjectJsonString, String apiURL) throws IOException {
        postCon.Post_HttpURLConnection(postObjectJsonString, apiURL);
    }

    /**
     * Method for Posting the provided JSONString to the provided String apiURL
     * Note that this method is using the java 11 HttpClient method, to better be compatible with both SkatBackendApi and CeoBackendApi
     * @param apiURL Requires a String containing the api url
     * @param postObjectJsonString Requires a (json)String with the data to be send
     * @return Returns a PostResponseObject*/
    public PostResponseObject postToAPI_httpclient(String postObjectJsonString, String apiURL) throws IOException, InterruptedException {

        return postCon.Post_HttpClient(postObjectJsonString, apiURL);
    }

    public POSTConnection getPostCon() {
        return postCon;
    }
}
