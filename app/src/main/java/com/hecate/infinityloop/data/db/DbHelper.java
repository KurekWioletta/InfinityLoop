package com.hecate.infinityloop.data.db;

import com.hecate.infinityloop.data.db.model.Level;

import java.util.List;

public interface DbHelper {
    String getDifficulty(Long id);
    List<Level> getLevels(Long difficultyId);
    List<Level> getDoneLevels(Long difficultyId);
}
