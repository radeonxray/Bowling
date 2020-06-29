package com.company.ObjectClasses;

public class PostResponseObject {

    String success;
    String input;
    int responseCode;

    public PostResponseObject() {
    }

    public PostResponseObject(PostResponseObject postResponseObject) {
    }

    public PostResponseObject(String success, String input, int responseCode) {
        this.success = success;
        this.input = input;
        this.responseCode = responseCode;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public String toString() {
        return "ReponseCode: " + responseCode + ", success: " + success + ", input:" + input;
    }
}
