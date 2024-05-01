package com.ocrapp.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.ocrapp.OCRApp;
import com.ocrapp.data.api.ApiService;


public class BaseViewModel extends AndroidViewModel {

    public ObservableField loadingMsg = new ObservableField("");
    public ObservableBoolean isNoDataFound = new ObservableBoolean(false);
    public ObservableBoolean isNoDataFoundGraph = new ObservableBoolean(false);
    public ObservableBoolean isLoading = new ObservableBoolean(false);

    public MutableLiveData toastLiveData = new MutableLiveData<String>("");
    public MutableLiveData snackBarLiveData = new MutableLiveData<String>("");
    public MutableLiveData showNoInternet = new MutableLiveData<Boolean>();

    public ObservableField<String> screenTitle = new ObservableField<String>("");

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public ApiService getApiService(){
        return OCRApp.getRetrofit().getApiService();
    }

    public void showLoading(String msg) {
        loadingMsg.set(msg);
        isLoading.set(true);
    }
    public void dismissLoading() {
        isLoading.set(false);
    }



    public void showNoDataFound() {
        this.isNoDataFound.set(true);
        this.isNoDataFoundGraph.set(true);
    }

    public void hideNoDataFound() {
        this.isNoDataFound.set(false);
        this.isNoDataFoundGraph.set(false);
    }

    public void showToast( String msg) {
        toastLiveData.postValue(msg);
    }

    public void showSnackBar(String msg){
        snackBarLiveData.postValue(msg);
    }

    public void showNoInternet() {
        showNoInternet.postValue(true);
    }
}