package com.ocrapp.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;

import com.ocrapp.BR;


public abstract class BaseActivity<T extends ViewDataBinding,V extends BaseViewModel> extends AppCompatActivity {

    private T viewDataBinding;
    private V viewModel;
    private Toolbar toolbar;


    protected abstract int getLayoutId();
    protected abstract V getViewModelInstance();
    protected abstract Toolbar getToolbar();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDataBinding();
        setUpToolbar();
    }

    private void performDataBinding(){
        viewDataBinding = DataBindingUtil.setContentView(this,getLayoutId());
        this.viewModel = viewModel == null ? getViewModelInstance() : viewModel;
        viewDataBinding.setVariable(BR.model,viewModel);
        viewModel.toastLiveData.observe(this, (Observer<String>) s ->

                showToast
                (s));
    }

    private void setUpToolbar() {
        if (getToolbar() == null) return;
        setSupportActionBar(getToolbar());
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getToolbar().setNavigationOnClickListener(view -> onBackPressed());
    }

    public V getViewModel(){
        return viewModel;
    }
    public T getViewBinding(){
        return viewDataBinding;
    }
    private void showToast(String msg) {
        if(msg.equals("")||msg == null){

        }else{
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
