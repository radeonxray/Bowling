package com.company.ObjectClasses;

import java.util.Arrays;

public class ScoreFrameObject {

    private int[] framePoints = new int[2];
    private boolean strike, spare, normal;
    private int points, frameID;

    public ScoreFrameObject(int[] framePoints) {
        this.framePoints = framePoints;
    }

    public ScoreFrameObject(int[] framePoints, boolean strike, boolean spare, boolean normal, int points, int frameID) {
        this.framePoints = framePoints;
        this.strike = strike;
        this.spare = spare;
        this.normal = normal;
        this.points = points;
        this.frameID = frameID;
    }



    public int[] getFramePoints() {
        return framePoints;
    }

    public void setFramePoints(int[] framePoints) {
        this.framePoints = framePoints;
    }

    public int getFirstScoreFramePoint(){ return framePoints[0];}

    public int getSecondScoreFramePoint(){
        return framePoints[1];
    }

    public boolean isStrike() {
        return strike;
    }

    public void setStrike(boolean strike) {
        this.strike = strike;
    }

    public boolean isSpare() {
        return spare;
    }

    public void setSpare(boolean spare) {
        this.spare = spare;
    }

    public boolean isNormal() {
        return normal;
    }

    public void setNormal(boolean normal) {
        this.normal = normal;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getFrameID() { return frameID;}

    public void setFrameID(int frameID) { this.frameID = frameID;}

    @Override
    public String toString() {
        return Arrays.toString(framePoints);
    }
}
