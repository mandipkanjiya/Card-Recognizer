package com.ocrapp.ui.main.model.institutemodel;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobType implements Parcelable {

    @SerializedName("cJobType")
    @Expose
    private String cJobType;
    public final static Creator<JobType> CREATOR = new Creator<JobType>() {


        @SuppressWarnings({
                "unchecked"
        })
        public JobType createFromParcel(android.os.Parcel in) {
            return new JobType(in);
        }

        public JobType[] newArray(int size) {
            return (new JobType[size]);
        }

    };

    protected JobType(android.os.Parcel in) {
        this.cJobType = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobType() {
    }

    public String getcJobType() {
        return cJobType;
    }

    public void setcJobType(String cJobType) {
        this.cJobType = cJobType;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(cJobType);
    }

    public int describeContents() {
        return 0;
    }

}