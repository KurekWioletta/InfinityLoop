package com.hecate.infinityloop.data.state;

import java.util.List;

public interface StateHelper {

    long getCurrentDifficultyId();

    void setCurrentDifficultyId(long difficultyId);

    long getCurrentLevelId();

    void setCurrentLevelId(long levelId);

    List<String> getCurrentLevelElements();

    String getCurrentLevelDimensions();

    void setCurrentLevelData(String elements, String dimensions);

}

