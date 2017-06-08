package io.innofang.quantify.model;

import java.util.List;

/**
 * Created by Inno Fang on 2017/6/8.
 */
public class Data {

    private List<Integer> beforeData;
    private List<Integer> afterData;
    private List<Integer> differeceData;
    private String description = "";

    public Data() {
        this(null, null);
    }

    public Data(List<Integer> beforeData, List<Integer> afterData) {
        this.beforeData = beforeData;
        this.afterData = afterData;
    }

    public List<Integer> getBeforeData() {
        return beforeData;
    }

    public void setBeforeData(List<Integer> beforeData) {
        this.beforeData = beforeData;
    }

    public List<Integer> getAfterData() {
        return afterData;
    }

    public void setAfterData(List<Integer> afterData) {
        this.afterData = afterData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getDiffereceData() {
        return differeceData;
    }

    public void setDiffereceData(List<Integer> differeceData) {
        this.differeceData = differeceData;
    }
}
