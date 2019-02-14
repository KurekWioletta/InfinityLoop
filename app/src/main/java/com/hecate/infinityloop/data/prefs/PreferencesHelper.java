package com.hecate.infinityloop.data.prefs;

public interface PreferencesHelper {

    long getCurrentDifficultyId();

    void setCurrentDifficultyId(long difficultyId);

    long getCurrentLevelId();

    void setCurrentLevelId(long levelId);

    String getCurrentLevelElements();

    String getCurrentLevelDimensions();

    void setCurrentLevelData(String elements, String dimensions);

}

