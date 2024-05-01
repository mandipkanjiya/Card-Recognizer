package com.ocrapp.ui.main.model;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;

import com.ocrapp.base.BaseViewModel;
import com.ocrapp.data.Response;
import com.ocrapp.data.ViewVatorConstants;
import com.ocrapp.data.storage.AppPreference;
import com.ocrapp.util.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class VMOtherInfo extends BaseViewModel {
    public ObservableField<String> userEmail = new ObservableField<>("");
    public ObservableField<String> userAddress = new ObservableField<>("");
    public ObservableField<String> userPhone= new ObservableField<>("");

    public ObservableField<String> userFName = new ObservableField<>("");
    public ObservableField<String> userMName = new ObservableField<>("");
    public ObservableField<String> userLName = new ObservableField<>("");

    public MutableLiveData<List<SkillModel>> skilllist = new MutableLiveData<>();
    public MutableLiveData<GetUserAllDetails> getUserDetailData = new MutableLiveData<>();
    public MutableLiveData<FileUploadLIst> imageUploadData = new MutableLiveData<>();
    public MutableLiveData<FileUploadLIst> resumeUploadData = new MutableLiveData<>();
    public MutableLiveData<User> userOtherData = new MutableLiveData<>();
    public VMOtherInfo(Application application) {
        super(application);
    }
    File selectedFile;
    public void getSkillList(){

        HashMap<String ,String > map =  new HashMap<>();
       // map.put("nUserId", NaytivConstants.DEFAULT_USER_ID);
        map.put("cToken", ViewVatorConstants.DEFAULT_TOKEN);


        //showLoading("");
        getApiService().getSkillList(map).enqueue(new Callback<List<Response<List<SkillModel>>>>() {
            @Override
            public void onResponse(Call<List<Response<List<SkillModel>>>> call, retrofit2.Response<List<Response<List<SkillModel>>>> response) {
                //dismissLoading();
                if(response.body().get(0).getSuccess().equalsIgnoreCase("1")){
                    skilllist.setValue(response.body().get(0).getResult());

                }else{
                    showToast(response.body().get(0).getMessage());
                }

            }

            @Override
            public void onFailure(Call<List<Response<List<SkillModel>>>> call, Throwable t) {
           //     dismissLoading();

            }
        });
    }

    public void getUserDetails(){

        HashMap<String ,String > map =  new HashMap<>();
        // map.put("nUserId", NaytivConstants.DEFAULT_USER_ID);
        map.put("cToken",ViewVatorConstants.DEFAULT_TOKEN);
        map.put("nCandidateId",AppPreference.getInstance(getApplication()).getUser().getNCandidateId().toString());
        //showLoading("");
        getApiService().getUserDetails(map).enqueue(new Callback<List<Response<GetUserAllDetails>>>() {
            @Override
            public void onResponse(Call<List<Response<GetUserAllDetails>>> call, retrofit2.Response<List<Response<GetUserAllDetails>>> response) {
                //dismissLoading();
                if(response.body().get(0).getSuccess().equalsIgnoreCase("1")){
                    getUserDetailData.setValue(response.body().get(0).getResult());
                }else{
                    showToast(response.body().get(0).getMessage());
                }

            }

            @Override
            public void onFailure(Call<List<Response<GetUserAllDetails>>> call, Throwable t) {
                //     dismissLoading();

            }
        });
    }
    public void setSelectedFileUri(Intent data) {
        try {
            Uri selectedImageUri = data.getData();
            String fileUri = FileUtils.getPath(getApplication().getApplicationContext(), selectedImageUri);
            //byte[] imgStream = FileUtils.compressImage(fileUri);
            selectedFile = new File(fileUri);
        /*    File compressimagefile = new Compressor(getApplication().getApplicationContext())
                    .setQuality(75)
                    .compressToFile(selectedFile);*/
            //selectedFile = compressimagefile;
            //uploadFile.setValue(selectedFile.getAbsolutePath());
            //uploadFile(getApplication().getContentResolver().getType(selectedImageUri));
            callUploadImage(getApplication().getContentResolver().getType(selectedImageUri),"CandidateImage");
        } catch (Exception e) {
            Log.e("Error",e.getMessage());
        }
    }
    //method for set capturing image from camera
    public void setCaptureImage(File filename) {
        Uri tempUri = Uri.fromFile(filename);

       /* File compressimagefile = null;
        try {
            compressimagefile = new Compressor(getApplication().getApplicationContext())
                    .setQuality(75)
                    .compressToFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        selectedFile = filename;
        //uploadFile(getApplication().getContentResolver().getType(tempUri));
        callUploadImage(getApplication().getContentResolver().getType(tempUri),"CandidateImage");
    }

  /*  public void setSelectedFileUri(Intent data) {
        try {
            Uri selectedImageUri = data.getData();
            String fileUri = FileUtils.getPath(getApplication(), selectedImageUri);
            byte[] imgStream = FileUtils.compressImage(fileUri);
            selectedFile = new File(FileUtils.storeImageStream(imgStream, "IELTS/Images"));
            callUploadImage(getApplication().getContentResolver().getType(selectedImageUri),"CandidateImage");
        } catch (Exception e) {
            Log.e("Error",e.getMessage());
        }
    }*/
    public void setSelectedResumeFileUri(Context context,Intent data) {
       try {
            Uri selectedImageUri = data.getData();
            String fileUri = FileUtils.getPath(getApplication(), selectedImageUri);
            //String path = FileUtils.getFilePathFromURI(context,selectedImageUri);
           // byte[] imgStream = FileUtils.compressImage(fileUri);

                    //selectedFile = new File(FileUtils.storePdfStream(fileUri.getBytes(), "Viewvator/Resume"));
            selectedFile = new File(fileUri);
            callUploadImage(getApplication().getContentResolver().getType(selectedImageUri),"UploadResume");
       } catch (Exception e) {
            Log.e("Error",e.getMessage());
        }
    }
   /* public void setCaptureImage(File filename) {
        Uri tempUri = Uri.fromFile(filename);
        byte[] imgStream = FileUtils.compressImage(tempUri.getPath());
        selectedFile = new File(FileUtils.storeImageStream(imgStream, "IELTS/Images"));
        callUploadImage(getApplication().getContentResolver().getType(tempUri),"CandidateImage");
    }*/

    public MultipartBody.Part prepareMultiPart(File file, String fileName, String type) {
        RequestBody reqFile = RequestBody.create(MediaType.parse("image/jpg"), file);
        return MultipartBody.Part.createFormData(fileName, file.getName(), reqFile);
    }
    public void callUploadImage(String type, String candidateImage) {
        try {
            showLoading("");
            ArrayList<MultipartBody.Part> parts = new ArrayList<>();
            if (selectedFile != null){
                if (selectedFile != null && selectedFile.exists()){
                    parts.add(prepareMultiPart(selectedFile,"UploadedFile",type));
                }
            }
            parts.add(MultipartBody.Part.createFormData("nUserId",ViewVatorConstants.DEFAULT_USER_ID));
            parts.add(MultipartBody.Part.createFormData("FileType",candidateImage));
            parts.add(MultipartBody.Part.createFormData("cToken",ViewVatorConstants.DEFAULT_TOKEN));

            getApiService().uploadFile(parts)
                    .enqueue(new Callback<List<FileUploadLIst>>() {
                        @Override
                        public void onResponse(Call<List<FileUploadLIst>> call, retrofit2.Response<List<FileUploadLIst>> response) {
                            dismissLoading();

                            String success = response.body().get(0).getSuccess();
                            //closeDialog();
                            switch (success) {
                                case "1":
                                    if(candidateImage.equals("CandidateImage")) {
                                        imageUploadData.setValue(response.body().get(0));
                                    }
                                    if(candidateImage.equals("UploadResume")) {
                                        resumeUploadData.setValue(response.body().get(0));
                                    }
                                    break;
                                case "0":

                                    break;
                            }
                        }

                        @Override
                        public void onFailure(Call<List<FileUploadLIst>> call, Throwable t) {
                            dismissLoading();
                            Log.e("Upload", "" + t);
                        }
                    });

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    public void otherdetailsupdate(String userImagePath, String userResumePath, String jsonArraySkill, String  text, String edtLastNameText, String edtEmailText, String edtPhoneText, String edtAddressText,String phoneCode,String cGoalBand,String cLastExamBand){

        if(userFName.get().equalsIgnoreCase("")){
            showToast("Please enter name");
            return;
        }
        if(userPhone.get().equalsIgnoreCase("")){
            showToast("Please enter mobile number");
            return;
        }
       /* if(userEmail.get()==null || userEmail.get().isEmpty() ){
            showToast("Please Enter Username");
            return;
        }*/
       /* if(TextUtils.isEmpty(userImagePath)){
            showToast("Please select User image");
            return;
        }*/
        /*if(TextUtils.isEmpty(userResumePath)){
            showToast("Please Enter Password");
            return;
        }*/
        /*if(TextUtils.isEmpty(jsonArraySkill)){
            showToast("Please choose skill");
            return;
        }*/
        HashMap<String ,String > map =  new HashMap<>();
        //map.put("nUserId", NaytivConstants.DEFAULT_USER_ID);
        map.put("cToken",ViewVatorConstants.DEFAULT_TOKEN);
        map.put("nCandidateId",AppPreference.getInstance(getApplication()).getUser().getNCandidateId().toString());
        map.put("cCandidateImage",userImagePath);
        map.put("cUploadResume","");
        map.put("cSkillJsonData","[]");
        map.put("cPassword","");
        map.put("cCandidateFirstName",text);
       // map.put("cCandidateMiddleName",userMName.get());
        map.put("cCandidateLastName",edtLastNameText);
        map.put("cCandidateContactNo",edtPhoneText);
        map.put("cCandidateEmailId",edtEmailText);
        map.put("cCandidateAddress",edtAddressText);
       // map.put("cCity",userCity.get());
       // map.put("cZipCode",userPincode.get());
        map.put("cAboutCandidate","");
        map.put("cPhoneCode",phoneCode);
        map.put("cType",jsonArraySkill);
        map.put("cLastExamBand",cLastExamBand);
        map.put("cGoalBand",cGoalBand);
        Log.e("aadilparam",map.toString());
        showLoading("");
        getApiService().userOtherDetails(map).enqueue(new Callback<List<Response<User>>>() {
            @Override
            public void onResponse(Call<List<Response<User>>> call, retrofit2.Response<List<Response<User>>> response) {
                dismissLoading();
                if(response.body().get(0).getSuccess().equalsIgnoreCase("1")){
                    userOtherData.setValue(response.body().get(0).getResult());
                    AppPreference.getInstance(getApplication()).saveUser(userOtherData.getValue());
                    //AppPreference.getInstance(getApplication()).saveUser(userOtherData.getValue());
                 //   AppPreference.getInstance(getApplication()).saveBoolean("isLogin",true);
                    //   AppPreference.getInstance(getApplication()).saveString(AppPreferenceKey.IS_STEPS_ADDED,response.body().getResult().getIsStepsAdded());

                }else{
                    showToast(response.body().get(0).getMessage());
                }

            }

            @Override
            public void onFailure(Call<List<Response<User>>> call, Throwable t) {
                dismissLoading();

            }
        });

    }
}
