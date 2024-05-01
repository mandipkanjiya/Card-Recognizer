package com.ocrapp.ui.main.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ListeningAnswerModel {

@SerializedName("cSectionName")
@Expose
private String cSectionName;
@SerializedName("Section")
@Expose
private List<Section> section = null;

public String getcSectionName() {
return cSectionName;
}

public void setcSectionName(String cSectionName) {
this.cSectionName = cSectionName;
}

public List<Section> getSection() {
return section;
}

public void setSection(List<Section> section) {
this.section = section;
}

}