package com.app.cardocrlibrary;

import static com.app.cardocrlibrary.UtilityClass.getStringToDateFomrat1;
import static com.app.cardocrlibrary.UtilityClass.getStringToDateFomrat2;
import static com.app.cardocrlibrary.UtilityClass.isValidFormat1;
import static com.app.cardocrlibrary.UtilityClass.isValidFormat2;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.app.cardocrlibrary.model.CardHistoryModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CardRecognizeInfo {

    String Name = "";
    String date1 = "";
    String date2 = "";
    String expiryDate = "";
    String effectiveDate = "";
    String licenceNumber = "";

    private static CardRecognizeInfo utils;
    private static Context context;
    OnCardOcrListener onCardOcrListener;
   public static CardHistoryModel cardHistoryModel;

    public static CardRecognizeInfo getInstance(Context context1) {
        if (utils == null)
            utils = new CardRecognizeInfo();
        context = context1;
        cardHistoryModel = new CardHistoryModel();
        return utils;
    }
    public void firebaseVisionImageFromFile(Uri uri,String cardType) {
        FirebaseVisionImage image;
        try {
            image = FirebaseVisionImage.fromFilePath(context, uri);
            recognizeText(image,cardType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void recognizeText(FirebaseVisionImage image,String cardType) {
        FirebaseVisionTextRecognizer detector = FirebaseVision.getInstance()
                .getOnDeviceTextRecognizer();
        detector.processImage(image)
                .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
                    @Override
                    public void onSuccess(FirebaseVisionText firebaseVisionText) {
                        processText(firebaseVisionText,cardType);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                    //    getViewBinding().btnPost.setVisibility(View.VISIBLE);
                        //  progressbar.setVisibility(View.GONE);
                    //    getViewModel().isLoading.set(false);
                        Toast.makeText(context, "No text found", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void processText(FirebaseVisionText firebaseVisionText1,String cardType) {
        if (firebaseVisionText1.getTextBlocks().isEmpty()) {
            onCardOcrListener.onFailed("No text found or Text may not be clear");
          //  Toast.makeText(context, "No text found or Text may not be clear", Toast.LENGTH_LONG).show();
        } else {
            List<String> stringArray = new ArrayList<String>();
            for (FirebaseVisionText.TextBlock block : firebaseVisionText1.getTextBlocks()) {
                stringArray = Arrays.asList(firebaseVisionText1.getText().split("\n"));
            }
            //onCardOcrListener.onSuccess(firebaseVisionText1);
            if(cardType.equalsIgnoreCase(CardRecognizeConstat.ELECTRCIAN_CARD_TYPE)) {
                setName(stringArray);



               // cardHistoryList.add(cardHistoryModel);
            }
            if(cardType.equalsIgnoreCase(CardRecognizeConstat.CANADA_PR_CARD_TYPE)) {

            }
            if(cardType.equalsIgnoreCase(CardRecognizeConstat.ONTARIO_DRIVING_LICENCE_TYPE)) {

            }

        }
    }
    public interface OnCardOcrListener {
        void onSuccess(FirebaseVisionText string);
        void onFailed(String string);
    }
    public void setOnCardOcrListener(OnCardOcrListener onCardOcrListener) {
        this.onCardOcrListener = onCardOcrListener;
    }

    public void setName(List<String> firebaseVisionText) {
        for (int i = 0; i < firebaseVisionText.size(); i++) {
            String block = firebaseVisionText.get(i);
        /*    if(block.length()==7)
            {*/
            if (block.matches(".*\\d.*"))
            {
                Log.e("containDigit", "Yes" + block.toString());
                // System.out.println("yes");
            }
            else
            {
                Log.e("containDigit", "No" + block.toString());
                if (block.equals(block.toUpperCase())) {
                    if (block.startsWith("MASTER ELECTRICIAN")) {

                    } else if (block.startsWith("ONTARIO")) {

                    } else {
                        if (Name.length() == 0) {
                            Name = block.toString();
                          //  getViewBinding().tvName.setText(Name);
                            cardHistoryModel.setName(Name);
                        }
                    }
                }
            }
            if (i == firebaseVisionText.size() - 1) {
                setExpiryAndEffectiveDate(firebaseVisionText);
            }
        }
    }
    public void setExpiryAndEffectiveDate(List<String> firebaseVisionText) {
        date1="";
        date2="";
        expiryDate="";
        effectiveDate="";
        for (int i = 0; i < firebaseVisionText.size(); i++) {
            String block = firebaseVisionText.get(i);
            if (isValidFormat1(block.toString())) {
                if (date1.length() > 0) {
                    date2 = block.toString();
                } else {
                    date1 = block.toString();
                }
                if (date1.length() > 0 && date2.length() > 0) {
                    Date date11 = getStringToDateFomrat1(date1);
                    Date date22 = getStringToDateFomrat1(date2);
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
                    Date date11 = getStringToDateFomrat2(date1);
                    Date date22 = getStringToDateFomrat2(date2);
                    if (date11.after(date22)) {
                        expiryDate = date1;
                        effectiveDate = date2;
                    }
                    if (date11.before(date22)) {
                        expiryDate = date2;
                        effectiveDate = date1;
                    }
                }

            }
            //imagetextResult = imagetextResult + block.getText() + " ";
            if (i == firebaseVisionText.size() - 1) {
                cardHistoryModel.setEffectiveDate(effectiveDate);
                cardHistoryModel.setExpiryDate(expiryDate);
                setLicenceNumber(firebaseVisionText);
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
                   // getViewBinding().tvLicenseNumber.setText(licenceNumber);
                    cardHistoryModel.setLicenceNumber(licenceNumber);
                }
            }
        }
    }
}
