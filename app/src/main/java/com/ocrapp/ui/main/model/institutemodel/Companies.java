package com.ocrapp.ui.main.model.institutemodel;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Companies implements Parcelable
{

@SerializedName("nUserId")
@Expose
private Integer nUserId;
@SerializedName("cInstituteName")
@Expose
private String cInstituteName;
@SerializedName("cName")
@Expose
private String cName;
@SerializedName("cPhoneNumber")
@Expose
private String cPhoneNumber;
@SerializedName("cAddress")
@Expose
private String cAddress;
@SerializedName("cEmailAddress")
@Expose
private String cEmailAddress;
@SerializedName("cCompanyLogo")
@Expose
private String cCompanyLogo;
@SerializedName("dtCreatedDateTime")
@Expose
private String dtCreatedDateTime;
public final static Creator<Companies> CREATOR = new Creator<Companies>() {


@SuppressWarnings({
"unchecked"
})
public Companies createFromParcel(android.os.Parcel in) {
return new Companies(in);
}

public Companies[] newArray(int size) {
return (new Companies[size]);
}

}
;

protected Companies(android.os.Parcel in) {
this.nUserId = ((Integer) in.readValue((Integer.class.getClassLoader())));
this.cInstituteName = ((String) in.readValue((String.class.getClassLoader())));
this.cName = ((String) in.readValue((String.class.getClassLoader())));
this.cPhoneNumber = ((String) in.readValue((String.class.getClassLoader())));
this.cAddress = ((String) in.readValue((String.class.getClassLoader())));
this.cEmailAddress = ((String) in.readValue((String.class.getClassLoader())));
this.cCompanyLogo = ((String) in.readValue((String.class.getClassLoader())));
this.dtCreatedDateTime = ((String) in.readValue((String.class.getClassLoader())));
}

public Companies() {
}

public Integer getnUserId() {
return nUserId;
}

public void setnUserId(Integer nUserId) {
this.nUserId = nUserId;
}

public String getcInstituteName() {
return cInstituteName;
}

public void setcInstituteName(String cInstituteName) {
this.cInstituteName = cInstituteName;
}

public String getcName() {
return cName;
}

public void setcName(String cName) {
this.cName = cName;
}

public String getcPhoneNumber() {
return cPhoneNumber;
}

public void setcPhoneNumber(String cPhoneNumber) {
this.cPhoneNumber = cPhoneNumber;
}

public String getcAddress() {
return cAddress;
}

public void setcAddress(String cAddress) {
this.cAddress = cAddress;
}

public String getcEmailAddress() {
return cEmailAddress;
}

public void setcEmailAddress(String cEmailAddress) {
this.cEmailAddress = cEmailAddress;
}

public String getcCompanyLogo() {
return cCompanyLogo;
}

public void setcCompanyLogo(String cCompanyLogo) {
this.cCompanyLogo = cCompanyLogo;
}

public String getDtCreatedDateTime() {
return dtCreatedDateTime;
}

public void setDtCreatedDateTime(String dtCreatedDateTime) {
this.dtCreatedDateTime = dtCreatedDateTime;
}

public void writeToParcel(android.os.Parcel dest, int flags) {
dest.writeValue(nUserId);
dest.writeValue(cInstituteName);
dest.writeValue(cName);
dest.writeValue(cPhoneNumber);
dest.writeValue(cAddress);
dest.writeValue(cEmailAddress);
dest.writeValue(cCompanyLogo);
dest.writeValue(dtCreatedDateTime);
}

public int describeContents() {
return 0;
}

}