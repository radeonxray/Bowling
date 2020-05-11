package com.company.ObjectClasses;

public class ScoreAndPrevScoresObject {

    ScoreFrameObject currentScore;
    ScoreFrameObject firstLeftScore;
    ScoreFrameObject secondLeftScore;
    ScoreFrameObject thirdLeftScore;

    public ScoreAndPrevScoresObject() {
    }

    public ScoreAndPrevScoresObject(ScoreFrameObject currentScore, ScoreFrameObject firstLeftScore, ScoreFrameObject secondLeftScore, ScoreFrameObject thirdLeftScore) {
        this.currentScore = currentScore;
        this.firstLeftScore = firstLeftScore;
        this.secondLeftScore = secondLeftScore;
        this.thirdLeftScore = thirdLeftScore;
    }

    public ScoreFrameObject getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(ScoreFrameObject currentScore) {
        this.currentScore = currentScore;
    }

    public ScoreFrameObject getFirstLeftScore() {
        return firstLeftScore;
    }

    public void setFirstLeftScore(ScoreFrameObject firstLeftScore) {
        this.firstLeftScore = firstLeftScore;
    }

    public ScoreFrameObject getSecondLeftScore() {
        return secondLeftScore;
    }

    public void setSecondLeftScore(ScoreFrameObject secondLeftScore) {
        this.secondLeftScore = secondLeftScore;
    }

    public ScoreFrameObject getThirdLeftScore() {
        return thirdLeftScore;
    }

    public void setThirdLeftScore(ScoreFrameObject thirdLeftScore) {
        this.thirdLeftScore = thirdLeftScore;
    }
}
