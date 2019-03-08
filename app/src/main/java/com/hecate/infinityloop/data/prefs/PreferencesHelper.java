package com.hecate.infinityloop.data.prefs;

import java.util.List;

public interface PreferencesHelper {

    long getCurrentDifficultyId();

    void setCurrentDifficultyId(long difficultyId);

    long getCurrentLevelId();

    void setCurrentLevelId(long levelId);

    List<String> getCurrentLevelElements();

    String getCurrentLevelDimensions();

    void setCurrentLevelData(String elements, String dimensions);


}

