package com.ocrapp.ui.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserOtherDetail {

@SerializedName("Success")
@Expose
private String success;
@SerializedName("CompaniesList")
@Expose
private List<CompaniesList> companiesList = null;
@SerializedName("JobType")
@Expose
private List<JobType> jobType = null;

public String getSuccess() {
return success;
}

public void setSuccess(String success) {
this.success = success;
}

public List<CompaniesList> getCompaniesList() {
return companiesList;
}

public void setCompaniesList(List<CompaniesList> companiesList) {
this.companiesList = companiesList;
}

public List<JobType> getJobType() {
return jobType;
}

public void setJobType(List<JobType> jobType) {
this.jobType = jobType;
}
    public class JobType {

        @SerializedName("cJobType")
        @Expose
        private String cJobType;

        boolean isselected=false;

        public boolean isIsselected() {
            return isselected;
        }

        public void setIsselected(boolean isselected) {
            this.isselected = isselected;
        }



        public String getCJobType() {
            return cJobType;
        }

        public void setCJobType(String cJobType) {
            this.cJobType = cJobType;
        }

    }

    public class CompaniesList {

        @SerializedName("nUserId")
        @Expose
        private Integer nUserId;
        @SerializedName("cCompanyName")
        @Expose
        private String cCompanyName;
        @SerializedName("cCompanyLogo")
        @Expose
        private String cCompanyLogo;

        public Integer getNUserId() {
            return nUserId;
        }

        public void setNUserId(Integer nUserId) {
            this.nUserId = nUserId;
        }

        public String getCCompanyName() {
            return cCompanyName;
        }

        public void setCCompanyName(String cCompanyName) {
            this.cCompanyName = cCompanyName;
        }

        public String getCCompanyLogo() {
            return cCompanyLogo;
        }

        public void setCCompanyLogo(String cCompanyLogo) {
            this.cCompanyLogo = cCompanyLogo;
        }

    }
}