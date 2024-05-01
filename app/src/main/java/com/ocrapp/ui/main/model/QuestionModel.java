package com.ocrapp.ui.main.model;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionModel implements Parcelable
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
    @SerializedName("cQuestionImage")
    @Expose
    private String cQuestionImage;


    public boolean isTimerAlarm() {
        return isTimerAlarm;
    }

    public void setTimerAlarm(boolean timerAlarm) {
        isTimerAlarm = timerAlarm;
    }

    private boolean isTimerAlarm = false;
    private boolean isTimerEnd = false;
    private boolean isAttempt = false;
    private boolean isFileUploaded = false;
    private String videoLocalPath = "";
    private String speechToText = "";

    public final static Parcelable.Creator<QuestionModel> CREATOR = new Creator<QuestionModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public QuestionModel createFromParcel(Parcel in) {
            return new QuestionModel(in);
        }

        public QuestionModel[] newArray(int size) {
            return (new QuestionModel[size]);
        }

    }
            ;

    protected QuestionModel(Parcel in) {
        this.nQuestionId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cQuestionTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.cQuestionType = ((String) in.readValue((String.class.getClassLoader())));
    }

    public QuestionModel() {
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

    public String getcQuestionImage() {
        return cQuestionImage;
    }

    public void setcQuestionImage(String cQuestionImage) {
        this.cQuestionImage = cQuestionImage;
    }


    public boolean isAttempt() {
        return isAttempt;
    }

    public void setAttempt(boolean attempt) {
        isAttempt = attempt;
    }

    public boolean isFileUploaded() {
        return isFileUploaded;
    }

    public void setFileUploaded(boolean fileUploaded) {
        isFileUploaded = fileUploaded;
    }

    public String getVideoLocalPath() {
        return videoLocalPath;
    }

    public void setVideoLocalPath(String videoLocalPath) {
        this.videoLocalPath = videoLocalPath;
    }
    public String getAudioSpeechToText() {
        return speechToText;
    }

    public void setAudioSpeechToText(String speechToText) {
        this.speechToText = speechToText;
    }
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(nQuestionId);
        dest.writeValue(cQuestionTitle);
        dest.writeValue(cQuestionType);
    }

    public int describeContents() {
        return 0;
    }
    public boolean isTimerEnd() {
        return isTimerEnd;
    }

    public void setTimerEnd(boolean timerEnd) {
        isTimerEnd = timerEnd;
    }

}
