package com.hecate.infinityloop.data;

import android.content.Context;

import com.hecate.infinityloop.data.db.DbHelper;
import com.hecate.infinityloop.data.db.model.Difficulty;
import com.hecate.infinityloop.data.db.model.FinishedLevel;
import com.hecate.infinityloop.data.db.model.Level;
import com.hecate.infinityloop.data.game.GameStateHelper;
import com.hecate.infinityloop.data.prefs.PreferencesHelper;
import com.hecate.infinityloop.di.ApplicationContext;
import com.hecate.infinityloop.di.DatabaseInfo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AppDataManager implements DataManager {

    private static String DB_NAME;

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final GameStateHelper mGameStateHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, DbHelper dbHelper, PreferencesHelper preferencesHelper, GameStateHelper gameStateHelper, @DatabaseInfo String dbName) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mGameStateHelper = gameStateHelper;

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

    //PreferencesHelper
    @Override
    public long getCurrentDifficultyId() {
        return mPreferencesHelper.getCurrentDifficultyId();
    }

    @Override
    public void setCurrentDifficultyId(long difficultyId) {
        mPreferencesHelper.setCurrentDifficultyId(difficultyId);
    }

    @Override
    public long getCurrentLevelId() {
        return mPreferencesHelper.getCurrentLevelId();
    }

    @Override
    public void setCurrentLevelId(long levelId) {
        mPreferencesHelper.setCurrentLevelId(levelId);
    }

    @Override
    public List<String> getCurrentLevelElements() {
        return mPreferencesHelper.getCurrentLevelElements();
    }

    @Override
    public String getCurrentLevelDimensions() {
        return mPreferencesHelper.getCurrentLevelDimensions();
    }

    @Override
    public void setCurrentLevelData(String elements, String dimensions) {
        mPreferencesHelper.setCurrentLevelData(elements, dimensions);
    }

    //GameStateHelper
    @Override
    public int[] getRotationAnglesArray() {
        return mGameStateHelper.getRotationAnglesArray();
    }

    @Override
    public void setRotationAnglesArray(int[] mRotationDegreesArray) {
        mGameStateHelper.setRotationAnglesArray(mRotationDegreesArray);
    }
}
