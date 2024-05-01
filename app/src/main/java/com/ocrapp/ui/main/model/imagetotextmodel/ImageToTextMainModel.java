package com.ocrapp.ui.main.model.imagetotextmodel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import android.os.Parcelable;


public class ImageToTextMainModel implements Parcelable
{

    @SerializedName("Success")
    @Expose
    private String success;
    @SerializedName("Result")
    @Expose
    private List<Result> result;
    @SerializedName("nTotalCount")
    @Expose
    private Integer nTotalCount;
    public final static Creator<ImageToTextMainModel> CREATOR = new Creator<ImageToTextMainModel>() {


        public ImageToTextMainModel createFromParcel(android.os.Parcel in) {
            return new ImageToTextMainModel(in);
        }

        public ImageToTextMainModel[] newArray(int size) {
            return (new ImageToTextMainModel[size]);
        }

    }
            ;

    @SuppressWarnings({
            "unchecked"
    })
    protected ImageToTextMainModel(android.os.Parcel in) {
        this.success = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.result, (Result.class.getClassLoader()));
        this.nTotalCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public ImageToTextMainModel() {
    }

    /**
     *
     * @param result
     * @param success
     * @param nTotalCount
     */
    public ImageToTextMainModel(String success, List<Result> result, Integer nTotalCount) {
        super();
        this.success = success;
        this.result = result;
        this.nTotalCount = nTotalCount;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public Integer getnTotalCount() {
        return nTotalCount;
    }

    public void setnTotalCount(Integer nTotalCount) {
        this.nTotalCount = nTotalCount;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(success);
        dest.writeList(result);
        dest.writeValue(nTotalCount);
    }

    public int describeContents() {
        return 0;
    }

}