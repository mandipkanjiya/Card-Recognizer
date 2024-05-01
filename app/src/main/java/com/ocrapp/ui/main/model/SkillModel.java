package com.ocrapp.ui.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkillModel {

@SerializedName("nSkillId")
@Expose
private Integer nSkillId;
@SerializedName("cSkillName")
@Expose
private String cSkillName;
@SerializedName("dtCreatedDate")
@Expose
private String dtCreatedDate;
@SerializedName("nUserId")
@Expose
private Integer nUserId;
@SerializedName("IsActive")
@Expose
private Boolean isActive;
@SerializedName("IsDisable")
@Expose
private Boolean isDisable;

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

public String getDtCreatedDate() {
return dtCreatedDate;
}

public void setDtCreatedDate(String dtCreatedDate) {
this.dtCreatedDate = dtCreatedDate;
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

public Boolean getIsDisable() {
return isDisable;
}

public void setIsDisable(Boolean isDisable) {
this.isDisable = isDisable;
}

}