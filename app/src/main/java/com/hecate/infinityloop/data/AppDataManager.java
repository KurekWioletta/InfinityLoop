package com.hecate.infinityloop.data;

import android.content.Context;

import com.hecate.infinityloop.data.db.DbHelper;
import com.hecate.infinityloop.data.db.model.Difficulty;
import com.hecate.infinityloop.data.db.model.DoneLevel;
import com.hecate.infinityloop.data.db.model.Level;
import com.hecate.infinityloop.data.status.StatusHelper;
import com.hecate.infinityloop.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;

public class AppDataManager implements DataManager {

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final StatusHelper mStatusHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, DbHelper dbHelper, StatusHelper statusHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mStatusHelper = statusHelper;
    }

    @Override
    public List<Difficulty> getDifficultyList() {
        return null;
    }

    @Override
    public List<Level> getLevelList(Long difficultyId) {
        return mDbHelper.getLevelList(difficultyId);
    }

    @Override
    public List<DoneLevel> getDoneLevelList(Long difficultyId) {
        return mDbHelper.getDoneLevelList(difficultyId);
    }

    @Override
    public Difficulty getCurrentDifficulty() {
        return mDbHelper.getCurrentDifficulty();
    }

    @Override
    public Difficulty getNextDifficulty(Long difficultyId) {
        return mDbHelper.getNextDifficulty(difficultyId);
    }

    @Override
    public Difficulty getPreviousDifficulty(Long difficultyId) {
        return mDbHelper.getPreviousDifficulty(difficultyId);
    }

    @Override
    public Level getNextLevel() {
        return mDbHelper.getNextLevel();
    }

    @Override
    public long getChosenDifficulty() {
        return mStatusHelper.getChosenDifficulty();
    }

    @Override
    public void setChosenDifficulty(long difficultyId) {
        mStatusHelper.setChosenDifficulty(difficultyId);
    }

}
