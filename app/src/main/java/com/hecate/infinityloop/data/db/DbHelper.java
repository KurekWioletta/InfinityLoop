package com.hecate.infinityloop.data.db;

import com.hecate.infinityloop.data.db.model.Difficulty;
import com.hecate.infinityloop.data.db.model.FinishedLevel;
import com.hecate.infinityloop.data.db.model.Level;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {

    Observable<Boolean> createDatabase();

    List<Difficulty> getDifficultyList();

    List<Level> getLevelList(Long difficultyId);

    List<FinishedLevel> getFinishedLevelList(Long difficultyId);

    Difficulty getNextToPlayDifficulty();

    Difficulty getNextDifficulty(Long difficultyId);

    Difficulty getPreviousDifficulty(Long difficultyId);

}
