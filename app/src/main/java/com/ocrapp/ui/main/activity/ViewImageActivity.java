package com.ocrapp.ui.main.activity;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.ocrapp.R;
import com.ocrapp.base.BaseActivity;
import com.ocrapp.databinding.ActivityViewImageBinding;
import com.ocrapp.ui.main.viewmodel.VMViewImage;

public class ViewImageActivity extends BaseActivity<ActivityViewImageBinding, VMViewImage> {
    String img="";
    @Override
    protected int getLayoutId() {
        return R.layout.activity_view_image;
    }
    @Override
    protected VMViewImage getViewModelInstance() {
        return new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(VMViewImage.class);
    }

    @Override
    protected Toolbar getToolbar() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getIntent().hasExtra("img_url")){
             img = getIntent().getExtras().getString("img_url");
        }

        if (!img.equals("")) {
            Glide.with(ViewImageActivity.this)
                    .load(img)
                    .placeholder(R.drawable.ic_splash_logo)
                    .error(R.drawable.ic_splash_logo).into(getViewBinding().imgDisplay);

        } else {
            //  mProgressBar.setVisibility(View.GONE);
            getViewBinding().imgDisplay.setImageResource(R.drawable.ic_splash_logo);
        }
    }
}