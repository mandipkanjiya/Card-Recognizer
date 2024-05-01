package com.ocrapp.ui.main.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswerModel implements Parcelable
{

    @SerializedName("nQuestionId")
    @Expose
    private Integer nQuestionId;
    @SerializedName("cQuestionTitle")
    @Expose
    private String cQuestionTitle;
    @SerializedName("cQuestionType")
    @Expose
    private String cQuestionType;
    @SerializedName("nAnswerId")
    @Expose
    private Integer nAnswerId;
    @SerializedName("nJobId")
    @Expose
    private Integer nJobId;
    @SerializedName("nCandidateId")
    @Expose
    private Integer nCandidateId;
    @SerializedName("cAnswerText")
    @Expose
    private String cAnswerText;
    @SerializedName("cAnswerType")
    @Expose
    private String cAnswerType;
    @SerializedName("cQuestionImage")
    @Expose
    private String cQuestionImage;

    @SerializedName("IsAnalyst")
    @Expose
    private String isAnalytics;

    @SerializedName("cVideoId")
    @Expose
    private String cVideoId;



    @SerializedName("cVideoAnalyticsURL")
    @Expose
    private String cVideoAnalyticsURL;


    public final static Parcelable.Creator<AnswerModel> CREATOR = new Creator<AnswerModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AnswerModel createFromParcel(Parcel in) {
            return new AnswerModel(in);
        }

        public AnswerModel[] newArray(int size) {
            return (new AnswerModel[size]);
        }

    }
            ;

    protected AnswerModel(Parcel in) {
        this.nQuestionId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cQuestionTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.cQuestionType = ((String) in.readValue((String.class.getClassLoader())));
        this.nAnswerId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nJobId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nCandidateId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cAnswerText = ((String) in.readValue((String.class.getClassLoader())));
        this.cAnswerType = ((String) in.readValue((String.class.getClassLoader())));
    }

    public AnswerModel() {
    }

    public Integer getNQuestionId() {
        return nQuestionId;
    }

    public void setNQuestionId(Integer nQuestionId) {
        this.nQuestionId = nQuestionId;
    }

    public String getCQuestionTitle() {
        return cQuestionTitle;
    }

    public void setCQuestionTitle(String cQuestionTitle) {
        this.cQuestionTitle = cQuestionTitle;
    }

    public String getCQuestionType() {
        return cQuestionType;
    }

    public void setCQuestionType(String cQuestionType) {
        this.cQuestionType = cQuestionType;
    }

    public Integer getNAnswerId() {
        return nAnswerId;
    }

    public void setNAnswerId(Integer nAnswerId) {
        this.nAnswerId = nAnswerId;
    }

    public Integer getNJobId() {
        return nJobId;
    }

    public void setNJobId(Integer nJobId) {
        this.nJobId = nJobId;
    }

    public Integer getNCandidateId() {
        return nCandidateId;
    }

    public void setNCandidateId(Integer nCandidateId) {
        this.nCandidateId = nCandidateId;
    }

    public String getCAnswerText() {
        return cAnswerText;
    }

    public void setCAnswerText(String cAnswerText) {
        this.cAnswerText = cAnswerText;
    }

    public String getCAnswerType() {
        return cAnswerType;
    }

    public void setCAnswerType(String cAnswerType) {
        this.cAnswerType = cAnswerType;
    }

    public String getcQuestionImage() {
        return cQuestionImage;
    }

    public void setcQuestionImage(String cQuestionImage) {
        this.cQuestionImage = cQuestionImage;
    }

    public String getisAnalytics() {
        return isAnalytics;
    }

    public void setisAnalytics(String isAnalytics) {
        this.isAnalytics = isAnalytics;
    }

    public String getcVideoId() {
        return cVideoId;
    }
    public String getcVideoAnalyticsURL() {
        return cVideoAnalyticsURL;
    }

    public void setcVideoAnalyticsURL(String cVideoAnalyticsURL) {
        this.cVideoAnalyticsURL = cVideoAnalyticsURL;
    }
    public void setcVideoId(String cVideoId) {
        this.cVideoId = cVideoId;
    }
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(nQuestionId);
        dest.writeValue(cQuestionTitle);
        dest.writeValue(cQuestionType);
        dest.writeValue(nAnswerId);
        dest.writeValue(nJobId);
        dest.writeValue(nCandidateId);
        dest.writeValue(cAnswerText);
        dest.writeValue(cAnswerType);
    }

    public int describeContents() {
        return 0;
    }

}
