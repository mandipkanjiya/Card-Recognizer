package com.ocrapp.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response<T> implements Parcelable {

    @SerializedName("Success")
    @Expose
    private String success;
    @SerializedName("Result")
    @Expose
    private T result;
    @SerializedName("Message")
    @Expose
    private String message;

    protected Response(Parcel in) {
        success = in.readString();
        message = in.readString();
    }

    public static final Creator<Response> CREATOR = new Creator<Response>() {
        @Override
        public Response createFromParcel(Parcel in) {
            return new Response(in);
        }

        @Override
        public Response[] newArray(int size) {
            return new Response[size];
        }
    };

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T data) {
        this.result = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(success);
        parcel.writeString(message);
    }
}
