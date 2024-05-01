package com.ocrapp.ui.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeGraphDataModel {
    @SerializedName("Success")
    @Expose
    private String success;
    @SerializedName("result")
    @Expose
    private List<Result> result = null;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }


    public class JsonGraphDatum {

        @SerializedName("fCountMistech")
        @Expose
        private String fCountMistech;

        @SerializedName("cExamName")
        @Expose
        private String cExamName;

        @SerializedName("nJobId")
        @Expose
        private Integer nJobId;
        @SerializedName("nJobName")
        @Expose
        private String nJobName;
        @SerializedName("fBandScore")
        @Expose
        private Double fBandScore;

        public String getFCountMistech() {
            return fCountMistech;
        }

        public void setFCountMistech(String fCountMistech) {
            this.fCountMistech = fCountMistech;
        }

        public String getCExamName() {
            return cExamName;
        }

        public void setCExamName(String cExamName) {
            this.cExamName = cExamName;
        }
        public String getnJobName() {
            return nJobName;
        }

        public void setnJobName(String nJobName) {
            this.nJobName = nJobName;
        }

        public Double getfBandScore() {
            return fBandScore;
        }

        public void setfBandScore(Double fBandScore) {
            this.fBandScore = fBandScore;
        }
    }
    public class Result {
        @SerializedName("cGraphType")
        @Expose
        private String cGraphType;
        @SerializedName("jsonGraphData")
        @Expose
        private List<JsonGraphDatum> jsonGraphData = null;

        public String getCGraphType() {
            return cGraphType;
        }

        public void setCGraphType(String cGraphType) {
            this.cGraphType = cGraphType;
        }

        public List<JsonGraphDatum> getJsonGraphData() {
            return jsonGraphData;
        }

        public void setJsonGraphData(List<JsonGraphDatum> jsonGraphData) {
            this.jsonGraphData = jsonGraphData;
        }
    }
}