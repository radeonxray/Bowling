package com.company.Misc;

import com.company.Connection.APIConnection;
import com.company.ObjectClasses.DataObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class RunApplicationTest {

    /**Test that the application can successfully retrieve a JSON String, calculate the results,
     * POST the results and successfully retrieve the success-parameter as true.
     * Using the SKATBackend-API*/
    @Test
    void test_RunApplication_success_SKATAPI() throws IOException, InterruptedException {
        APIConnection apiConn = new APIConnection();
        AppStart appStart = new AppStart();

        appStart.ExecuteApp(apiConn.getSkatBackendApi());
        System.out.println(appStart.getResponse().toString());

        assertEquals("true", appStart.getResponse().getSuccess());
    }

    /**Test that the application can successfully retrieve a JSON String, calculate the results,
     * POST the results and successfully retrieve the success-parameter as true.
     * Using the CEOBackend-API*/
    @Test
    void test_RunApplication_success_CEOAPI() throws IOException, InterruptedException {
        APIConnection apiConn = new APIConnection();
        AppStart appStart = new AppStart();

        appStart.ExecuteApp(apiConn.getCeoBackendApi());
        System.out.println(appStart.getResponse().toString());

        assertEquals("true", appStart.getResponse().getSuccess());
    }


}
