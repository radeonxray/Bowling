package com.company.Misc;

import com.company.Connection.APIConnection;
import com.company.ObjectClasses.DataObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GETOperationsTest {

    /**
     * Testing SkatBackend
     * Simple test to show that the token object found in the dataObject is not null*/
    @Test
    void test_getData_getToken_SkatBackend() throws IOException, InterruptedException {
        GETOperations getOps = new GETOperations();
        APIConnection apiCon = new APIConnection();
        DataObject dataObj = getOps.getData(apiCon.getSkatBackendApi());

        assertNotNull(dataObj.getToken());
    }

    /**
     * Testing CeoBackend
     * Simple test to show that the token object found in the dataObject is not null*/
    @Test
    void test_getData_getToken_CeoBackend() throws IOException, InterruptedException {
        GETOperations getOps = new GETOperations();
        APIConnection apiCon = new APIConnection();
        DataObject dataObj = getOps.getData(apiCon.getCeoBackendApi());

        assertNotNull(dataObj.getToken());
    }
}