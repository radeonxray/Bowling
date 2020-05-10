package com.company.ObjectClasses;

import java.util.List;

public class POSTObject {

    private String token;
    private List<Integer> points;


    public POSTObject(String token, List<Integer> points) {
        this.token = token;
        this.points = points;
    }

    public List<Integer> getPoints() {
        return points;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
