package com.ocrapp.ui.main.activity;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ocrapp.R;
import com.ocrapp.base.BaseActivity;
import com.ocrapp.data.ViewVatorConstants;
import com.ocrapp.data.storage.AppPreference;
import com.ocrapp.databinding.ActivityCardHistoryBinding;
import com.ocrapp.ui.main.adapter.ItemCardHistiryAdapter;
import com.ocrapp.ui.main.model.CardHistoryModel;
import com.ocrapp.ui.main.viewmodel.VMCardHistory;

import java.util.ArrayList;
import java.util.List;

public class CardHistoryActivity extends BaseActivity<ActivityCardHistoryBinding, VMCardHistory> {
    List<CardHistoryModel> cardHistoryList = new ArrayList<CardHistoryModel>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_card_history;
    }
    @Override
    protected Toolbar getToolbar() {
        return null;
    }

    @Override
    protected VMCardHistory getViewModelInstance() {
        return new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(VMCardHistory.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getViewBinding().ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Gson gson = new Gson();
        String hashMapString = AppPreference.getInstance(getApplication()).getString(ViewVatorConstants.LIST_CARD_HISTORY);
        java.lang.reflect.Type type = new TypeToken<List<CardHistoryModel>>() {
        }.getType();
        if (hashMapString.length() > 0) {
            cardHistoryList = gson.fromJson(hashMapString, type);
        }
        if(cardHistoryList!=null && cardHistoryList.size()>0) {
            getViewModel().isNoDataFound.set(false);
            ItemCardHistiryAdapter itemInstituteList = new ItemCardHistiryAdapter(CardHistoryActivity.this, cardHistoryList);
            getViewBinding().rvCardHistory.setAdapter(itemInstituteList);
        }else {
            getViewModel().isNoDataFound.set(true);
        }
    }
}