package com.ocrapp.ui.main.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Section {

@SerializedName("nQuestionId")
@Expose
private Integer nQuestionId;
@SerializedName("cQuuestionTitle")
@Expose
private String cQuuestionTitle;
@SerializedName("cCorrectAnswer")
@Expose
private String cCorrectAnswer;
@SerializedName("cGivenAnswer")
@Expose
private String cGivenAnswer;
@SerializedName("IsAnswerCorrect")
@Expose
private Boolean isAnswerCorrect;

public Integer getnQuestionId() {
return nQuestionId;
}

public void setnQuestionId(Integer nQuestionId) {
this.nQuestionId = nQuestionId;
}

public String getcQuuestionTitle() {
return cQuuestionTitle;
}

public void setcQuuestionTitle(String cQuuestionTitle) {
this.cQuuestionTitle = cQuuestionTitle;
}

public String getcCorrectAnswer() {
return cCorrectAnswer;
}

public void setcCorrectAnswer(String cCorrectAnswer) {
this.cCorrectAnswer = cCorrectAnswer;
}

public String getcGivenAnswer() {
return cGivenAnswer;
}

public void setcGivenAnswer(String cGivenAnswer) {
this.cGivenAnswer = cGivenAnswer;
}

public Boolean getIsAnswerCorrect() {
return isAnswerCorrect;
}

public void setIsAnswerCorrect(Boolean isAnswerCorrect) {
this.isAnswerCorrect = isAnswerCorrect;
}

}