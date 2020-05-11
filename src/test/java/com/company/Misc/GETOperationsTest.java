package com.company.Misc;

import com.company.ObjectClasses.DataObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GETOperationsTest {

    /**
     * Simple test to show that the token object found in the dataObject is not null*/
    @Test
    void test_getData_getToken() throws IOException {
        GETOperations getOps = new GETOperations();

        DataObject dataObj = getOps.getData();

        assertNotNull(dataObj.getToken());
    }
}