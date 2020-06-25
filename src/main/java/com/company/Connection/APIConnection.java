package com.company.Connection;

public class APIConnection {

    private String ceoBackendApi = "http://localhost:8080/bowling/api/points";
    private String skatBackendApi = "http://13.74.31.101/api/points";

    public String getCeoBackendApi() {
        return ceoBackendApi;
    }

    public String getSkatBackendApi() {
        return skatBackendApi;
    }
}
