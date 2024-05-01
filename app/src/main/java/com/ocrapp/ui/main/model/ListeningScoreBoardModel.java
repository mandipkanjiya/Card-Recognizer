package com.ocrapp.ui.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListeningScoreBoardModel {

    @SerializedName("nTotalQuestion")
    @Expose
    private Integer nTotalQuestion;
    @SerializedName("nTotalAttempted")
    @Expose
    private Integer nTotalAttempted;
    @SerializedName("nTotalCorrectAnswer")
    @Expose
    private Integer nTotalCorrectAnswer;
    @SerializedName("nTotalInCorrectAnswer")
    @Expose
    private Integer nTotalInCorrectAnswer;
    @SerializedName("fTotalBand")
    @Expose
    private Double fTotalBand;

    public Integer getnTotalQuestion() {
        return nTotalQuestion;
    }

    public void setnTotalQuestion(Integer nTotalQuestion) {
        this.nTotalQuestion = nTotalQuestion;
    }

    public Integer getnTotalAttempted() {
        return nTotalAttempted;
    }

    public void setnTotalAttempted(Integer nTotalAttempted) {
        this.nTotalAttempted = nTotalAttempted;
    }

    public Integer getnTotalCorrectAnswer() {
        return nTotalCorrectAnswer;
    }

    public void setnTotalCorrectAnswer(Integer nTotalCorrectAnswer) {
        this.nTotalCorrectAnswer = nTotalCorrectAnswer;
    }

    public Integer getnTotalInCorrectAnswer() {
        return nTotalInCorrectAnswer;
    }

    public void setnTotalInCorrectAnswer(Integer nTotalInCorrectAnswer) {
        this.nTotalInCorrectAnswer = nTotalInCorrectAnswer;
    }

    public Double getfTotalBand() {
        return fTotalBand;
    }

    public void setfTotalBand(Double fTotalBand) {
        this.fTotalBand = fTotalBand;
    }

}