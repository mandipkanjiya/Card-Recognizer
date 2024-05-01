package com.ocrapp.ui.main.model.institutemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class InstitutewiseExamListModel {

    @SerializedName("Success")
    @Expose
    private String success;
    @SerializedName("Result")
    @Expose
    private List<Result> result = null;
    @SerializedName("nJobTotal")
    @Expose
    private Integer nJobTotal;

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

    public Integer getnJobTotal() {
        return nJobTotal;
    }

    public void setnJobTotal(Integer nJobTotal) {
        this.nJobTotal = nJobTotal;
    }
    public class Result {

        @SerializedName("nJobPostId")
        @Expose
        private Integer nJobPostId;
        @SerializedName("nEmpId")
        @Expose
        private Integer nEmpId;
        @SerializedName("nUserId")
        @Expose
        private Integer nUserId;
        @SerializedName("cJobTitle")
        @Expose
        private String cJobTitle;
        @SerializedName("cJobLocation")
        @Expose
        private String cJobLocation;
        @SerializedName("cDepartment")
        @Expose
        private String cDepartment;
        @SerializedName("cJobDescription")
        @Expose
        private String cJobDescription;
        @SerializedName("cJobType")
        @Expose
        private String cJobType;
        @SerializedName("dtCreatedDate")
        @Expose
        private String dtCreatedDate;
        @SerializedName("dtExpiryDate")
        @Expose
        private String dtExpiryDate;
        @SerializedName("cJobStatus")
        @Expose
        private String cJobStatus;
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

        public Integer getnJobPostId() {
            return nJobPostId;
        }

        public void setnJobPostId(Integer nJobPostId) {
            this.nJobPostId = nJobPostId;
        }

        public Integer getnEmpId() {
            return nEmpId;
        }

        public void setnEmpId(Integer nEmpId) {
            this.nEmpId = nEmpId;
        }

        public Integer getnUserId() {
            return nUserId;
        }

        public void setnUserId(Integer nUserId) {
            this.nUserId = nUserId;
        }

        public String getcJobTitle() {
            return cJobTitle;
        }

        public void setcJobTitle(String cJobTitle) {
            this.cJobTitle = cJobTitle;
        }

        public String getcJobLocation() {
            return cJobLocation;
        }

        public void setcJobLocation(String cJobLocation) {
            this.cJobLocation = cJobLocation;
        }

        public String getcDepartment() {
            return cDepartment;
        }

        public void setcDepartment(String cDepartment) {
            this.cDepartment = cDepartment;
        }

        public String getcJobDescription() {
            return cJobDescription;
        }

        public void setcJobDescription(String cJobDescription) {
            this.cJobDescription = cJobDescription;
        }

        public String getcJobType() {
            return cJobType;
        }

        public void setcJobType(String cJobType) {
            this.cJobType = cJobType;
        }

        public String getDtCreatedDate() {
            return dtCreatedDate;
        }

        public void setDtCreatedDate(String dtCreatedDate) {
            this.dtCreatedDate = dtCreatedDate;
        }

        public String getDtExpiryDate() {
            return dtExpiryDate;
        }

        public void setDtExpiryDate(String dtExpiryDate) {
            this.dtExpiryDate = dtExpiryDate;
        }

        public String getcJobStatus() {
            return cJobStatus;
        }

        public void setcJobStatus(String cJobStatus) {
            this.cJobStatus = cJobStatus;
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

        public String getcRemarks1() {
            return cRemarks1;
        }

        public void setcRemarks1(String cRemarks1) {
            this.cRemarks1 = cRemarks1;
        }

        public String getcRemarks2() {
            return cRemarks2;
        }

        public void setcRemarks2(String cRemarks2) {
            this.cRemarks2 = cRemarks2;
        }

        public String getcRemarks3() {
            return cRemarks3;
        }

        public void setcRemarks3(String cRemarks3) {
            this.cRemarks3 = cRemarks3;
        }

        public String getcRemarks4() {
            return cRemarks4;
        }

        public void setcRemarks4(String cRemarks4) {
            this.cRemarks4 = cRemarks4;
        }

        public String getcRemarks5() {
            return cRemarks5;
        }

        public void setcRemarks5(String cRemarks5) {
            this.cRemarks5 = cRemarks5;
        }

    }
}