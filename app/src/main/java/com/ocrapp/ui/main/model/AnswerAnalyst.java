package com.ocrapp.ui.main.model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswerAnalyst {

@SerializedName("Success")
@Expose
private String success;
@SerializedName("cTextAnalyst")
@Expose
private JsonObject cTextAnalyst;
@SerializedName("cGrammarAnalyst")
@Expose
private JsonObject cGrammarAnalyst;

public String getSuccess() {
return success;
}

public void setSuccess(String success) {
this.success = success;
}

public JsonObject getCTextAnalyst() {
return cTextAnalyst;
}

public void setCTextAnalyst(JsonObject cTextAnalyst) {
this.cTextAnalyst = cTextAnalyst;
}

public JsonObject getCGrammarAnalyst() {
return cGrammarAnalyst;
}

public void setCGrammarAnalyst(JsonObject cGrammarAnalyst) {
this.cGrammarAnalyst = cGrammarAnalyst;
}

}