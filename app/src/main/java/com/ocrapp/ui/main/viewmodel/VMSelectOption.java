package com.ocrapp.ui.main.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;

import com.ocrapp.base.BaseViewModel;
import com.ocrapp.data.ViewVatorConstants;
import com.ocrapp.ui.main.model.institutemodel.Companies;
import com.ocrapp.ui.main.model.institutemodel.InstituteListModel;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class VMSelectOption extends BaseViewModel {
    public MutableLiveData<List<Companies>> instituteList = new MutableLiveData<>();
    public ObservableBoolean isNoDataFound = new ObservableBoolean(false);

    //public ObservableBoolean isLoading = new ObservableBoolean(false);
    public VMSelectOption(@NonNull Application application) {
        super(application);
    }

    public void getCompanyDetails() {
        showLoading("");
        HashMap<String, String> map = new HashMap<>();
        map.put("cToken", ViewVatorConstants.DEFAULT_TOKEN);

        getApiService().getInstituteList(map).enqueue(new Callback<List<InstituteListModel>>() {
            @Override
            public void onResponse(Call<List<InstituteListModel>> call, retrofit2.Response<List<InstituteListModel>> response) {
                dismissLoading();
                if (response.isSuccessful()) {
                    if (response.body().get(0).getSuccess().equals("1")) {
                        instituteList.setValue(response.body().get(0).getCompaniesList());
                        isNoDataFound.set(false);
                    } else {
                        isNoDataFound.set(true);
                    }


                }

            }

            @Override
            public void onFailure(Call<List<InstituteListModel>> call, Throwable t) {
                dismissLoading();
                t.printStackTrace();
            }
        });
    }
}

