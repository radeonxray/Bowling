package com.company.Connection;

import com.company.ObjectClasses.POSTObject;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class POSTConnection {

    private int repsonseCode;

    /**
     * Method to POST a jsonString to the pre-specified server
     * @param jsonPOSTString: a jsonResponse string containing a token and the final score results*/
    public void POST(String jsonPOSTString) throws IOException {

        URL url = new URL ("http://13.74.31.101/api/points");

        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");

        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");

        con.setDoOutput(true);

        try(OutputStream os = con.getOutputStream()){
            byte[] input = jsonPOSTString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int code = con.getResponseCode();
        setRepsonseCode(code);

        try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))){
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println("The following JSON string has been sent: \n" + jsonPOSTString);
        }
    }

    public int getRepsonseCode() {
        return repsonseCode;
    }

    public void setRepsonseCode(int repsonseCode) {
        this.repsonseCode = repsonseCode;
    }
}
