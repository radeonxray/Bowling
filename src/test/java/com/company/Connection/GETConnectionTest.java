package com.company.Connection;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GETConnectionTest {

    /**
     * Testing Skat Backend
     * Simple test to show that the GET-method returns a string with content, and is not empty or null
     * */
    @Test
    void test_getData_get_responseCode_SkatBackend() throws IOException {
        GETConnection getCon = new GETConnection();
        APIConnection apiCon = new APIConnection();
        String dataString = getCon.getData_HttpURLConnection(apiCon.getSkatBackendApi());
        assertNotNull(dataString);
    }

    /**
     * Testing Ceo Backend
     * Simple test to show that the GET-method returns a string with content, and is not empty or null
     * */
    @Test
    void test_getData_get_responseCode_CeoBackend() throws IOException {
        GETConnection getCon = new GETConnection();
        APIConnection apiCon = new APIConnection();
        String dataString = getCon.getData_HttpURLConnection(apiCon.getCeoBackendApi());
        assertNotNull(dataString);
    }
}