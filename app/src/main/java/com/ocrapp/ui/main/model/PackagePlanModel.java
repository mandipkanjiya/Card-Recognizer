package com.ocrapp.ui.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PackagePlanModel {

@SerializedName("nPackageId")
@Expose
private Integer nPackageId;
@SerializedName("cPackageName")
@Expose
private String cPackageName;
@SerializedName("nDays")
@Expose
private Integer nDays;
@SerializedName("fPrice")
@Expose
private Double fPrice;
@SerializedName("cPackageType")
@Expose
private String cPackageType;
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
@SerializedName("cDescription")
@Expose
private String cDescription;
@SerializedName("cCurrencySymbol")
@Expose
private String cCurrencySymbol;

public Integer getNPackageId() {
return nPackageId;
}

public void setNPackageId(Integer nPackageId) {
this.nPackageId = nPackageId;
}

public String getCPackageName() {
return cPackageName;
}

public void setCPackageName(String cPackageName) {
this.cPackageName = cPackageName;
}

public Integer getNDays() {
return nDays;
}

public void setNDays(Integer nDays) {
this.nDays = nDays;
}

public Double getFPrice() {
return fPrice;
}

public void setFPrice(Double fPrice) {
this.fPrice = fPrice;
}

public String getCPackageType() {
return cPackageType;
}

public void setCPackageType(String cPackageType) {
this.cPackageType = cPackageType;
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

public String getCDescription() {
return cDescription;
}

public void setCDescription(String cDescription) {
this.cDescription = cDescription;
}

public String getCCurrencySymbol() {
return cCurrencySymbol;
}

public void setCCurrencySymbol(String cCurrencySymbol) {
this.cCurrencySymbol = cCurrencySymbol;
}

}