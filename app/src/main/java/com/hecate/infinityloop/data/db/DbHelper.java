package com.hecate.infinityloop.data.db;

import com.hecate.infinityloop.data.db.model.Difficulty;
import com.hecate.infinityloop.data.db.model.Level;

import java.util.List;

public interface DbHelper {
    List<Difficulty>  getDifficulties();

    List<Level> getLevels(Long difficultyId);

    List<Level> getDoneLevels(Long difficultyId);

    Difficulty getCurrentDifficulty();

    Level getNextLevel();
}
