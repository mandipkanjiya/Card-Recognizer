package com.ocrapp.data;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ViewVatorConstants {
    public static final String LIST_CARD_HISTORY = "list_card_history";
    public static final String BASE_URL_VEDIO_ANALYTICS = "https://ieltsanalyst.com/app/VideoAnalyticsApp.aspx" ;
    public static final String API_URL = "https://ieltsanalyst.com/app/WebServices/" ;
    public static final String GOOGLE_API_KEY = "AIzaSyBlHeKtWyocYD-ttv7aWXcf3GGVYR3kZos" ;
    public static final String PRF_FCM_MESSAGE_TOKEN = "fcm_token";
    public static final String API_Paymrnt_URL = "http://35.158.107.135/payment/" ;
    public static final String API_Paymrnt_URL1 = "http://35.158.107.135/payment/customer.php" ;
    public static final String API_Paymrnt_URL2 = "http://35.158.107.135/payment/pay.php" ;
    public static final String PAYMENT_STRIPE_PUBLISHABLE_KEY ="pk_test_nuUnRvWq5hGa1qm8QdaYh0kn00Lf9L6Nmt";
   // public static final String PAYMENT_STRIPE_PUBLISHABLE_KEY ="pk_test_51INaHQBU5uHFLiGCmr2eHizhuvM2R8SQFLaAwwSphREI5mkDimZQJXwcfEUYsYGNToVz4F0FESkM9DNoaacryfgT00cOsD6uCb";

    public static final String WRITING_TYPE = "Writing";
    public static final String SPEAKING_TYPE = "Speaking";
    public static final String READING_TYPE = "Reading";
    public static final String LISTENING_TYPE = "Listening";
    public static final String DEFAULT_USER_ID = "0";
    public static final String DEFAULT_NEW_USER_ID = "0";
    public static final String DEFAULT_TOKEN = "" ;
    public static String DEFAULT_LANGUAGE_ID = "1";
    public static final String DEVICE_TYPE = "0" ;
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public final static boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;

        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
    public final static boolean isValidMobile(String phone) {
        if(phone == null)
            return false;
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }
}
