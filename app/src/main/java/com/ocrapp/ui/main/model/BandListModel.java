package com.ocrapp.ui.main.model;

public class BandListModel {

    String bandScore;
    private Integer savedAnswer = 2;

    public BandListModel(String bandScore) {
        this.bandScore = bandScore;
    }

    public String getBandScore() {
        return bandScore;
    }

    public void setBandScore(String bandScore) {
        this.bandScore = bandScore;
    }

    public Integer getSavedAnswer() {
        return savedAnswer;
    }

    public void setSavedAnswer(Integer savedAnswer) {
        this.savedAnswer = savedAnswer;
    }
}
