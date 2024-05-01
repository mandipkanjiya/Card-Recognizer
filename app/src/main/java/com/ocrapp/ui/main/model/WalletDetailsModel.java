package com.ocrapp.ui.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WalletDetailsModel {

@SerializedName("Success")
@Expose
private String success;
@SerializedName("result")
@Expose
private List<Result> result = null;
@SerializedName("fCreditedAmount")
@Expose
private Double fCreditedAmount;
@SerializedName("fDebitedAmount")
@Expose
private Double fDebitedAmount;
@SerializedName("fTotalWalletAmount")
@Expose
private Double fTotalWalletAmount;
@SerializedName("cCurrency")
@Expose
private String cCurrency;

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

public Double getFCreditedAmount() {
return fCreditedAmount;
}

public void setFCreditedAmount(Double fCreditedAmount) {
this.fCreditedAmount = fCreditedAmount;
}

public Double getFDebitedAmount() {
return fDebitedAmount;
}

public void setFDebitedAmount(Double fDebitedAmount) {
this.fDebitedAmount = fDebitedAmount;
}

public Double getFTotalWalletAmount() {
return fTotalWalletAmount;
}

public void setFTotalWalletAmount(Double fTotalWalletAmount) {
this.fTotalWalletAmount = fTotalWalletAmount;
}

public String getCCurrency() {
return cCurrency;
}

public void setCCurrency(String cCurrency) {
this.cCurrency = cCurrency;
}



    public class Result {

        @SerializedName("nCandidateId")
        @Expose
        private Integer nCandidateId;
        @SerializedName("fWalletAmount")
        @Expose
        private Double fWalletAmount;
        @SerializedName("nQuotationMasterId")
        @Expose
        private Integer nQuotationMasterId;
        @SerializedName("nOfferId")
        @Expose
        private Integer nOfferId;
        @SerializedName("dtDate")
        @Expose
        private String dtDate;
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
        @SerializedName("cReasons")
        @Expose
        private String cReasons;
        @SerializedName("nUserId")
        @Expose
        private Integer nUserId;
        @SerializedName("IsActive")
        @Expose
        private Boolean isActive;
        @SerializedName("cRemark")
        @Expose
        private Object cRemark;
        @SerializedName("cRemark1")
        @Expose
        private Object cRemark1;
        @SerializedName("cRemark2")
        @Expose
        private String cRemark2;
        @SerializedName("cRemark3")
        @Expose
        private String cRemark3;
        @SerializedName("cRemark4")
        @Expose
        private Object cRemark4;

        public Integer getNCandidateId() {
            return nCandidateId;
        }

        public void setNCandidateId(Integer nCandidateId) {
            this.nCandidateId = nCandidateId;
        }

        public Double getFWalletAmount() {
            return fWalletAmount;
        }

        public void setFWalletAmount(Double fWalletAmount) {
            this.fWalletAmount = fWalletAmount;
        }

        public Integer getNQuotationMasterId() {
            return nQuotationMasterId;
        }

        public void setNQuotationMasterId(Integer nQuotationMasterId) {
            this.nQuotationMasterId = nQuotationMasterId;
        }

        public Integer getNOfferId() {
            return nOfferId;
        }

        public void setNOfferId(Integer nOfferId) {
            this.nOfferId = nOfferId;
        }

        public String getDtDate() {
            return dtDate;
        }

        public void setDtDate(String dtDate) {
            this.dtDate = dtDate;
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

        public String getCReasons() {
            return cReasons;
        }

        public void setCReasons(String cReasons) {
            this.cReasons = cReasons;
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

        public Object getCRemark() {
            return cRemark;
        }

        public void setCRemark(Object cRemark) {
            this.cRemark = cRemark;
        }

        public Object getCRemark1() {
            return cRemark1;
        }

        public void setCRemark1(Object cRemark1) {
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

        public Object getCRemark4() {
            return cRemark4;
        }

        public void setCRemark4(Object cRemark4) {
            this.cRemark4 = cRemark4;
        }

    }
}