package com.company.ObjectClasses;

import java.util.ArrayList;
import java.util.List;

public class DataObject {

    private List<ScoreFrameObject> listOfFrameScores = new ArrayList<ScoreFrameObject>();
    private String token;
    private int responseCode;
    private List<Integer> finalScoreList = new ArrayList<>();

    public DataObject() {

    }

    public DataObject(List<ScoreFrameObject> listOfFrameScores, String token, int responseCode) {
        this.listOfFrameScores = listOfFrameScores;
        this.token = token;
        this.responseCode = responseCode;
    }

    public DataObject(List<ScoreFrameObject> listOfFrameScores, String token, int responseCode, List<Integer> finalScoreList) {
        this.listOfFrameScores = listOfFrameScores;
        this.token = token;
        this.responseCode = responseCode;
        this.finalScoreList = finalScoreList;
    }

    public List<ScoreFrameObject> getListOfFrameScores() {
        return listOfFrameScores;
    }

    public void setListOfFrameScores(List<ScoreFrameObject> listOfFrameScores) {
        this.listOfFrameScores = listOfFrameScores;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Integer> getFinalScoreList() {
        return finalScoreList;
    }

    public void setFinalScoreList(List<Integer> finalScoreList) {
        this.finalScoreList = finalScoreList;
    }

    public void addToFinalScoreList(Integer points){
        this.finalScoreList.add(points);
    }
}
