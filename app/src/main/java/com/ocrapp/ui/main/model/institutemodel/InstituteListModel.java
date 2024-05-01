package com.ocrapp.ui.main.model.institutemodel;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InstituteListModel implements Parcelable {

    @SerializedName("Success")
    @Expose
    private String success;
    @SerializedName("CompaniesList")
    @Expose
    private List<Companies> companiesList = null;
    @SerializedName("JobType")
    @Expose
    private List<JobType> jobType = null;
    public final static Creator<InstituteListModel> CREATOR = new Creator<InstituteListModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public InstituteListModel createFromParcel(android.os.Parcel in) {
            return new InstituteListModel(in);
        }

        public InstituteListModel[] newArray(int size) {
            return (new InstituteListModel[size]);
        }

    };

    protected InstituteListModel(android.os.Parcel in) {
        this.success = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.companiesList, (Companies.class.getClassLoader()));
        in.readList(this.jobType, (JobType.class.getClassLoader()));
    }

    public InstituteListModel() {
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<Companies> getCompaniesList() {
        return companiesList;
    }

    public void setCompaniesList(List<Companies> companiesList) {
        this.companiesList = companiesList;
    }

    public List<JobType> getJobType() {
        return jobType;
    }

    public void setJobType(List<JobType> jobType) {
        this.jobType = jobType;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(success);
        dest.writeList(companiesList);
        dest.writeList(jobType);
    }

    public int describeContents() {
        return 0;
    }

}