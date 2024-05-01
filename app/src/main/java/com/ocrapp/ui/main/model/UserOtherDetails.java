package com.ocrapp.ui.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserOtherDetails {

@SerializedName("nCandidateId")
@Expose
private Integer nCandidateId;
@SerializedName("cCandidateImage")
@Expose
private String cCandidateImage;
@SerializedName("cCandidateResume")
@Expose
private Object cCandidateResume;
@SerializedName("Skill")
@Expose
private List<Skill> skill = null;

public Integer getNCandidateId() {
return nCandidateId;
}

public void setNCandidateId(Integer nCandidateId) {
this.nCandidateId = nCandidateId;
}

public String getCCandidateImage() {
return cCandidateImage;
}

public void setCCandidateImage(String cCandidateImage) {
this.cCandidateImage = cCandidateImage;
}

public Object getCCandidateResume() {
return cCandidateResume;
}

public void setCCandidateResume(Object cCandidateResume) {
this.cCandidateResume = cCandidateResume;
}

public List<Skill> getSkill() {
return skill;
}

public void setSkill(List<Skill> skill) {
this.skill = skill;
}
    public class Skill {

        @SerializedName("nSkillId")
        @Expose
        private Integer nSkillId;
        @SerializedName("cSkillName")
        @Expose
        private String cSkillName;
        @SerializedName("IsActive")
        @Expose
        private Boolean isActive;

        public Integer getNSkillId() {
            return nSkillId;
        }

        public void setNSkillId(Integer nSkillId) {
            this.nSkillId = nSkillId;
        }

        public String getCSkillName() {
            return cSkillName;
        }

        public void setCSkillName(String cSkillName) {
            this.cSkillName = cSkillName;
        }

        public Boolean getIsActive() {
            return isActive;
        }

        public void setIsActive(Boolean isActive) {
            this.isActive = isActive;
        }

    }
}