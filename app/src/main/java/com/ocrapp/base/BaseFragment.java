package com.ocrapp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.ocrapp.BR;


public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {

    private T viewDataBinding;
    private V viewModel;


    protected abstract int getLayoutId();

    protected abstract V getViewModelInstance();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = getViewModelInstance();
        setHasOptionsMenu(false);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return viewDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewDataBinding.setVariable(BR.model, viewModel);
        viewDataBinding.executePendingBindings();

        viewModel.toastLiveData.observe(getViewLifecycleOwner(), (Observer<String>) s ->

                showToast

                        (s));

    }


    public V getViewModel() {
        return viewModel;
    }

    public T getViewBinding() {
        return viewDataBinding;
    }

    private void showToast(String msg) {
        if (msg.equals("") || msg == null) {

        } else {
            viewModel.toastLiveData.setValue("");
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }

    }
}
