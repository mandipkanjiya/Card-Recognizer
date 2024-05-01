package com.ocrapp.ui.main.model;

public class SummaryModelData {

    String analyticsName;
    int count;
    public SummaryModelData(String analyticsName, int count) {
        this.analyticsName = analyticsName;
        this.count = count;
    }

    public String getAnalyticsName() {
        return analyticsName;
    }

    public void setAnalyticsName(String analyticsName) {
        this.analyticsName = analyticsName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
