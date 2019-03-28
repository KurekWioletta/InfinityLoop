package com.hecate.infinityloop.data.state;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class AppStateHelper implements StateHelper {

    private long mCurrentDifficultyId;
    private long mCurrentLevelId;
    private String mCurrentLevelDimensions;

    // holds ids of elements in chosen level
    private List<String> mCurrentLevelElementList;

    @Inject
    public AppStateHelper() {
    }

    @Override
    public long getCurrentDifficultyId() {
        return mCurrentDifficultyId;
    }

    @Override
    public void setCurrentDifficultyId(long difficultyId) {
        mCurrentDifficultyId = difficultyId;
    }

    @Override
    public long getCurrentLevelId() {
        return mCurrentLevelId;
    }

    @Override
    public void setCurrentLevelId(long levelId) {
        mCurrentLevelId = levelId;
    }

    @Override
    public List<String> getCurrentLevelElementList() {
        return mCurrentLevelElementList;
    }

    @Override
    public String getCurrentLevelDimensions() {
        return mCurrentLevelDimensions;
    }

    @Override
    public void setCurrentLevelData(String elements, String dimensions) {
        mCurrentLevelElementList = Arrays.asList(elements.split("\\s*,\\s*"));;
        mCurrentLevelDimensions = dimensions;
    }
}
