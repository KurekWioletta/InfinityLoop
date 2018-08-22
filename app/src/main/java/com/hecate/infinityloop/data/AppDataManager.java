package com.hecate.infinityloop.data;

import android.content.Context;

import com.hecate.infinityloop.data.db.DbHelper;
import com.hecate.infinityloop.data.db.model.Difficulty;
import com.hecate.infinityloop.data.db.model.Level;
import com.hecate.infinityloop.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;

public class AppDataManager implements DataManager {

    private final Context mContext;
    private final DbHelper mDbHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, DbHelper dbHelper) {
        mContext = context;
        mDbHelper = dbHelper;
    }

    @Override
    public List<Difficulty> getDifficulties() {
        return null;
    }

    @Override
    public List<Level> getLevels(Long difficultyId) {
        return mDbHelper.getLevels(difficultyId);
    }

    @Override
    public List<Level> getDoneLevels(Long difficultyId) {
        return mDbHelper.getDoneLevels(difficultyId);
    }

    @Override
    public Difficulty getCurrentDifficulty() {
        return mDbHelper.getCurrentDifficulty();
    }

    @Override
    public Level getNextLevel() {
        return mDbHelper.getNextLevel();
    }

}
