package com.ocrapp.data.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;

import com.ocrapp.data.Response;
import com.ocrapp.ui.main.model.AnswerAnalyst;
import com.ocrapp.ui.main.model.AnswerModel;
import com.ocrapp.ui.main.model.BodyTempChartDataModel;
import com.ocrapp.ui.main.model.FileUploadLIst;
import com.ocrapp.ui.main.model.FindJob;
import com.ocrapp.ui.main.model.GetUserAllDetails;
import com.ocrapp.ui.main.model.HomeGraphDataModel;
import com.ocrapp.ui.main.model.PackagePlanModel;
import com.ocrapp.ui.main.model.PurchaseHistoryModel;
import com.ocrapp.ui.main.model.QuestionModel;
import com.ocrapp.ui.main.model.SkillModel;
import com.ocrapp.ui.main.model.User;
import com.ocrapp.ui.main.model.UserOtherDetail;
import com.ocrapp.ui.main.model.WalletDetailsModel;
import com.ocrapp.ui.main.model.institutemodel.InstituteListModel;

import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.Call;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Part;

public interface ApiService {

    @GET("candidate.asmx/CandidatePurchaseHistory")
    Call<List<Response<List<PurchaseHistoryModel>>>> getPurchaseDetail(@QueryMap HashMap<String, String> map) ;

    @GET("candidate.asmx/CandidatePackages")
    Call<List<Response<List<PackagePlanModel>>>> getPackageList(@QueryMap HashMap<String, String> map) ;

    @GET("candidate.asmx/SelectWalletDetail")
    Call<List<WalletDetailsModel>> getWalletDetail(@QueryMap HashMap<String, String> map) ;

    @GET("Job.asmx/CandidateWiseJobList")
    Call<List<Response<List<FindJob>>>> getFindJobsList(@QueryMap HashMap<String, String> map) ;

    @FormUrlEncoded
    @POST("stripe.asmx/CreateEphemeralKeyforStripe")
    Call<ResponseBody> getEphemeralKey(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("stripe.asmx/CreateSecret")
    Call<JsonObject> callPayStripe(@FieldMap Map<String, String> apiVersionMap);

    @POST("Job.asmx/CandidateAppliedJob")
    @FormUrlEncoded
    Call<List<Response<List<FindJob>>>> getAppliedJobsList(@FieldMap HashMap<String, String> map) ;


    @POST("Job.asmx/InviteCandidateJob")
    @FormUrlEncoded
    Call<List<Response<List<FindJob>>>> getInvitationJobList(@FieldMap HashMap<String, String> map) ;

    @POST("Wallet.asmx/InserCreditWallet")
    @FormUrlEncoded
    Call<List<Response<JsonObject>>> insertWalletAmount(@FieldMap HashMap<String, String> map) ;

    @POST("Job.asmx/GetJobDetail")
    @FormUrlEncoded
    Call<List<Response<List<FindJob>>>> getJobDetail(@FieldMap HashMap<String, String> map) ;

    @POST("JobQuestions.asmx/CandidateJobQuestionsList")
    @FormUrlEncoded
    Call<List<Response<List<QuestionModel>>>> getQuestionList(@FieldMap HashMap<String, String> map) ;

    @GET("Job.asmx/CandidateFindJobList")
    Call<List<Response<List<FindJob>>>> getFindJobsSearchList(@QueryMap HashMap<String, String> map) ;

    @POST("JobQuestions.asmx/CandidateJobAnswerListV1")
    @FormUrlEncoded
    Call<List<Response<JsonElement>>> addQuestionAnswer(@FieldMap HashMap<String, String> map) ;

    @GET("JobQuestions.asmx/CandidateJobQuestionandAnswerList")
    Call<List<Response<List<AnswerModel>>>> getAnswerList(@QueryMap HashMap<String, String> map) ;

    @Multipart
    @POST("uploadvideo.asmx/uploadfile")
    Call<List<FileUploadLIst>> uploadProfileImage(@Part List<MultipartBody.Part>  parts);
    /*@POST("login.asmx/LogIn_Candidate")
        @FormUrlEncoded
        Call<Response<User>> loginApi(@FieldMap HashMap<String ,String> map) ;*/
    @GET("login.asmx/LogIn_Candidate")
    Call<List<Response<User>>> loginApi(@QueryMap HashMap<String ,String> map) ;


    @GET("Candidate.asmx/Candidate_SignUp")
    Call<List<Response<User>>> registerApi(@QueryMap HashMap<String ,String> map) ;


    @GET("Skills.asmx/GetSkillList")
    Call<List<Response<List<SkillModel>>>> getSkillList(@QueryMap HashMap<String ,String> map) ;


    @Multipart
    @POST("fileUpload.asmx/uploadfile")
    Call<List<FileUploadLIst>> uploadFile(@Part List<MultipartBody.Part>  parts);

    @Multipart
    @POST("fileUpload.asmx/uploadfile")
    Call<List<FileUploadLIst>> callUploadProfileImage(@Part List<MultipartBody.Part>  parts);

    @GET("Candidate.asmx/CandidateProfile")
    Call<List<Response<User>>> userOtherDetails(@QueryMap HashMap<String ,String> map) ;

    @GET("Candidate.asmx/ForgotPassword")
    Call<List<Response<JsonObject>>> generateForgotOtp(@QueryMap HashMap<String ,String> map);

    @GET("Candidate.asmx/CandidateDetailsIdWise")
    Call<List<Response<GetUserAllDetails>>> getUserDetails(@QueryMap HashMap<String ,String> map) ;

    @GET("Companies.asmx/GetCompaniesList")
    Call<List<InstituteListModel>> getInstituteList(@QueryMap HashMap<String ,String> map) ;


    @POST("Companies.asmx/GetCompaniesList")
    @FormUrlEncoded
    Call<List<UserOtherDetail>> getCompanyList(@FieldMap HashMap<String, String> map) ;


    @GET("BodyTemprature.asmx/SelectBodyTemperatureByCustomerIdwithfilter")
    Call<List<BodyTempChartDataModel>> getBodyTempDataWithFilter(@Query("nCustomerId") Integer customerID,
                                                                 @Query("dtFromDate") String dtFromDate,
                                                                 @Query("dtToDate") String dtToDate,
                                                                 @Query("cToken") String token,
                                                                 @Query("nUserId") Integer userId,
                                                                 @Query("nLanguageId") Integer languageID,
                                                                 @Query("cFilter") String cFilter);

    @GET("JobQuestions.asmx/AnswerTextAnalyst")
    Call<List<AnswerAnalyst>> getAnswerAnalyst(@QueryMap HashMap<String, String> map) ;

    @GET("StudentAnalytics.asmx/StudentExamAnalysis")
    Call<List<HomeGraphDataModel>> getHomeGraphDetail(@QueryMap HashMap<String, String> map) ;

    //feeds


}
