package com.company.Misc;

import com.company.Calculations.Calculations;
import com.company.Connection.POSTConnection;
import com.company.ObjectClasses.DataObject;
import com.company.ObjectClasses.POSTObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class POSTOperationsTest {

    /**
     * Test to prove, that the method (prepareJSONString_toPost) can take an object and return as a JSON-string, specifically testing the
     * converted String */
    @Test
    void testString_prepareJSONString_toPost() {
        POSTOperations postOps = new POSTOperations();

        //Create a temp list of Integers, simulation a list of final scores
        List<Integer> temp_intListOfScores = new ArrayList<>();
        temp_intListOfScores.add(6);
        temp_intListOfScores.add(18);
        temp_intListOfScores.add(31);
        temp_intListOfScores.add(39);
        temp_intListOfScores.add(59);
        temp_intListOfScores.add(65);
        temp_intListOfScores.add(77);

        //Create a new POSTObject, and attach the list of Integers, and a String containing the simulated token
        POSTObject postObj = new POSTObject("tokenID", temp_intListOfScores);

        //Convert the POSTObject postObj to a string
        String jsonString = postOps.prepareJSONString_toPost(postObj);

        //Check that the content of the string matches the object
        assertEquals("{\"token\":\"tokenID\",\"points\":[6,18,31,39,59,65,77]}",jsonString );
    }


}