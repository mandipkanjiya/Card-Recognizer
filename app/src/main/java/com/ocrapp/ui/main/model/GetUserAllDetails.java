package com.ocrapp.ui.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetUserAllDetails {

    @SerializedName("nCandidateId")
    @Expose
    private Integer nCandidateId;
    @SerializedName("cCandidateFirstName")
    @Expose
    private String cCandidateFirstName;
    @SerializedName("cCandidateMiddleName")
    @Expose
    private Object cCandidateMiddleName;
    @SerializedName("cCandidateLastName")
    @Expose
    private String cCandidateLastName;
    @SerializedName("cCandidateCompany")
    @Expose
    private Object cCandidateCompany;
    @SerializedName("cCandidateContactNo")
    @Expose
    private String cCandidateContactNo;
    @SerializedName("cCandidateEmailId")
    @Expose
    private String cCandidateEmailId;
    @SerializedName("cCandidateImage")
    @Expose
    private String cCandidateImage;
    @SerializedName("cCandidateFullImage")
    @Expose
    private String cCandidateFullImage;
    @SerializedName("cCandidateImagepath")
    @Expose
    private String cCandidateImagepath;
    @SerializedName("cResumeLink")
    @Expose
    private String cResumeLink;
    @SerializedName("cCandidateAddress")
    @Expose
    private String cCandidateAddress;
    @SerializedName("cZipCode")
    @Expose
    private Object cZipCode;
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
    private Object cRemarks5;
    @SerializedName("dtRegistrationDate")
    @Expose
    private String dtRegistrationDate;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("IsVerified")
    @Expose
    private Boolean isVerified;
    @SerializedName("IsDisable")
    @Expose
    private Boolean isDisable;
    @SerializedName("nUserId")
    @Expose
    private Integer nUserId;
    @SerializedName("nCityId")
    @Expose
    private Integer nCityId;
    @SerializedName("nStateId")
    @Expose
    private Integer nStateId;
    @SerializedName("nCountryId")
    @Expose
    private Integer nCountryId;
    @SerializedName("cCity")
    @Expose
    private Object cCity;
    @SerializedName("Skill")
    @Expose
    private List<Skill> skill = null;
    @SerializedName("cPhoneCode")
    @Expose
    private String cPhoneCode;
    @SerializedName("cReferralCode")
    @Expose
    private String cReferralCode;

    @SerializedName("fWalletAmount")
    @Expose
    private String fWalletAmount;

    @SerializedName("cType")
    @Expose
    private String cType;

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getfWalletAmount() {
        return fWalletAmount;
    }

    public void setfWalletAmount(String fWalletAmount) {
        this.fWalletAmount = fWalletAmount;
    }

    public String getcReferralCode() {
        return cReferralCode;
    }

    public void setcReferralCode(String cReferralCode) {
        this.cReferralCode = cReferralCode;
    }

    public String getcPhoneCode() {
        return cPhoneCode;
    }

    public void setcPhoneCode(String cPhoneCode) {
        this.cPhoneCode = cPhoneCode;
    }

    public Integer getNCandidateId() {
        return nCandidateId;
    }

    public void setNCandidateId(Integer nCandidateId) {
        this.nCandidateId = nCandidateId;
    }

    public String getCCandidateFirstName() {
        return cCandidateFirstName;
    }

    public void setCCandidateFirstName(String cCandidateFirstName) {
        this.cCandidateFirstName = cCandidateFirstName;
    }

    public Object getCCandidateMiddleName() {
        return cCandidateMiddleName;
    }

    public void setCCandidateMiddleName(Object cCandidateMiddleName) {
        this.cCandidateMiddleName = cCandidateMiddleName;
    }

    public String getCCandidateLastName() {
        return cCandidateLastName;
    }

    public void setCCandidateLastName(String cCandidateLastName) {
        this.cCandidateLastName = cCandidateLastName;
    }

    public Object getCCandidateCompany() {
        return cCandidateCompany;
    }

    public void setCCandidateCompany(Object cCandidateCompany) {
        this.cCandidateCompany = cCandidateCompany;
    }

    public String getCCandidateContactNo() {
        return cCandidateContactNo;
    }

    public void setCCandidateContactNo(String cCandidateContactNo) {
        this.cCandidateContactNo = cCandidateContactNo;
    }

    public String getCCandidateEmailId() {
        return cCandidateEmailId;
    }

    public void setCCandidateEmailId(String cCandidateEmailId) {
        this.cCandidateEmailId = cCandidateEmailId;
    }

    public String getCCandidateImage() {
        return cCandidateImage;
    }

    public void setCCandidateImage(String cCandidateImage) {
        this.cCandidateImage = cCandidateImage;
    }
    public String getCCandidateFullImage() {
        return cCandidateFullImage;
    }
    public void setCCandidateFullImage(String cCandidateFullImage) {
        this.cCandidateFullImage = cCandidateFullImage;
    }
    public String getCCandidateAddress() {
        return cCandidateAddress;
    }

    public void setCCandidateAddress(String cCandidateAddress) {
        this.cCandidateAddress = cCandidateAddress;
    }

    public Object getCZipCode() {
        return cZipCode;
    }

    public void setCZipCode(Object cZipCode) {
        this.cZipCode = cZipCode;
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

    public Object getCRemarks5() {
        return cRemarks5;
    }

    public void setCRemarks5(Object cRemarks5) {
        this.cRemarks5 = cRemarks5;
    }

    public String getDtRegistrationDate() {
        return dtRegistrationDate;
    }

    public void setDtRegistrationDate(String dtRegistrationDate) {
        this.dtRegistrationDate = dtRegistrationDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public Boolean getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Boolean isDisable) {
        this.isDisable = isDisable;
    }

    public Integer getNUserId() {
        return nUserId;
    }

    public void setNUserId(Integer nUserId) {
        this.nUserId = nUserId;
    }

    public Integer getNCityId() {
        return nCityId;
    }

    public void setNCityId(Integer nCityId) {
        this.nCityId = nCityId;
    }

    public Integer getNStateId() {
        return nStateId;
    }

    public void setNStateId(Integer nStateId) {
        this.nStateId = nStateId;
    }

    public Integer getNCountryId() {
        return nCountryId;
    }

    public void setNCountryId(Integer nCountryId) {
        this.nCountryId = nCountryId;
    }

    public Object getCCity() {
        return cCity;
    }

    public void setCCity(Object cCity) {
        this.cCity = cCity;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }
    public String getCCandidateImagepath() {
        return cCandidateImagepath;
    }

    public void setCCandidateImagepath(String cCandidateImagepath) {
        this.cCandidateImagepath = cCandidateImagepath;
    }

    public String getCResumeLink() {
        return cResumeLink;
    }

    public void setCResumeLink(String cResumeLink) {
        this.cResumeLink = cResumeLink;
    }
    public class Skill {

        @SerializedName("nSkillId")
        @Expose
        private Integer nSkillId;
        @SerializedName("cSkillName")
        @Expose
        private String cSkillName;
        @SerializedName("IsActive")
        @Expose
        private Boolean isActive;

        public Integer getNSkillId() {
            return nSkillId;
        }

        public void setNSkillId(Integer nSkillId) {
            this.nSkillId = nSkillId;
        }

        public String getCSkillName() {
            return cSkillName;
        }

        public void setCSkillName(String cSkillName) {
            this.cSkillName = cSkillName;
        }

        public Boolean getIsActive() {
            return isActive;
        }

        public void setIsActive(Boolean isActive) {
            this.isActive = isActive;
        }

    }
}