package com.ocrapp.ui.main.fragment;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.lifecycle.ViewModelProvider;

import com.app.cardocrlibrary.CardRecognizeConstat;
import com.app.cardocrlibrary.CardRecognizeInfo;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ocrapp.R;
import com.ocrapp.base.BaseActivity;
import com.ocrapp.data.ViewVatorConstants;
import com.ocrapp.data.storage.AppPreference;
import com.ocrapp.databinding.FragementImageToTextBinding;
import com.ocrapp.ui.main.activity.CardHistoryActivity;
import com.ocrapp.ui.main.model.CardHistoryModel;
import com.ocrapp.ui.main.model.imagetotextmodel.Result;
import com.ocrapp.ui.main.viewmodel.VMImageToText;
import com.ocrapp.util.DateUtils;
import com.ocrapp.util.FileUtils;
import com.ocrapp.util.InternalStorageContentProvider;

import com.ocrapp.util.permission.OnRequestPermissionsCallBack;
import com.ocrapp.util.permission.PermissionManager;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ImageToTexttFragment extends BaseActivity<FragementImageToTextBinding, VMImageToText> {
    FirebaseVisionText firebaseVisionText = null;
    String date1 = "";
    String date2 = "";
    String date3 = "";
    String date4 = "";
   // String birthDate = "";
    String birthDate = "";
    String effectiveDate = "";
    String expiryDate = "";
    String licenceNumber = "";
    String cardIdNumber = "";
    String Name = "";
    String licenseAddress = "";
    String gender = "";

    String countryNameCode = "";

    CardHistoryModel cardHistoryModel = new CardHistoryModel();
    File mFileTemp;
    ImageView postImageView1;
    //ImageView postImageView;
    //ProgressBar progressbar;
    //  TextView btnPost;
    //LinearLayout linUploadImage;
    Dialog dialogPost;
    List<Result> results = new ArrayList<>();
    boolean isPaginate = false;
    int start = 1, end = 10;
    int deletePosition;
    int startmPage = start, endPage = end, mTotalCount = 0;

    TextToSpeech textToSpeech = null;
    String imagetextResult = "";
    String cardType = "";

    List<String> stringArray = new ArrayList<String>();

    List<CardHistoryModel> cardHistoryList = new ArrayList<CardHistoryModel>();
    @Override
    protected VMImageToText getViewModelInstance() {
        return new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(VMImageToText.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().hasExtra("cardtype")) {
            cardType = getIntent().getExtras().getString("cardtype");
        }
        getViewBinding().tvTitle.setText(cardType + " Recognition");
         cardRecognizeInfo =  new CardRecognizeInfo().getInstance(ImageToTexttFragment.this);
        cardRecognizeInfo.setOnCardOcrListener(new CardRecognizeInfo.OnCardOcrListener() {
            @Override
            public void onSuccess(FirebaseVisionText string) {
                Log.e("FirebaseVisionText",string.getText());
              /*  for (FirebaseVisionText.TextBlock block : string.getTextBlocks()) {
                    imagetextResult = imagetextResult + block.getText() + " ";
                    stringArray = Arrays.asList(block.getText().split("\n"));
                }*/
            }

            @Override
            public void onFailed(String string) {

            }
        });
        Gson gson = new Gson();
        String hashMapString = AppPreference.getInstance(getApplication()).getString(ViewVatorConstants.LIST_CARD_HISTORY);
        java.lang.reflect.Type type = new TypeToken<List<CardHistoryModel>>() {
        }.getType();
        if (hashMapString.length() > 0) {
            cardHistoryList = gson.fromJson(hashMapString, type);
        }
        cardHistoryModel.setCardType(cardType);
        init();
        apiObserve();
     /*   String bloack111="gdfdfgdfgoO668-47010-70296";
        bloack111 = bloack111.replace("o", "0");
        bloack111 = bloack111.replace("O", "0");*/
        /*if(bloack111.startsWith("0")) {
            bloack111 = bloack111.replaceFirst("0", "O");
        }*/
        /*String validNumber = findNumberDriLicense(bloack111.toString().trim());
        if(validNumber.startsWith("0"))
        {
            validNumber=  validNumber.replaceFirst("0", "O");
        }
        Log.e("bloack111", "Yes " + validNumber.toString());
        String licenceDate="2015/02/024bEXP/EXP";
      String  DateFromDriLicense = findDateFromDriLicense(licenceDate);
        Log.e("DateFromDriLicense", "Yes " + DateFromDriLicense);*/
      /*  Log.e("DateFromDriLicense", "Yes " + DateFromDriLicense);
        // System.out.println("yes");
        bloack111 =  bloack111.replaceFirst("D", "");

        Log.e("test capsbloack111", "Yes " + bloack111.toString());*/
        getViewBinding().ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getViewBinding().ivCardHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ImageToTexttFragment.this, CardHistoryActivity.class));
            }
        });
        getViewBinding().btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firebaseVisionText != null) {
                    getViewModel().isNoDataFound.set(false);
                    for (FirebaseVisionText.TextBlock block : firebaseVisionText.getTextBlocks()) {
                        imagetextResult = imagetextResult + block.getText() + " ";
                        stringArray = Arrays.asList(block.getText().split("\n"));


                        //Log.e
                        if(cardType.equalsIgnoreCase("Electrcian Card")) {
                            setName(stringArray);
                            setExpiryAndEffectiveDate(stringArray);
                            setLicenceNumber(stringArray);

                            cardHistoryList.add(cardHistoryModel);

                            Gson gson = new Gson();
                            String updatedListString = gson.toJson(cardHistoryList);
                            AppPreference.getInstance(getApplication()).saveString(ViewVatorConstants.LIST_CARD_HISTORY, updatedListString);
                        }
                        if(cardType.equalsIgnoreCase("Canada PR Card")) {
                            setCanadaPRcardName(stringArray);
                            setBirthAndExpiryDate(stringArray);
                            setCanadaIdNumber(stringArray);
                            setGender(stringArray);
                            setCountryNamePRcard(stringArray);

                            cardHistoryList.add(cardHistoryModel);

                            Gson gson = new Gson();
                            String updatedListString = gson.toJson(cardHistoryList);
                            AppPreference.getInstance(getApplication()).saveString(ViewVatorConstants.LIST_CARD_HISTORY, updatedListString);
                        }
                        if(cardType.equalsIgnoreCase("Ontario Driving Licence")) {
                          //  setCanadaPRcardName(stringArray);
                            setOnDirLicenseDate(stringArray);
                            setOnDirLicenseNumber(stringArray);
                            setOnDriLicenseGender(stringArray);
                            setOnDriLicenseName(stringArray);
                            setOnDriLicenseAddress(stringArray);
                          //  setGender(stringArray);
                          //  setCountryNamePRcard(stringArray);

                            //cardHistoryList.add(cardHistoryModel);

                           // Gson gson = new Gson();
                           // String updatedListString = gson.toJson(cardHistoryList);
                          //  AppPreference.getInstance(getApplication()).saveString(ViewVatorConstants.LIST_CARD_HISTORY, updatedListString);
                        }
                    }
                }

            }
        });
        getViewBinding().postImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //requesting permission

                new PermissionManager.Builder(ImageToTexttFragment.this)
                        .addPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
                        .addRequestPermissionsCallBack(new OnRequestPermissionsCallBack() {
                            @Override
                            public void onGrant() {
                                imagePickerDialog();//open Image picker

                            }

                            @Override
                            public void onDenied(String permission) {
                                //getViewModel().showToast(ViewUtils.setLabel(DWACQuestionActivity.this ,"", LabelKey.LBL_ADD_ADRESS_ALTMOBILENO_PLACE_HOLDER));
                            }
                        }).build().request();
            }
        });
        getViewBinding().linUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //requesting permission
                new PermissionManager.Builder(ImageToTexttFragment.this)
                        .addPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
                        .addRequestPermissionsCallBack(new OnRequestPermissionsCallBack() {
                            @Override
                            public void onGrant() {
                                imagePickerDialog();//open Image picker

                            }

                            @Override
                            public void onDenied(String permission) {
                                //getViewModel().showToast(ViewUtils.setLabel(DWACQuestionActivity.this ,"", LabelKey.LBL_ADD_ADRESS_ALTMOBILENO_PLACE_HOLDER));
                            }
                        }).build().request();
            }
        });
        getViewBinding().btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getViewModel().isNoDataFound.set(true);
                cardHistoryModel = null;
                cardHistoryModel = new CardHistoryModel();
                getViewBinding().linUploadImage.setVisibility(View.VISIBLE);
                getViewBinding().postImageView.setVisibility(View.GONE);
                getViewBinding().tvName.setText(cardHistoryModel.getName().toString());
                getViewBinding().tvEffectiveDate.setText("-");
                getViewBinding().tvExpiryDate.setText("-");
                getViewBinding().tvLicenseNumber.setText("-");
                date1 = "";
                date2 = "";

                effectiveDate = "";
                expiryDate = "";
                licenceNumber = "";
                Name = "";
                firebaseVisionText = null;
                new PermissionManager.Builder(ImageToTexttFragment.this)
                        .addPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
                        .addRequestPermissionsCallBack(new OnRequestPermissionsCallBack() {
                            @Override
                            public void onGrant() {
                                imagePickerDialog();//open Image picker

                            }

                            @Override
                            public void onDenied(String permission) {
                                //getViewModel().showToast(ViewUtils.setLabel(DWACQuestionActivity.this ,"", LabelKey.LBL_ADD_ADRESS_ALTMOBILENO_PLACE_HOLDER));
                            }
                        }).build().request();
            }
        });
    }

    public void init() {
        if(cardType.equals("Electrcian Card")){
            getViewBinding().linElectricianCard.setVisibility(View.VISIBLE);
            getViewBinding().linCanadaPrCard.setVisibility(View.GONE);
            getViewBinding().linOntarioDriLicense.setVisibility(View.GONE);
        }else if(cardType.equals("Canada PR Card")){
            getViewBinding().linElectricianCard.setVisibility(View.GONE);
            getViewBinding().linCanadaPrCard.setVisibility(View.VISIBLE);
            getViewBinding().linOntarioDriLicense.setVisibility(View.GONE);
        }
        else if(cardType.equals("Ontario Driving Licence")){
            getViewBinding().linElectricianCard.setVisibility(View.GONE);
            getViewBinding().linCanadaPrCard.setVisibility(View.GONE);
            getViewBinding().linOntarioDriLicense.setVisibility(View.VISIBLE);
        }
        getViewModel().isNoDataFound.set(true);
        //   getViewBinding().swipeContainer.setOnRefreshListener(this);
        textToSpeech = new TextToSpeech(ImageToTexttFragment.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                // if No error is found then only it will run
                //  Log.e("error",String.valueOf(i));
                if (i != TextToSpeech.ERROR) {
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });

    }

    public void apiObserve() {



    }

    public void imagePickerDialog() {

        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(ImageToTexttFragment.this);
        alertDialogBuilder.setTitle("Picture Option");
        alertDialogBuilder.setMessage("Select Picture Mode")
                .setCancelable(true)
                .setPositiveButton("Camera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                            mFileTemp = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                                    "image" + System.currentTimeMillis() + ".jpg");
                        } else {
                            mFileTemp = new File(getFilesDir(), "image" + System.currentTimeMillis() + ".jpg");
                        }
                        try {
                            Uri mImageCaptureUri = null;
                            String state = Environment.getExternalStorageState();
                            if (Environment.MEDIA_MOUNTED.equals(state)) {
                                mImageCaptureUri = FileProvider.getUriForFile(ImageToTexttFragment.this, getPackageName() + ".provider", mFileTemp);
                            } else {
                                mImageCaptureUri = InternalStorageContentProvider.CONTENT_URI;
                            }
                            takePicture.putExtra(MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
                            takePicture.putExtra("return-data", true);
                            startActivityForResult(takePicture, 156);
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                })
                .setNegativeButton("Gallery", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("image/*");
                        startActivityForResult(intent, 155);
                    }
                }).show();


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 155) {
                //getViewModel().setSelectedFileUri(data);
                Uri selectedImageUri = data.getData();
                String fileUri = FileUtils.getPath(ImageToTexttFragment.this, selectedImageUri);
                //byte[] imgStream = FileUtils.compressImage(fileUri);
                File selectedFile = new File(fileUri);
                Glide.with(ImageToTexttFragment.this)
                        .load(fileUri)
                        .into(getViewBinding().postImageView);
               // getViewBinding().linUploadImage.setVisibility(View.GONE);
                //getViewBinding().postImageView.setVisibility(View.VISIBLE);

                cardRecognizeInfo.firebaseVisionImageFromFile(selectedImageUri, CardRecognizeConstat.ELECTRCIAN_CARD_TYPE);
                //setOnItemCLickListener
                //firebaseVisionImageFromFile(selectedImageUri);
            } else if (requestCode == 156) {
                if (mFileTemp != null) {
                    Uri tempUri = Uri.fromFile(mFileTemp);
                    Glide.with(ImageToTexttFragment.this)
                            .load(tempUri)
                            .into(getViewBinding().postImageView);
                   // getViewBinding().linUploadImage.setVisibility(View.GONE);
                    //getViewBinding().postImageView.setVisibility(View.VISIBLE);
                    cardRecognizeInfo.firebaseVisionImageFromFile(tempUri,CardRecognizeConstat.ELECTRCIAN_CARD_TYPE);
                    //firebaseVisionImageFromFile(tempUri);
       /* File compressimagefile = null;
        try {
            compressimagefile = new Compressor(getApplication().getApplicationContext())
                    .setQuality(75)
                    .compressToFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
                    //  selectedFile = filename;
                    // getViewModel().setCaptureImage(mFileTemp);
                }

            } else if (requestCode == 157) {
                //getViewModel().setSelectedResumeFileUri(OtherInfoActivity.this, data);
            }
        }
    }


    private void firebaseVisionImageFromFile(Uri uri) {
        imagetextResult = "";
        getViewBinding().btnPost.setVisibility(View.GONE);
        //progressbar.setVisibility(View.VISIBLE);
        getViewModel().isLoading.set(true);
        FirebaseVisionImage image;
        try {
            image = FirebaseVisionImage.fromFilePath(ImageToTexttFragment.this, uri);
            recognizeText(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void recognizeText(FirebaseVisionImage image) {
        FirebaseVisionTextRecognizer detector = FirebaseVision.getInstance()
                .getOnDeviceTextRecognizer();
        detector.processImage(image)
                .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
                    @Override
                    public void onSuccess(FirebaseVisionText firebaseVisionText) {
                        processText(firebaseVisionText);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                        getViewBinding().btnPost.setVisibility(View.VISIBLE);
                        //  progressbar.setVisibility(View.GONE);
                        getViewModel().isLoading.set(false);
                        Toast.makeText(ImageToTexttFragment.this, "No text found", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void processText(FirebaseVisionText firebaseVisionText1) {
        if (firebaseVisionText1.getTextBlocks().isEmpty()) {
            Toast.makeText(ImageToTexttFragment.this, "No text found or Text may not be clear", Toast.LENGTH_LONG).show();
            getViewBinding().btnPost.setVisibility(View.VISIBLE);
            //progressbar.setVisibility(View.GONE);
            getViewModel().isLoading.set(false);
        } else {
            getViewBinding().btnPost.setVisibility(View.VISIBLE);
            //  progressbar.setVisibility(View.GONE);
            getViewModel().isLoading.set(false);
            // getViewBinding().tvDemoText.setText(firebaseVisionText.getText().toString());
            // String text = "";
            firebaseVisionText = firebaseVisionText1;
            /*for (FirebaseVisionText.TextBlock block : firebaseVisionText.getTextBlocks()) {
                imagetextResult = imagetextResult + block.getText() + " ";
                stringArray = Arrays.asList(block.getText().split("\n"));
                //Log.e
                setName(stringArray);
                setExpiryAndEffectiveDate(stringArray);
                setLicenceNumber(stringArray);
            }*/
        /*    for (int i=0;i<firebaseVisionText.getTextBlocks().size();i++) {
                imagetextResult = imagetextResult + firebaseVisionText.getTextBlocks().get(i).getText() + " ";
                if(i == firebaseVisionText.getTextBlocks().size()-1){
                    getViewBinding().tvDemoText.setText(imagetextResult.toString());
                }
            }*/


            // Log.e("textresult",text);

            //  String tag = ((MainActivity)ImageToTexttFragment.this).getTag_ResultLayout();
            // ResultLayout fragment = (ResultLayout)ImageToTexttFragment.this.getSupportFragmentManager()
            //      .findFragmentByTag(tag);
            //  fragment.setResult(text);
            //   ((MainActivity)ImageToTexttFragment.this).openResultLayout();
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        if (textToSpeech != null && textToSpeech.isSpeaking()) {
            textToSpeech.stop();
            ///textToSpeech =null;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragement_image_to_text;
    }

    @Override
    protected Toolbar getToolbar() {
        return null;
    }

    public Boolean isValidFormat1(String changeDate) {
        SimpleDateFormat inSDF = new SimpleDateFormat("yyyy/MM/dd");
       // SimpleDateFormat outSDF = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        // String outDate = "";
        if (changeDate != null) {
            try {
                Date date = inSDF.parse(changeDate);
                // outDate = outSDF.format(date);
            } catch (ParseException ex) {
                return false;
            }
        }
        return true;
    }

    public Boolean isValidFormat2(String changeDate) {
        SimpleDateFormat inSDF = new SimpleDateFormat("yyyy-MM-dd");
        // SimpleDateFormat outSDF = new SimpleDateFormat("yyyy/MM/dd",Locale.ENGLISH);

        // String outDate = "";
        if (changeDate != null) {
            try {
                Date date = inSDF.parse(changeDate);
                // outDate = outSDF.format(date);
            } catch (ParseException ex) {
                return false;
            }
        }
        return true;
    }
    public Boolean isValidBirthDateFormat1(String changeDate) {
        SimpleDateFormat inSDF = new SimpleDateFormat("dd MMM ");
        // SimpleDateFormat outSDF = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        // String outDate = "";
        if (changeDate != null) {
            try {
                Date date = inSDF.parse(changeDate);
                // outDate = outSDF.format(date);
            } catch (ParseException ex) {
                return false;
            }
        }
        return true;
    }
    public Boolean isValidExpiryAndBirthDateFormat1(String changeDate) {
        SimpleDateFormat inSDF = new SimpleDateFormat("dd MMM yy");
        // SimpleDateFormat outSDF = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        // String outDate = "";
        if (changeDate != null) {
            try {
                Date date = inSDF.parse(changeDate);
                // outDate = outSDF.format(date);
            } catch (ParseException ex) {
                return false;
            }
        }
        return true;
    }
    public void setExpiryAndEffectiveDate(List<String> firebaseVisionText) {
        for (int i = 0; i < firebaseVisionText.size(); i++) {
            String block = firebaseVisionText.get(i);
            if (isValidFormat1(block.toString())) {
                if (date1.length() > 0) {
                    date2 = block.toString();
                } else {
                    date1 = block.toString();
                }
                if (date1.length() > 0 && date2.length() > 0) {
                    Date date11 = DateUtils.getStringToDateFomrat1(date1);
                    Date date22 = DateUtils.getStringToDateFomrat1(date2);
                    if (date11.after(date22)) {
                        expiryDate = date1;
                        effectiveDate = date2;
                        // getViewBinding().tvDemoText.setText(getViewBinding().tvDemoText.getText().toString()+"\n Effective Date: "+ effectiveDate+"\n Expiry Date: "+ expiryDate);
                    }
                    if (date11.before(date22)) {
                        expiryDate = date2;
                        effectiveDate = date1;
                        //  getViewBinding().tvDemoText.setText(getViewBinding().tvDemoText.getText().toString()+"\n Effective Date: "+ effectiveDate+"\n Expiry Date: "+ expiryDate);

                    }
                }

            }
            if (isValidFormat2(block.toString())) {
                if (date1.length() > 0) {
                    date2 = block.toString();
                } else {
                    date1 = block.toString();
                }
                if (date1.length() > 0 && date2.length() > 0) {
                    Date date11 = DateUtils.getStringToDateFomrat2(date1);
                    Date date22 = DateUtils.getStringToDateFomrat2(date2);
                    if (date11.after(date22)) {
                        expiryDate = date1;
                        effectiveDate = date2;

                    }
                    if (date11.before(date22)) {
                        expiryDate = date2;
                        effectiveDate = date1;
                        //   getViewBinding().tvDemoText.setText(getViewBinding().tvDemoText.getText().toString()+"\n Effective Date: "+ effectiveDate+"\n Expiry Date: "+ expiryDate);

                    }
                }

            }
            //imagetextResult = imagetextResult + block.getText() + " ";
            if (i == firebaseVisionText.size() - 1) {
                getViewBinding().tvEffectiveDate.setText(effectiveDate);
                getViewBinding().tvExpiryDate.setText(expiryDate);
                cardHistoryModel.setEffectiveDate(effectiveDate);
                cardHistoryModel.setExpiryDate(expiryDate);

            }
        }
    }


    public void setLicenceNumber(List<String> firebaseVisionText) {
        for (int i = 0; i < firebaseVisionText.size(); i++) {
            String block = firebaseVisionText.get(i);
            if (block.length() == 7) {
                if (block.matches(".*[ABCDEFGH].*")) {
                    Log.e("containText", "Yes" + block.toString());
                    // System.out.println("yes");
                } else {
                    Log.e("containText", "No" + block.toString());
                    licenceNumber = block.toString();
                    getViewBinding().tvLicenseNumber.setText(licenceNumber);
                    cardHistoryModel.setLicenceNumber(licenceNumber);
                }
            }
        }
    }
    public void setName(List<String> firebaseVisionText) {
        for (int i = 0; i < firebaseVisionText.size(); i++) {
            String block = firebaseVisionText.get(i);
        /*    if(block.length()==7)
            {*/
            if (block.matches(".*\\d.*")) {
                Log.e("containDigit", "Yes" + block.toString());
                // System.out.println("yes");
            } else {
                Log.e("containDigit", "No" + block.toString());
                if (block.equals(block.toUpperCase())) {
                    if (block.startsWith("MASTER ELECTRICIAN")) {

                    } else if (block.startsWith("ONTARIO")) {

                    } else {
                        if (Name.length() == 0) {
                            Name = block.toString();
                            getViewBinding().tvName.setText(Name);
                            cardHistoryModel.setName(Name);
                        }
                    }
                }
            }
        }
    }
    public void setGender(List<String> firebaseVisionText) {
        for (int i = 0; i < firebaseVisionText.size(); i++) {
            String block = firebaseVisionText.get(i);
            if(block.length()==1)
            {
            if (block.matches(".*\\d.*")) {
                Log.e("containDigit", "Yes" + block.toString());
                // System.out.println("yes");
            } else {
                Log.e("containDigit", "No" + block.toString());
                if (block.equals("M") || block.equals("F")) {
                        if (gender.length() == 0) {
                            gender = block.toString();
                            getViewBinding().tvGender.setText(gender);
                            cardHistoryModel.setGender(gender);
                        }
                }
            }
            }
        }
    }
    public void setBirthAndExpiryDate(List<String> firebaseVisionText) {
        for (int i = 0; i < firebaseVisionText.size(); i++) {
            String block = firebaseVisionText.get(i);
            String[] separated = block.split("/");
            if(separated.length == 2) {
                String berthDate1 = separated[0];
                String berthDate2 = separated[1];
                if (isValidBirthDateFormat1(berthDate1.toString())) {
                    String validBirthDate = berthDate1 + berthDate2.substring(Math.max(berthDate2.length() - 2, 0));
                    Log.e("validBirthDate", validBirthDate);
                    if (isValidExpiryAndBirthDateFormat1(validBirthDate)) {
                        if (date1.length() > 0) {
                            date2 = validBirthDate;
                        } else {
                            date1 = validBirthDate;
                        }
                        if (date1.length() > 0 && date2.length() > 0) {
                            Date date11 = DateUtils.getStringToDateFomratPRCard(date1);
                            Date date22 = DateUtils.getStringToDateFomratPRCard(date2);
                            if (date11.after(date22)) {
                                expiryDate = date1;
                                effectiveDate = date2;
                                // getViewBinding().tvDemoText.setText(getViewBinding().tvDemoText.getText().toString()+"\n Effective Date: "+ effectiveDate+"\n Expiry Date: "+ expiryDate);
                            }
                            if (date11.before(date22)) {
                                expiryDate = date2;
                                effectiveDate = date1;
                                //  getViewBinding().tvDemoText.setText(getViewBinding().tvDemoText.getText().toString()+"\n Effective Date: "+ effectiveDate+"\n Expiry Date: "+ expiryDate);

                            }
                        }
                    }
                }
            }



            //imagetextResult = imagetextResult + block.getText() + " ";
            if (i == firebaseVisionText.size() - 1) {
                getViewBinding().tvBirthDate.setText(effectiveDate);
                getViewBinding().tvPrExpiryDate.setText(expiryDate);
                cardHistoryModel.setEffectiveDate(effectiveDate);
                cardHistoryModel.setExpiryDate(expiryDate);
            }
        }
    }
    public void setCanadaIdNumber(List<String> firebaseVisionText) {
        for (int i = 0; i < firebaseVisionText.size(); i++) {
            String block = firebaseVisionText.get(i);
            //if (block.length() == 7) {
            if (block.matches(".*[ABCDEFGH].*")) {
                Log.e("containText", "Yes" + block.toString());
                // System.out.println("yes");
            } else {
                if(validateCanadaPRid(block.toString())){
                    cardIdNumber = block.toString();
                    getViewBinding().tvCardPrIdNumber.setText(cardIdNumber);
                    cardHistoryModel.setCardIdNumber(cardIdNumber);
                }
            }
            //}

        }
    }
    public void setCanadaPRcardName(List<String> firebaseVisionText) {
        for (int i = 0; i < firebaseVisionText.size(); i++) {
            String block = firebaseVisionText.get(i);
        /*    if(block.length()==7)
            {*/
            if (block.matches(".*\\d.*")) {
                Log.e("containDigit", "Yes " + block.toString());
                // System.out.println("yes");
            } else {
                Log.e("containDigit", "No " + block.toString());
                if (validateUpperCase(block)) {
                    if (block.contains("PERMANENT")) {
                       // 18 MAY /MAI 87
                    } else if (block.contains("RESIDENT")) {

                    } else if (block.contains("ESIDENT")) {

                    }else if (block.contains("SAMPLE")) {

                    } else {
                        if (Name.length() == 0) {
                            Name = block.toString();
                            getViewBinding().tvCardName.setText(Name);
                            cardHistoryModel.setName(Name);
                        }
                    }
                }
            }

        }
    }
    public void setCountryNamePRcard(List<String> firebaseVisionText) {
        for (int i = 0; i < firebaseVisionText.size(); i++) {
            String block = firebaseVisionText.get(i);
            if (block.length() == 3) {
                if (isContainLetter(block)) {
                    if(isCountryCodes(block)){
                        countryNameCode = block.toString();
                        getViewBinding().tvNationality.setText(countryNameCode);
                        cardHistoryModel.setCountryNameCode(countryNameCode);
                    }
                    Log.e("isContainLetter", "Yes" + block.toString());
                    // System.out.println("yes");
                } else {
                   /* Log.e("containText", "No" + block.toString());
                    licenceNumber = block.toString();
                    getViewBinding().tvLicenseNumber.setText(licenceNumber);
                    cardHistoryModel.setLicenceNumber(licenceNumber);*/
                }
            }
        }
    }
    public boolean validateUpperCase(String name) {
        Pattern ps = Pattern.compile("([A-Z]*)");
        Matcher ms = ps.matcher(name);
        return ms.matches();
    }
    public boolean validateCanadaPRid(String name) {
        Pattern p = Pattern.compile("\\d{4}-\\d{4}");
        //str.matches("\\d{2}-\\d{2}")
        Matcher ms = p.matcher(name);
        return ms.matches();
    }
    public boolean validateStringIStartWithDate(String name) {
        Pattern p = Pattern.compile("\\[a-zA-Z]{1}\\d{4}-\\d{5}-\\d{5}");
        //str.matches("\\d{2}-\\d{2}")
        Matcher ms = p.matcher(name);
        return ms.matches();
    }
    public boolean isCountryCodes(String name) {
        String[] countryCodes = Locale.getISOCountries();
        for (String countryCode : countryCodes) {
            Locale locale = new Locale("", countryCode);
            String countryName = locale.getDisplayCountry();
            String alpha3Code = locale.getISO3Country();
            System.out.println("Country Name: " + countryName + ", Alpha-3 Code: " + alpha3Code);
            if(alpha3Code.equals(name)){
                return true;
            }

        }
        return false;
    }

    public boolean isContainLetter(String name) {
        return name.matches("[A-Z]+");
    }

    public void setOnDirLicenseDate(List<String> firebaseVisionText) {
        for (int i = 0; i < firebaseVisionText.size(); i++) {
            String block = firebaseVisionText.get(i);

            block = block.replace(" ", "");
            String validDate = findDateFromDriLicense(block.toString().trim());
            String separatedDate2="";
            if(validDate.contains(",")) {
                String[] separated = block.split(",");
                validDate = separated[0];
                 separatedDate2 = separated[1];
            }
            Log.e("DirLicenseDate", "Yes" + validDate.toString());
            if (isValidFormat1(validDate.toString())) {
                if (date1.length() == 0) {
                    date1 = validDate.toString();
                }else if (date2.length() == 0)  {
                    date2 = validDate.toString();
                }else if (date3.length() == 0)  {
                    date3 = validDate.toString();
                }else if (date4.length() == 0)  {
                    date4 = validDate.toString();
                }
                if(separatedDate2.length()>0){
                    if (date1.length() == 0) {
                        date1 = separatedDate2.toString();
                    }else if (date2.length() == 0)  {
                        date2 = separatedDate2.toString();
                    }else if (date3.length() == 0)  {
                        date3 = separatedDate2.toString();
                    }else if (date4.length() == 0)  {
                        date4 = separatedDate2.toString();
                    }
                }
                Log.e("DirLicenseAllDate", "date1 " + date1.toString()+" date2 " + date2.toString()+" date3 " + date3.toString()+" date4 " + date4.toString());
                if (date1.length() > 0 && date2.length() > 0 && date3.length() > 0 && date4.length() > 0) {
                   /* Date date11 = DateUtils.getStringToDateFomrat1(date1);
                    Date date22 = DateUtils.getStringToDateFomrat1(date2);
                    Date date33 = DateUtils.getStringToDateFomrat1(date3);
                    Date date44 = DateUtils.getStringToDateFomrat1(date4);*/
                   // date1 1996/02/07 date2 2015/02/02 date3 2020/02/01
                    ArrayList<String> dateList = new ArrayList<>();

                    // Adding data to the ArrayList
                    // using standard add() method
                    dateList.add(date1);
                    dateList.add(date2);
                    dateList.add(date3);
                   // if(date4.length()>0) {
                        dateList.add(date4);
                  //  }
                    HashSet<String> hashSet = new HashSet<String>();
                    hashSet.addAll(dateList);
                    dateList.clear();
                    dateList.addAll(hashSet);

                    // Sorting the ArrayList
                    // using Collections.sort() method
                    Collections.sort(dateList, new sortItems());
                    for (String d : dateList) {

                        Log.e("dateList",  d.toString());
                        if(dateList.indexOf(d) == 0){
                            birthDate = d;
                        }
                        if(dateList.indexOf(d) == 1){
                            effectiveDate = d;
                        }
                        if(dateList.indexOf(d) == 2){
                            expiryDate = d;
                        }

                    }
                    /*if (date11.after(date22) && date11.after(date33)) {
                        expiryDate = date1;
                        effectiveDate = date2;
                        birthDate = date3;
                    }
                    if (date22.after(date33) && date22.after(date11)) {
                        expiryDate = date1;
                        effectiveDate = date2;
                        birthDate = date3;
                    }
                    if (date11.after(date22) && date22.after(date33)) {
                        expiryDate = date1;
                        effectiveDate = date2;
                        birthDate = date3;
                    }
                    if (date22.after(date33) && date33.after(date11)) {
                        expiryDate = date2;
                        effectiveDate = date3;
                        birthDate = date1;

                    }*/
                }
            }
            if (i == firebaseVisionText.size() - 1) {
                getViewBinding().tvOnDriBirthDate.setText(birthDate);
                getViewBinding().tvOnDriExpiryDate.setText(expiryDate);
                getViewBinding().tvOnDriIssuDate.setText(effectiveDate);
               /* cardHistoryModel.setEffectiveDate(effectiveDate);
                cardHistoryModel.setExpiryDate(expiryDate);*/

            }
        }
    }

    public void setOnDirLicenseNumber(List<String> firebaseVisionText) {
        for (int i = 0; i < firebaseVisionText.size(); i++) {
            String block = firebaseVisionText.get(i);
           // String  input = EditTextinput.getText().toString();
            Log.e("DirLicenseblock", "Yes " + block.toString());
           /* block = block.replace(".", "");
            block = block.replace("/", "");*/
            block = block.replace(" ", "");
           // String bloack111="4dNUMBERLO668-47010-70296";
            block = block.replace("o", "0");

            block = block.replace("O", "0");
           /* if(block.startsWith("0"))
            {
                block =  block.replaceFirst("0", "O");
            }*/
            String validNumber = findNumberDriLicense(block.toString().trim());

            Log.e("DirLicenseNumber", "Yes " + validNumber.toString());
            if(validNumber.startsWith("0"))
            {
                validNumber=  validNumber.replaceFirst("0", "O");
            }
            if (validNumber.length()>0) {
                licenceNumber = validNumber.toString();
                if (licenceNumber.length() == 18) {
                    licenceNumber = licenceNumber.substring(0, licenceNumber.length() - 1);
                }
            }
            if (licenceNumber.length()>0) {
               // licenceNumber = block.toString();
                getViewBinding().tvOnDriIdNumber.setText(licenceNumber);
                cardHistoryModel.setLicenceNumber(licenceNumber);
            }
        }
    }
    public void setOnDriLicenseGender(List<String> firebaseVisionText) {
        for (int i = 0; i < firebaseVisionText.size(); i++) {
            String block = firebaseVisionText.get(i);
            block = block.replace(".", "");
            block = block.replace("/", "");
            block = block.replace("|", "");
            block = block.replace(" ", "");
            if(block.length()==1)
            {
                if (block.matches(".*\\d.*")) {
                    Log.e("LicenseGender", "Yes" + block.toString());
                    // System.out.println("yes");
                } else {
                    Log.e("LicenseGender", "No" + block.toString());
                    if (block.equals("M") || block.equals("F")) {
                        if (gender.length() == 0) {
                            gender = block.toString();
                            getViewBinding().tvOnDriGender.setText(gender);
                            cardHistoryModel.setGender(gender);
                        }
                    }
                }
            }else {
                Log.e("LicenseGender", "Yes" + block.toString());
                if(block.equals("6SEXSEXEM")){
                    if (gender.length() == 0) {
                        gender = block.substring(block.length() - 1);
                        getViewBinding().tvOnDriGender.setText(gender);
                        cardHistoryModel.setGender(gender);
                    }
                }
                if(block.equals("6SEX|SEXEM")){
                    if (gender.length() == 0) {
                        gender = block.substring(block.length() - 1);
                        getViewBinding().tvOnDriGender.setText(gender);
                        cardHistoryModel.setGender(gender);
                    }
                }
                if(block.equals("bSEXSEXEM")){
                    if (gender.length() == 0) {
                        gender = block.substring(block.length() - 1);
                        getViewBinding().tvOnDriGender.setText(gender);
                        cardHistoryModel.setGender(gender);
                    }
                }
            }
        }
    }
    public void setOnDriLicenseName(List<String> firebaseVisionText) {
       boolean isContainName= false;
       boolean isContainAddress= false;
       int line=2;
        for (int i = 0; i < firebaseVisionText.size(); i++) {
            String block = firebaseVisionText.get(i);

        /*    if(block.length()==7)
            {*/
            if (block.contains("NAME")) {
                Log.e("OnDriLicenseName", "Yes " + block.toString());
                Log.e("OnDriLicenseName", "Yes " + "Aadil");
                // System.out.println("yes");
                isContainName =true;
            } else {
                Log.e("OnDriLicenseName", "No " + block.toString());

            }
            if(isContainName){
                Log.e("OnDriLicenseName", "isContainName " + "true");
                if(Name.length() == 0) {
                      //  line = line + 1;
                    //licenseAddress = addressBlock;
                    Name = firebaseVisionText.get(i+1);
                    if(firebaseVisionText.get(i+2).matches(".*\\d.*")){
                        isContainName = false;
                        line =2;
                    }else {
                        Name = Name +" "+ firebaseVisionText.get(i+2);
                        line=3;
                        //licenseAddress = licenseAddress+" "+firebaseVisionText.get(i+4);
                    }

                        Log.e("OnDriLicenseName", "Yes " + Name.toString());
                        isContainName = false;
                        isContainAddress =true;
                }
                String addressBlock = firebaseVisionText.get(i+line);
                if (addressBlock.startsWith("8")) {
                    Log.e("LicenseAddress", "Yes " + block.toString());
                    Log.e("LicenseAddress", "Yes " + "Aadil address");
                    // System.out.println("yes");
                    addressBlock =  addressBlock.replaceFirst("8", "");
                }  else if (addressBlock.toUpperCase().startsWith("S")) {
                    Log.e("LicenseAddress", "Yes " + block.toString());
                    Log.e("LicenseAddress", "Yes " + "Aadil address");
                    // System.out.println("yes");
                    addressBlock =  addressBlock.replaceFirst("s", "");

                } else {
                    Log.e("LicenseAddress", "No " + block.toString());

                }
                if(isContainAddress){
                    Log.e("LicenseAddress", "isContainName " + "true");
                    if(licenseAddress.length() == 0) {
                        line = line + 1;
                        licenseAddress = addressBlock;
                        String trimaddressline1= firebaseVisionText.get(i+line).replace(" ", "");
                        if(trimaddressline1.startsWith("4dNUM")){
                            isContainAddress = false;
                        }else {
                            licenseAddress = licenseAddress+" "+firebaseVisionText.get(i+line);
                        }
                        line = line + 1;
                        String trimaddressline2= firebaseVisionText.get(i+line).replace(" ", "");
                        if(trimaddressline2.startsWith("4dNUM")){
                            isContainAddress = false;
                        }else {
                            licenseAddress = licenseAddress+" "+firebaseVisionText.get(i+line);
                        }
                        //licenseAddress = addressBlock +" "+ firebaseVisionText.get(i+4)+" "+ firebaseVisionText.get(i+5);
                        Log.e("LicenseAddress", "Yes " + licenseAddress.toString());
                        isContainAddress = false;
                    }
                }

            }


            if (i == firebaseVisionText.size() - 1) {
                if (Name.length() > 0) {
                    getViewBinding().tvOnDriName.setText(Name);
                    cardHistoryModel.setName(Name);
                }
                if (licenseAddress.length() > 0) {
                    getViewBinding().tvOnDriAddress.setText(licenseAddress);
                    cardHistoryModel.setName(licenseAddress);
                }
            }
          /*  if (validateUpperCase(block)) {
                if (block.contains("PERMANENT")) {
                    // 18 MAY /MAI 87
                } else if (block.contains("RESIDENT")) {

                } else if (block.contains("ESIDENT")) {

                }else if (block.contains("SAMPLE")) {

                } else {
                    if (Name.length() == 0) {
                        Name = block.toString();
                        getViewBinding().tvCardName.setText(Name);
                        cardHistoryModel.setName(Name);
                    }
                }
            }*/

        }
    }

    public void setOnDriLicenseAddress(List<String> firebaseVisionText) {
        boolean isContainName= false;
        int line=0;
        for (int i = 0; i < firebaseVisionText.size(); i++) {
            String block = firebaseVisionText.get(i);

        /*    if(block.length()==7)
            {*/
            if (block.startsWith("8")) {
                Log.e("LicenseAddress", "Yes " + block.toString());
                Log.e("LicenseAddress", "Yes " + "Aadil address");

                // System.out.println("yes");
                isContainName =true;
            } else {
                Log.e("LicenseAddress", "No " + block.toString());

            }
            if(isContainName){
                Log.e("LicenseAddress", "isContainName " + "true");
                if(licenseAddress.length() == 0) {
                    line = line + 1;
                    licenseAddress = firebaseVisionText.get(i+1) +" "+ firebaseVisionText.get(i+2);
                    Log.e("LicenseAddress", "Yes " + licenseAddress.toString());
                    isContainName = false;
                }
            }
            if (i == firebaseVisionText.size() - 1) {
                if (licenseAddress.length() > 0) {
                    getViewBinding().tvOnDriAddress.setText(licenseAddress);
                    cardHistoryModel.setName(licenseAddress);
                }
            }
          /*  if (validateUpperCase(block)) {
                if (block.contains("PERMANENT")) {
                    // 18 MAY /MAI 87
                } else if (block.contains("RESIDENT")) {

                } else if (block.contains("ESIDENT")) {

                }else if (block.contains("SAMPLE")) {

                } else {
                    if (Name.length() == 0) {
                        Name = block.toString();
                        getViewBinding().tvCardName.setText(Name);
                        cardHistoryModel.setName(Name);
                    }
                }
            }*/

        }
    }

    public String findDateFromDriLicense(String name) {
        Pattern p = Pattern.compile("\\d{4}/\\d{2}/\\d{2}");

        String firstdate="";
        String secondDate="";
        //str.matches("\\d{2}-\\d{2}")
        Matcher ms = p.matcher(name);
        if(ms.find()){
            firstdate = ms.group(0);
            if(ms.find()){
                secondDate =  ms.group(0);
            }
            if(secondDate.length()>0){
                return firstdate+","+secondDate;
            }
            return firstdate;
        }
        return "";
    }
    public String findNumberDriLicense(String name) {
        Log.e("findNumberDriLicense",name);
        //Pattern p = Pattern.compile("\\d{4}/\\d{2}/\\d{2}");
        Pattern p = Pattern.compile("\\w{1}\\d{4}-\\d{5}-\\d{5}");
       // Pattern p = Pattern.compile("\\d\\d\\d\\d\\-\\d\\d\\d\\d\\d\\-\\d\\d\\d\\d\\d");
        //str.matches("\\d{2}-\\d{2}")
        Matcher ms = p.matcher(name);
        if(ms.find()){
           return ms.group();
        }
        Pattern p1 = Pattern.compile("\\w{1}\\d{4}-\\d{5}-\\d{6}");
        // Pattern p = Pattern.compile("\\d\\d\\d\\d\\-\\d\\d\\d\\d\\d\\-\\d\\d\\d\\d\\d");
        //str.matches("\\d{2}-\\d{2}")
        Matcher ms1 = p1.matcher(name);
        if(ms1.find()){
            return ms1.group();
        }
        return "";
    }
    class sortItems implements Comparator<String> {

        // Method of this class
        // @Override
        public int compare(String a, String b)
        {

            // Returning the value after comparing the objects
            // this will sort the data in Ascending order
            return a.compareTo(b);
        }
    }
}
