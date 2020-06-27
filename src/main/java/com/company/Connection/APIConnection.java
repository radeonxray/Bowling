package com.company.Connection;

public class APIConnection {

    private String ceoBackendApi = "http://localhost:8080/bowling/api/points";
    private String skatBackendApi = "http://13.74.31.101/api/points";

    /** Method for getting the API URl to the Ceo Backend
     * @return Returns the API URL as a String*/
    public String getCeoBackendApi() {
        return ceoBackendApi;
    }

    /** Method for getting the API URl to the SKAT Backend
     * @return Returns the API URL as a String*/
    public String getSkatBackendApi() {
        return skatBackendApi;
    }
}
