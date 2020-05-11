package com.company;

import com.company.Calculations.Calculations;
import com.company.JSON.JSONHandler;
import com.company.Misc.GETOperations;
import com.company.Misc.POSTOperations;
import com.company.ObjectClasses.DataObject;
import com.company.Connection.GETConnection;
import com.company.ObjectClasses.POSTObject;
import com.company.ObjectClasses.ScoreFrameObject;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        //[[10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 10]]
        // ------------- GET DATA -------------- //
        GETOperations getOps = new GETOperations();

        DataObject dataObj = getOps.getData();

        System.out.println(dataObj.getListOfFrameScores());

        Calculations calc = new Calculations();
        calc.assignDataObject(dataObj);




        assignArray(dataObj, calc);




        //Is it needed? Maybe just work with the dataObj?
        //List<ScoreFrameObject> listOfFrameScores = dataObj.getListOfFrameScores();

        // ------------- Calculations ------------ //

        /*
        for (int i = 0; i < dataObj.getListOfFrameScores().size(); i++) {
            System.out.println((dataObj.getListOfFrameScores().get(i).toString()));
            calc.checkSecondPreviousFrameScore(dataObj.getListOfFrameScores().get(i));
            System.out.println("----------------");
        }
        calc.checkTripleStrike(dataObj.getListOfFrameScores().get(2));*/
        /*
        calc.checkIfPreviousStrike(dataObj.getListOfFrameScores().get(0));
        System.out.println("---");
        calc.checkIfPreviousStrike(dataObj.getListOfFrameScores().get(1));
        System.out.println("---");
        calc.checkIfPreviousStrike(dataObj.getListOfFrameScores().get(2));
        */

/*
        System.out.println(dataObj.getListOfFrameScores().toString());
        System.out.println(dataObj.getListOfFrameScores().size());


        System.out.println(calc.getPreviousScoreFrame(dataObj.getListOfFrameScores().get(5)).toString());
        System.out.println(calc.getSecondPreviousScoreFrame(dataObj.getListOfFrameScores().get(5)).toString());

*/


        // ------------- POST Data ------------ //

        POSTOperations postOPS = new POSTOperations();

        //calc.temp_addToFinalPoints(dataObj);

        System.out.println(dataObj.getFinalScoreList().toString() + " !!!! ");

        String jsonString = postOPS.prepareJSONString_toPost(new POSTObject(dataObj.getToken(), dataObj.getFinalScoreList()));

        postOPS.postToAPI(jsonString);

        //System.out.println(jsonString + " : ! : ! ");
        

        
        /*
        System.out.println(listOfScores.get(0).getFirstScoreFramePoint() + " OI!");

        System.out.println(listOfScores.get(0));
        System.out.println(listOfScores.get(0));
        System.out.println(dataObj.getToken());
        System.out.println(dataObj.getResponseCode());
        //System.out.println(jsonData.getJSONArray("points"));

        System.out.println(dataObj.getListArrScores().get(0).getFirstScoreFramePoint() + " " + dataObj.getListArrScores().get(0).getSecondScoreFramePoint());

        Calculations calc = new Calculations();

        calc.calculateSingleFrameScore(dataObj.getListArrScores().get(0));

        System.out.println(dataObj.getListArrScores().get(0).isNormal() + " " + dataObj.getListArrScores().get(0).isSpare() + " " + dataObj.getListArrScores().get(0).isStrike() );

        System.out.println(dataObj.getListArrScores().get(3));
        System.out.println(calc.getPreviousScoreFrame(dataObj.getListArrScores().get(3), dataObj.getListArrScores()));
        System.out.println(calc.getSecondPreviousScoreFrame(dataObj.getListArrScores().get(3), dataObj.getListArrScores()));
        */
    }


    public static void assignArray(DataObject dataObj, Calculations calc){

        for (int i = 0; i < dataObj.getListOfFrameScores().size(); i++) {
            calc.bowlingScoreCalculations(dataObj.getListOfFrameScores().get(i),i, dataObj.getListOfFrameScores().size());
            System.out.println("Frame ID:" + dataObj.getListOfFrameScores().get(i).getFrameID());
            System.out.println("Frame Numbers: " + dataObj.getListOfFrameScores().get(i).getFirstScoreFramePoint() + " : " + dataObj.getListOfFrameScores().get(i).getSecondScoreFramePoint());
            System.out.println("Frame Score: " + dataObj.getListOfFrameScores().get(i).getPoints());

            System.out.println("--------------");
        }

        for (int i = 0; i < dataObj.getListOfFrameScores().size(); i++) {
            System.out.println(dataObj.getListOfFrameScores().get(i).getPoints());
        }

        for (int i = 0; i < dataObj.getListOfFrameScores().size(); i++) {
            dataObj.getFinalScoreList().add(dataObj.getListOfFrameScores().get(i).getPoints());
        }


    }
}
