package com.ocrapp.ui.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PurchaseHistoryModel {

@SerializedName("nWalletId")
@Expose
private Integer nWalletId;
@SerializedName("nPrimaryId")
@Expose
private Integer nPrimaryId;
@SerializedName("cLoginType")
@Expose
private String cLoginType;
@SerializedName("fWalletAmount")
@Expose
private Double fWalletAmount;
@SerializedName("nJobId")
@Expose
private Integer nJobId;
@SerializedName("nOfferId")
@Expose
private Integer nOfferId;
@SerializedName("dtAddedDate")
@Expose
private String dtAddedDate;
@SerializedName("dtUpdatedDate")
@Expose
private String dtUpdatedDate;
@SerializedName("cReasons")
@Expose
private String cReasons;
@SerializedName("fCreditedAmount")
@Expose
private Double fCreditedAmount;
@SerializedName("dtCreditedDate")
@Expose
private String dtCreditedDate;
@SerializedName("fDebitedAmount")
@Expose
private Double fDebitedAmount;
@SerializedName("dtDebitedDate")
@Expose
private String dtDebitedDate;
@SerializedName("IsStatus")
@Expose
private Boolean isStatus;
@SerializedName("nUserId")
@Expose
private Integer nUserId;
@SerializedName("IsActive")
@Expose
private Boolean isActive;
@SerializedName("cRemark")
@Expose
private String cRemark;
@SerializedName("cRemark1")
@Expose
private String cRemark1;
@SerializedName("cRemark2")
@Expose
private String cRemark2;
@SerializedName("cRemark3")
@Expose
private String cRemark3;
@SerializedName("cRemark4")
@Expose
private String cRemark4;
@SerializedName("nLanguageId")
@Expose
private Integer nLanguageId;
@SerializedName("IsDisable")
@Expose
private Boolean isDisable;
@SerializedName("ndtlReferralCodeUseId")
@Expose
private Integer ndtlReferralCodeUseId;
@SerializedName("cJobTitle")
@Expose
private String cJobTitle;
@SerializedName("cJobType")
@Expose
private String cJobType;

public Integer getNWalletId() {
return nWalletId;
}

public void setNWalletId(Integer nWalletId) {
this.nWalletId = nWalletId;
}

public Integer getNPrimaryId() {
return nPrimaryId;
}

public void setNPrimaryId(Integer nPrimaryId) {
this.nPrimaryId = nPrimaryId;
}

public String getCLoginType() {
return cLoginType;
}

public void setCLoginType(String cLoginType) {
this.cLoginType = cLoginType;
}

public Double getFWalletAmount() {
return fWalletAmount;
}

public void setFWalletAmount(Double fWalletAmount) {
this.fWalletAmount = fWalletAmount;
}

public Integer getNJobId() {
return nJobId;
}

public void setNJobId(Integer nJobId) {
this.nJobId = nJobId;
}

public Integer getNOfferId() {
return nOfferId;
}

public void setNOfferId(Integer nOfferId) {
this.nOfferId = nOfferId;
}

public String getDtAddedDate() {
return dtAddedDate;
}

public void setDtAddedDate(String dtAddedDate) {
this.dtAddedDate = dtAddedDate;
}

public String getDtUpdatedDate() {
return dtUpdatedDate;
}

public void setDtUpdatedDate(String dtUpdatedDate) {
this.dtUpdatedDate = dtUpdatedDate;
}

public String getCReasons() {
return cReasons;
}

public void setCReasons(String cReasons) {
this.cReasons = cReasons;
}

public Double getFCreditedAmount() {
return fCreditedAmount;
}

public void setFCreditedAmount(Double fCreditedAmount) {
this.fCreditedAmount = fCreditedAmount;
}

public String getDtCreditedDate() {
return dtCreditedDate;
}

public void setDtCreditedDate(String dtCreditedDate) {
this.dtCreditedDate = dtCreditedDate;
}

public Double getFDebitedAmount() {
return fDebitedAmount;
}

public void setFDebitedAmount(Double fDebitedAmount) {
this.fDebitedAmount = fDebitedAmount;
}

public String getDtDebitedDate() {
return dtDebitedDate;
}

public void setDtDebitedDate(String dtDebitedDate) {
this.dtDebitedDate = dtDebitedDate;
}

public Boolean getIsStatus() {
return isStatus;
}

public void setIsStatus(Boolean isStatus) {
this.isStatus = isStatus;
}

public Integer getNUserId() {
return nUserId;
}

public void setNUserId(Integer nUserId) {
this.nUserId = nUserId;
}

public Boolean getIsActive() {
return isActive;
}

public void setIsActive(Boolean isActive) {
this.isActive = isActive;
}

public String getCRemark() {
return cRemark;
}

public void setCRemark(String cRemark) {
this.cRemark = cRemark;
}

public String getCRemark1() {
return cRemark1;
}

public void setCRemark1(String cRemark1) {
this.cRemark1 = cRemark1;
}

public String getCRemark2() {
return cRemark2;
}

public void setCRemark2(String cRemark2) {
this.cRemark2 = cRemark2;
}

public String getCRemark3() {
return cRemark3;
}

public void setCRemark3(String cRemark3) {
this.cRemark3 = cRemark3;
}

public String getCRemark4() {
return cRemark4;
}

public void setCRemark4(String cRemark4) {
this.cRemark4 = cRemark4;
}

public Integer getNLanguageId() {
return nLanguageId;
}

public void setNLanguageId(Integer nLanguageId) {
this.nLanguageId = nLanguageId;
}

public Boolean getIsDisable() {
return isDisable;
}

public void setIsDisable(Boolean isDisable) {
this.isDisable = isDisable;
}

public Integer getNdtlReferralCodeUseId() {
return ndtlReferralCodeUseId;
}

public void setNdtlReferralCodeUseId(Integer ndtlReferralCodeUseId) {
this.ndtlReferralCodeUseId = ndtlReferralCodeUseId;
}

public String getCJobTitle() {
return cJobTitle;
}

public void setCJobTitle(String cJobTitle) {
this.cJobTitle = cJobTitle;
}

public String getCJobType() {
return cJobType;
}

public void setCJobType(String cJobType) {
this.cJobType = cJobType;
}

}