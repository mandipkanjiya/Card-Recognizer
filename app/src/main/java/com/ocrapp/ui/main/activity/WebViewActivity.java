package com.ocrapp.ui.main.activity;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.ocrapp.R;
import com.ocrapp.base.BaseActivity;
import com.ocrapp.databinding.ActivityWebViewBinding;
import com.ocrapp.ui.main.viewmodel.VMWebView;

public class WebViewActivity extends BaseActivity<ActivityWebViewBinding, VMWebView> {

    Intent intent;
    String url="";
    @Override
    protected int getLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    protected VMWebView getViewModelInstance() {
        return new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(VMWebView.class);
    }

    @Override
    protected Toolbar getToolbar() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }
    public void init(){
        intent=getIntent();
        if(getIntent().hasExtra("url")){
            url=intent.getStringExtra("url");
        }

        WebSettings webSettings = getViewBinding().webView.getSettings();
          getViewBinding().webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
         webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
         webSettings.setJavaScriptEnabled(true);
        //  getViewBinding().webView.setHorizontalScrollBarEnabled(false);
        // getViewBinding().webView.getSettings().setLoadsImagesAutomatically(true);
        getViewBinding().webView.getSettings().setJavaScriptEnabled(true);
        getViewBinding().webView.setWebChromeClient(new WebChromeClient());
        getViewBinding().webView.setWebViewClient(new WebViewClient());
        if (url != null) {
            getViewBinding().webView.loadUrl(url);
        }

        getViewBinding().ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}