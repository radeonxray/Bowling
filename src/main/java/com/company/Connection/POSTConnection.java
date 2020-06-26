package com.company.Connection;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.*;
import java.time.Duration;

import static com.company.Connection.HttpClientSetup.httpClient;

//import static jdk.internal.net.http.HttpRequestImpl.USER_AGENT;

public class POSTConnection {

    private int repsonseCode;


    /**
     * Method to POST a jsonString to the pre-specified server
     * Method is based on the HttpClient, which supports Http2.
     * Works perfectly with Ceo's Express js backend, but does not work with SKAT's Backend
     * @param jsonPOSTString: a jsonResponse string containing a token and the final score results*/
    public void Post_HttpClient(String jsonPOSTString, String apiURL) throws IOException, InterruptedException {

        // add json header
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(jsonPOSTString))
                .uri(URI.create(apiURL))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        int code = response.statusCode();
        setRepsonseCode(code);

        // print status code
        System.out.println(getRepsonseCode());

        // print response body
        System.out.println(response.body());
    }

    /**
     * Method to POST a jsonString to the pre-specified server
     * Method is based on the HttpURLConnection, which might be deprecated for some backend systems.
     * Works perfectly with SKAT's backend (), but does NOT work for Ceo's Express js backend
     * @param jsonPOSTString: a jsonResponse string containing a token and the final score results*/
    public void Post_HttpURLConnection(String jsonPOSTString, String apiURL) throws IOException {
        URL url = new URL (apiURL);

        HttpURLConnection con = (HttpURLConnection)url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("charset", "utf-8");
        con.setDoOutput(true);


        try(OutputStream os = con.getOutputStream()){
            byte[] input = jsonPOSTString.getBytes("utf-8");
            os.write(input, 0, input.length);
            os.flush();
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
            System.out.println(response.toString());

        } catch (Exception e){
            System.out.println("Something went terrible wrong!");
            System.out.println(e);

        }
    }

    public int getRepsonseCode() {
        return repsonseCode;
    }

    public void setRepsonseCode(int repsonseCode) {
        this.repsonseCode = repsonseCode;
    }

    /**
     * Experiment for Error-handling, not complete, nor implemented*/
    public void errorFeedback(int responseID){
        if(getRepsonseCode() == 404){
            System.out.println("404 Error! Check the URL!");
        }

        if(getRepsonseCode() == 500){
            System.out.println("500 Error!");
        }
    }
}
