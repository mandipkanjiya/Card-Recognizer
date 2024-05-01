package com.ocrapp.util.permission;



public interface OnRequestPermissionsCallBack{

    void onGrant();

    void onDenied(String permission);
}
