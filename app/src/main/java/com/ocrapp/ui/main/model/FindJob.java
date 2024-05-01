package com.ocrapp.ui.main.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FindJob implements Parcelable
{

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
    @SerializedName("cCompanyName")
    @Expose
    private String cCompanyName;
    @SerializedName("cCountry")
    @Expose
    private String cCountry;
    @SerializedName("cCompanyLogo")
    @Expose
    private String cCompanyLogo;
    @SerializedName("IsApply")
    @Expose
    private Integer IsApply;

    @SerializedName("fAmount")
    @Expose
    private Double fAmount;

    @SerializedName("fWalletAmount")
    @Expose
    private Double fWalletAmount;

    @SerializedName("fPrice")
    @Expose
    private Double fPrice;


    public final static Parcelable.Creator<FindJob> CREATOR = new Creator<FindJob>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FindJob createFromParcel(Parcel in) {
            return new FindJob(in);
        }

        public FindJob[] newArray(int size) {
            return (new FindJob[size]);
        }

    }
            ;

    protected FindJob(Parcel in) {
        this.nJobPostId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nEmpId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nUserId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.IsApply = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cJobTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.cJobLocation = ((String) in.readValue((String.class.getClassLoader())));
        this.cDepartment = ((String) in.readValue((String.class.getClassLoader())));
        this.cJobDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.cJobType = ((String) in.readValue((String.class.getClassLoader())));
        this.dtCreatedDate = ((String) in.readValue((String.class.getClassLoader())));
        this.dtExpiryDate = ((String) in.readValue((String.class.getClassLoader())));
        this.cJobStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.isActive = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isDisable = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.cRemarks1 = ((String) in.readValue((String.class.getClassLoader())));
        this.cRemarks2 = ((String) in.readValue((String.class.getClassLoader())));
        this.cRemarks3 = ((String) in.readValue((String.class.getClassLoader())));
        this.cRemarks4 = ((String) in.readValue((String.class.getClassLoader())));
        this.cRemarks5 = ((String) in.readValue((String.class.getClassLoader())));
        this.cCompanyName = ((String) in.readValue((String.class.getClassLoader())));
        this.cCountry = ((String) in.readValue((String.class.getClassLoader())));
        this.cCompanyLogo = ((String) in.readValue((String.class.getClassLoader())));
        this.fAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.fWalletAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.fPrice = ((Double) in.readValue((Double.class.getClassLoader())));

    }

    public FindJob() {
    }
    public Double getFAmount() {
        return fAmount;
    }

    public void setFCreditedAmount(Double fAmount) {
        this.fAmount = fAmount;
    }

    public Double getFWalletAmountt() {
        return fWalletAmount;
    }

    public void setfWalletAmount(Double fWalletAmount) {
        this.fWalletAmount = fWalletAmount;
    }

    public Double getfPrice() {
        return fPrice;
    }

    public void setfPrice(Double fPrice) {
        this.fPrice = fPrice;
    }


    public Integer getNJobPostId() {
        return nJobPostId;
    }

    public void setNJobPostId(Integer nJobPostId) {
        this.nJobPostId = nJobPostId;
    }

    public Integer getNEmpId() {
        return nEmpId;
    }

    public void setNEmpId(Integer nEmpId) {
        this.nEmpId = nEmpId;
    }

    public Integer getNUserId() {
        return nUserId;
    }

    public void setNUserId(Integer nUserId) {
        this.nUserId = nUserId;
    }

    public String getCJobTitle() {
        return cJobTitle;
    }

    public void setCJobTitle(String cJobTitle) {
        this.cJobTitle = cJobTitle;
    }

    public String getCJobLocation() {
        return cJobLocation;
    }

    public void setCJobLocation(String cJobLocation) {
        this.cJobLocation = cJobLocation;
    }

    public String getCDepartment() {
        return cDepartment;
    }

    public void setCDepartment(String cDepartment) {
        this.cDepartment = cDepartment;
    }

    public String getCJobDescription() {
        return cJobDescription;
    }

    public void setCJobDescription(String cJobDescription) {
        this.cJobDescription = cJobDescription;
    }

    public String getCJobType() {
        return cJobType;
    }

    public void setCJobType(String cJobType) {
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

    public String getCJobStatus() {
        return cJobStatus;
    }

    public void setCJobStatus(String cJobStatus) {
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

    public String getCCompanyName() {
        return cCompanyName;
    }

    public void setCCompanyName(String cCompanyName) {
        this.cCompanyName = cCompanyName;
    }

    public String getcCountry() {
        return cCountry;
    }

    public void setcCountry(String cCountry) {
        this.cCountry = cCountry;
    }

    public String getCCompanyLogo() {
        return cCompanyLogo;
    }

    public void setCCompanyLogo(String cCompanyLogo) {
        this.cCompanyLogo = cCompanyLogo;
    }

    public Integer getIsApply() {
        return IsApply;
    }

    public void setIsApply(Integer isApply) {
        IsApply = isApply;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(nJobPostId);
        dest.writeValue(nEmpId);
        dest.writeValue(nUserId);
        dest.writeValue(IsApply);
        dest.writeValue(cJobTitle);
        dest.writeValue(cJobLocation);
        dest.writeValue(cDepartment);
        dest.writeValue(cJobDescription);
        dest.writeValue(cJobType);
        dest.writeValue(dtCreatedDate);
        dest.writeValue(dtExpiryDate);
        dest.writeValue(cJobStatus);
        dest.writeValue(isActive);
        dest.writeValue(isDisable);
        dest.writeValue(cRemarks1);
        dest.writeValue(cRemarks2);
        dest.writeValue(cRemarks3);
        dest.writeValue(cRemarks4);
        dest.writeValue(cRemarks5);
        dest.writeValue(cCompanyName);
        dest.writeValue(cCountry);
        dest.writeValue(cCompanyLogo);
        dest.writeValue(fAmount);
        dest.writeValue(fWalletAmount);
        dest.writeValue(fPrice);
    }

    public int describeContents() {
        return 0;
    }

}