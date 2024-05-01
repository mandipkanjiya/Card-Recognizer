package com.ocrapp.ui.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ISHER TECH on 1/24/2018.
 */

public class BodyTempChartDataModel {
    @SerializedName("Success")
    @Expose
    private String success;

    @SerializedName("fAverageTemperature")
    @Expose
    private String fAverageTemperature;

    public String getfAverageTemperature() {
        return fAverageTemperature;
    }

    public void setfAverageTemperature(String fAverageTemperature) {
        this.fAverageTemperature = fAverageTemperature;
    }

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

    public class Result {

        @SerializedName("nBodyTempratureId")
        @Expose
        private Integer nBodyTempratureId;
        @SerializedName("nCustomerId")
        @Expose
        private Integer nCustomerId;
        @SerializedName("Date")
        @Expose
        private String date;
        @SerializedName("Time")
        @Expose
        private String time;
        @SerializedName("IsCelsius")
        @Expose
        private Boolean isCelsius;
        @SerializedName("fTemprature")
        @Expose
        private Float fTemprature;
        @SerializedName("nUserId")
        @Expose
        private Integer nUserId;
        @SerializedName("nLanguageId")
        @Expose
        private Integer nLanguageId;
        @SerializedName("IsActive")
        @Expose
        private Boolean isActive;
        @SerializedName("IsDisable")
        @Expose
        private Boolean isDisable;
        @SerializedName("cRemarks1")
        @Expose
        private String cRemarks1;
        @SerializedName("cRemarks2")
        @Expose
        private String cRemarks2;
        @SerializedName("cRemarks3")
        @Expose
        private String cRemarks3;
        @SerializedName("cRemarks4")
        @Expose
        private String cRemarks4;
        @SerializedName("cRemarks5")
        @Expose
        private String cRemarks5;
        @SerializedName("dtAddedDate")
        @Expose
        private String dtAddedDate;
        @SerializedName("dtAddedTime")
        @Expose
        private String dtAddedTime;
        @SerializedName("dtAddedDateTime")
        @Expose
        private String dtAddedDateTime;

        public Integer getNBodyTempratureId() {
            return nBodyTempratureId;
        }

        public void setNBodyTempratureId(Integer nBodyTempratureId) {
            this.nBodyTempratureId = nBodyTempratureId;
        }

        public Integer getNCustomerId() {
            return nCustomerId;
        }

        public void setNCustomerId(Integer nCustomerId) {
            this.nCustomerId = nCustomerId;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Boolean getIsCelsius() {
            return isCelsius;
        }

        public void setIsCelsius(Boolean isCelsius) {
            this.isCelsius = isCelsius;
        }

        public Float getFTemprature() {
            return fTemprature;
        }

        public void setFTemprature(Float fTemprature) {
            this.fTemprature = fTemprature;
        }

        public Integer getNUserId() {
            return nUserId;
        }

        public void setNUserId(Integer nUserId) {
            this.nUserId = nUserId;
        }

        public Integer getNLanguageId() {
            return nLanguageId;
        }

        public void setNLanguageId(Integer nLanguageId) {
            this.nLanguageId = nLanguageId;
        }

        public Boolean getIsActive() {
            return isActive;
        }

        public void setIsActive(Boolean isActive) {
            this.isActive = isActive;
        }

        public Boolean getIsDisable() {
            return isDisable;
        }

        public void setIsDisable(Boolean isDisable) {
            this.isDisable = isDisable;
        }

        public String getCRemarks1() {
            return cRemarks1;
        }

        public void setCRemarks1(String cRemarks1) {
            this.cRemarks1 = cRemarks1;
        }

        public String getCRemarks2() {
            return cRemarks2;
        }

        public void setCRemarks2(String cRemarks2) {
            this.cRemarks2 = cRemarks2;
        }

        public String getCRemarks3() {
            return cRemarks3;
        }

        public void setCRemarks3(String cRemarks3) {
            this.cRemarks3 = cRemarks3;
        }

        public String getCRemarks4() {
            return cRemarks4;
        }

        public void setCRemarks4(String cRemarks4) {
            this.cRemarks4 = cRemarks4;
        }

        public String getCRemarks5() {
            return cRemarks5;
        }

        public void setCRemarks5(String cRemarks5) {
            this.cRemarks5 = cRemarks5;
        }

        public String getDtAddedDate() {
            return dtAddedDate;
        }

        public void setDtAddedDate(String dtAddedDate) {
            this.dtAddedDate = dtAddedDate;
        }

        public String getDtAddedTime() {
            return dtAddedTime;
        }

        public void setDtAddedTime(String dtAddedTime) {
            this.dtAddedTime = dtAddedTime;
        }

        public String getDtAddedDateTime() {
            return dtAddedDateTime;
        }

        public void setDtAddedDateTime(String dtAddedDateTime) {
            this.dtAddedDateTime = dtAddedDateTime;
        }

    }
}
