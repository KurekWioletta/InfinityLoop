package com.hecate.infinityloop.data;

import android.content.Context;

import com.hecate.infinityloop.data.db.DbHelper;
import com.hecate.infinityloop.data.db.model.Difficulty;
import com.hecate.infinityloop.data.db.model.FinishedLevel;
import com.hecate.infinityloop.data.db.model.Level;
import com.hecate.infinityloop.data.state.StateHelper;
import com.hecate.infinityloop.di.ApplicationContext;
import com.hecate.infinityloop.di.DatabaseInfo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AppDataManager implements DataManager {

    private static String DB_NAME;

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final StateHelper mStateHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, DbHelper dbHelper, StateHelper stateHelper, @DatabaseInfo String dbName) {
        mContext = context;
        mDbHelper = dbHelper;
        mStateHelper = stateHelper;

        DB_NAME = dbName;
    }

    //DbHelper
    @Override
    public Observable<Boolean> createDatabase() {
        return mDbHelper.createDatabase();
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
    public List<FinishedLevel> getFinishedLevelList(Long difficultyId) {
        return mDbHelper.getFinishedLevelList(difficultyId);
    }

    @Override
    public Difficulty getNextToPlayDifficulty() {
        return mDbHelper.getNextToPlayDifficulty();
    }

    @Override
    public Difficulty getNextDifficulty(Long difficultyId) {
        return mDbHelper.getNextDifficulty(difficultyId);
    }

    @Override
    public Difficulty getPreviousDifficulty(Long difficultyId) {
        return mDbHelper.getPreviousDifficulty(difficultyId);
    }

    //StateHelper
    @Override
    public long getCurrentDifficultyId() {
        return mStateHelper.getCurrentDifficultyId();
    }

    @Override
    public void setCurrentDifficultyId(long difficultyId) {
        mStateHelper.setCurrentDifficultyId(difficultyId);
    }

    @Override
    public long getCurrentLevelId() {
        return mStateHelper.getCurrentLevelId();
    }

    @Override
    public void setCurrentLevelId(long levelId) {
        mStateHelper.setCurrentLevelId(levelId);
    }

    @Override
    public List<String> getCurrentLevelElementList() {
        return mStateHelper.getCurrentLevelElementList();
    }

    @Override
    public String getCurrentLevelDimensions() {
        return mStateHelper.getCurrentLevelDimensions();
    }

    @Override
    public void setCurrentLevelData(String elements, String dimensions) {
        mStateHelper.setCurrentLevelData(elements, dimensions);
    }
}
