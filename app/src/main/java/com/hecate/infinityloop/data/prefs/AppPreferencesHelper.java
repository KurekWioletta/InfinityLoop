package com.hecate.infinityloop.data.prefs;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper {

    private long mCurrentDifficultyId;
    private long mCurrentLevelId;
    private List<String> mCurrentLevelElements; // holds elements that will be used in game
    private String mCurrentLevelDimensions;

    @Inject
    public AppPreferencesHelper() {
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
    public List<String> getCurrentLevelElements() {
        return mCurrentLevelElements;
    }

    @Override
    public String getCurrentLevelDimensions() {
        return mCurrentLevelDimensions;
    }

    @Override
    public void setCurrentLevelData(String elements, String dimensions) {
        mCurrentLevelElements = Arrays.asList(elements.split("\\s*,\\s*"));;
        mCurrentLevelDimensions = dimensions;
    }
}
