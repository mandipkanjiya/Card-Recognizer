package com.ocrapp.ui.main.model;

import org.json.JSONArray;

public class NounAndVerbModel {
    String grammerMessage;
    String grammerShortMessage;
    int grammerOffset;
    int grammerLength;
    JSONArray replacementJsonArray;

    public String getGrammerMessage() {
        return grammerMessage;
    }

    public void setGrammerMessage(String grammerMessage) {
        this.grammerMessage = grammerMessage;
    }

    public String getGrammerShortMessage() {
        return grammerShortMessage;
    }

    public void setGrammerShortMessage(String grammerShortMessage) {
        this.grammerShortMessage = grammerShortMessage;
    }

    public int getGrammerOffset() {
        return grammerOffset;
    }

    public void setGrammerOffset(int grammerOffset) {
        this.grammerOffset = grammerOffset;
    }

    public int getGrammerLength() {
        return grammerLength;
    }

    public void setGrammerLength(int grammerLength) {
        this.grammerLength = grammerLength;
    }

    public JSONArray getReplacementJsonArray() {
        return replacementJsonArray;
    }

    public void setReplacementJsonArray(JSONArray replacementJsonArray) {
        this.replacementJsonArray = replacementJsonArray;
    }
}
