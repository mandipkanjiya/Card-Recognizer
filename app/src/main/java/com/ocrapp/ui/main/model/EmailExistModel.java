package com.ocrapp.ui.main.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class EmailExistModel {

@SerializedName("Success")
@Expose
private String success;
@SerializedName("IsExistEmail")
@Expose
private Integer isExistEmail;

/**
* No args constructor for use in serialization
*
*/
public EmailExistModel() {
}

/**
*
* @param success
* @param isExistEmail
*/
public EmailExistModel(String success, Integer isExistEmail) {
super();
this.success = success;
this.isExistEmail = isExistEmail;
}

public String getSuccess() {
return success;
}

public void setSuccess(String success) {
this.success = success;
}

public Integer getIsExistEmail() {
return isExistEmail;
}

public void setIsExistEmail(Integer isExistEmail) {
this.isExistEmail = isExistEmail;
}

}