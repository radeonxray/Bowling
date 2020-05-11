package com.company.Connection;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GETConnectionTest {

    /**
     * Simple test to show that the GET-method returns a string with content, and is not empty or null
     * */
    @Test
    void test_getData_get_responseCode() throws IOException {
        GETConnection getCon = new GETConnection();
        String dataString = getCon.getData();
        assertNotNull(dataString);
    }
}