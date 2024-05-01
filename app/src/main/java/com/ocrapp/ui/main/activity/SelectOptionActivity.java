package com.ocrapp.ui.main.activity;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ocrapp.base.BaseActivity;
import com.ocrapp.databinding.ActivitySelectOptionBinding;


import com.ocrapp.R;
import com.ocrapp.databinding.ActivityCardHistoryBinding;
import com.ocrapp.ui.main.fragment.ImageToTexttFragment;
import com.ocrapp.ui.main.viewmodel.VMSelectOption;

public class SelectOptionActivity extends BaseActivity<ActivitySelectOptionBinding, VMSelectOption> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_option;
    }

    @Override
    protected Toolbar getToolbar() {
        return null;
    }

    @Override
    protected VMSelectOption getViewModelInstance() {
        return new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(VMSelectOption.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewBinding().ivCardHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectOptionActivity.this, CardHistoryActivity.class));
            }
        });
        getViewBinding().cvCanadaPrCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectOptionActivity.this, ImageToTexttFragment.class).putExtra("cardtype","Canada PR Card"));
            }
        });
        getViewBinding().cvPlumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectOptionActivity.this, ImageToTexttFragment.class).putExtra("cardtype","Plumber"));
            }
        });
        getViewBinding().cvElectrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectOptionActivity.this, ImageToTexttFragment.class).putExtra("cardtype","Electrcian"));
            }
        });
        getViewBinding().cvOntarioDrivingLicence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectOptionActivity.this, ImageToTexttFragment.class).putExtra("cardtype","Ontario Driving Licence"));
            }
        });
        /*ItemCardHistiryAdapter itemInstituteList = new ItemCardHistiryAdapter(CardHistoryActivity.this, ArrayList());
        getViewBinding().rvCardHistory.setAdapter(itemInstituteList);*/
    }
}