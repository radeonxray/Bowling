package com.company;

import com.company.CalculationsVerTwo.CalculationsVerTwo;
import com.company.Connection.APIConnection;
import com.company.Connection.GETConnection;
import com.company.Connection.POSTConnection;
import com.company.Misc.AppStart;
import com.company.Misc.GETOperations;
import com.company.Misc.POSTOperations;
import com.company.ObjectClasses.DataObject;
import com.company.ObjectClasses.POSTObject;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {

        APIConnection apiConn = new APIConnection();
        AppStart appStart = new AppStart();

        /*Set apiConn to either:
        apiConn.getCeoBackendApi()
        apiConn.getSkatBackendApi()
         */

        appStart.ExecuteApp(apiConn.getSkatBackendApi());

        System.out.println(appStart.getResponse());
    }





}
