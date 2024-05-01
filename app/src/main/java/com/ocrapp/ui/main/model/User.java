package com.ocrapp.ui.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("nLoginId")
    @Expose
    private Integer nLoginId;
    @SerializedName("nCandidateId")
    @Expose
    private Integer nCandidateId;
    @SerializedName("cUserName")
    @Expose
    private String cUserName;
    @SerializedName("cPassword")
    @Expose
    private String cPassword;
    @SerializedName("cCandidateFirstName")
    @Expose
    private String cCandidateFirstName;
    @SerializedName("dtLastLogInDate")
    @Expose
    private String dtLastLogInDate;
    @SerializedName("cCandidateMiddleName")
    @Expose
    private String cCandidateMiddleName;
    @SerializedName("cCandidateLastName")
    @Expose
    private String cCandidateLastName;
    @SerializedName("cCandidateContactNo")
    @Expose
    private String cCandidateContactNo;
    @SerializedName("cCandidateImage")
    @Expose
    private String cCandidateImage;
    @SerializedName("cCandidateAddress")
    @Expose
    private String cCandidateAddress;
    @SerializedName("cZipCode")
    @Expose
    private String cZipCode;
    @SerializedName("cType")
    @Expose
    private String cType;
    @SerializedName("cStripeCustomerId")
    @Expose
    private String cStripeCustomerId;


    public Integer getNLoginId() {
        return nLoginId;
    }

    public void setNLoginId(Integer nLoginId) {
        this.nLoginId = nLoginId;
    }

    public Integer getNCandidateId() {
        return nCandidateId;
    }

    public void setNCandidateId(Integer nCandidateId) {
        this.nCandidateId = nCandidateId;
    }

    public String getCUserName() {
        return cUserName;
    }

    public void setCUserName(String cUserName) {
        this.cUserName = cUserName;
    }

    public String getCPassword() {
        return cPassword;
    }

    public void setCPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getCCandidateFirstName() {
        return cCandidateFirstName;
    }

    public void setCCandidateFirstName(String cCandidateFirstName) {
        this.cCandidateFirstName = cCandidateFirstName;
    }

    public String getDtLastLogInDate() {
        return dtLastLogInDate;
    }

    public void setDtLastLogInDate(String dtLastLogInDate) {
        this.dtLastLogInDate = dtLastLogInDate;
    }

    public String getCCandidateMiddleName() {
        return cCandidateMiddleName;
    }

    public void setCCandidateMiddleName(String cCandidateMiddleName) {
        this.cCandidateMiddleName = cCandidateMiddleName;
    }

    public String getCCandidateLastName() {
        return cCandidateLastName;
    }

    public void setCCandidateLastName(String cCandidateLastName) {
        this.cCandidateLastName = cCandidateLastName;
    }

    public String getCCandidateContactNo() {
        return cCandidateContactNo;
    }

    public void setCCandidateContactNo(String cCandidateContactNo) {
        this.cCandidateContactNo = cCandidateContactNo;
    }

    public String getCCandidateImage() {
        return cCandidateImage;
    }

    public void setCCandidateImage(String cCandidateImage) {
        this.cCandidateImage = cCandidateImage;
    }

    public String getCCandidateAddress() {
        return cCandidateAddress;
    }

    public void setCCandidateAddress(String cCandidateAddress) {
        this.cCandidateAddress = cCandidateAddress;
    }

    public String getCZipCode() {
        return cZipCode;
    }

    public void setCZipCode(String cZipCode) {
        this.cZipCode = cZipCode;
    }
    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getcStripeCustomerId() {
        return cStripeCustomerId;
    }

    public void setcStripeCustomerId(String cStripeCustomerId) {
        this.cStripeCustomerId = cStripeCustomerId;
    }
}