package com.ocrapp.ui.main.model.imagetotextmodel;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Parcelable
{

    @SerializedName("nAudioTextId")
    @Expose
    private Integer nAudioTextId;
    @SerializedName("cAudioText")
    @Expose
    private String cAudioText;
    @SerializedName("nCandidateId")
    @Expose
    private Integer nCandidateId;
    @SerializedName("dtCreatedDate")
    @Expose
    private String dtCreatedDate;
    public final static Creator<Result> CREATOR = new Creator<Result>() {


        public Result createFromParcel(android.os.Parcel in) {
            return new Result(in);
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    }
            ;

    @SuppressWarnings({
            "unchecked"
    })
    protected Result(android.os.Parcel in) {
        this.nAudioTextId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cAudioText = ((String) in.readValue((String.class.getClassLoader())));
        this.nCandidateId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dtCreatedDate = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Result() {
    }

    /**
     *
     * @param nAudioTextId
     * @param cAudioText
     * @param nCandidateId
     * @param dtCreatedDate
     */
    public Result(Integer nAudioTextId, String cAudioText, Integer nCandidateId, String dtCreatedDate) {
        super();
        this.nAudioTextId = nAudioTextId;
        this.cAudioText = cAudioText;
        this.nCandidateId = nCandidateId;
        this.dtCreatedDate = dtCreatedDate;
    }

    public Integer getnAudioTextId() {
        return nAudioTextId;
    }

    public void setnAudioTextId(Integer nAudioTextId) {
        this.nAudioTextId = nAudioTextId;
    }

    public String getcAudioText() {
        return cAudioText;
    }

    public void setcAudioText(String cAudioText) {
        this.cAudioText = cAudioText;
    }

    public Integer getnCandidateId() {
        return nCandidateId;
    }

    public void setnCandidateId(Integer nCandidateId) {
        this.nCandidateId = nCandidateId;
    }

    public String getDtCreatedDate() {
        return dtCreatedDate;
    }

    public void setDtCreatedDate(String dtCreatedDate) {
        this.dtCreatedDate = dtCreatedDate;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(nAudioTextId);
        dest.writeValue(cAudioText);
        dest.writeValue(nCandidateId);
        dest.writeValue(dtCreatedDate);
    }

    public int describeContents() {
        return 0;
    }

}