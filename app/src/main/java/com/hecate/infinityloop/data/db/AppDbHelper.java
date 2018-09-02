package com.hecate.infinityloop.data.db;

import android.util.Log;

import com.hecate.infinityloop.data.db.model.DaoMaster;
import com.hecate.infinityloop.data.db.model.DaoSession;
import com.hecate.infinityloop.data.db.model.Difficulty;
import com.hecate.infinityloop.data.db.model.DifficultyDao;
import com.hecate.infinityloop.data.db.model.DoneLevel;
import com.hecate.infinityloop.data.db.model.DoneLevelDao;
import com.hecate.infinityloop.data.db.model.GameVarsDao;
import com.hecate.infinityloop.data.db.model.Level;
import com.hecate.infinityloop.data.db.model.LevelDao;

import org.greenrobot.greendao.query.Join;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDbHelper implements DbHelper{

    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        this.mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public List<Difficulty> getDifficultyList() {
        return mDaoSession.getDifficultyDao().loadAll();
    }

    @Override
    public List<Level> getLevelList(Long difficultyId) {
        return mDaoSession.getLevelDao()._queryDifficulty_LevelList(difficultyId);
    }

    @Override
    public List<DoneLevel> getDoneLevelList(Long difficultyId) {
        QueryBuilder<DoneLevel> qb = mDaoSession.getDoneLevelDao().queryBuilder();
        Join level = qb.join(DoneLevelDao.Properties.LevelId, Level.class);
        level.where(LevelDao.Properties.DifficultyId.eq(difficultyId));
        return qb.list();
    }

    @Override
    public Difficulty getCurrentDifficulty() {
        return  mDaoSession.getDifficultyDao().load(
                mDaoSession.getGameVarsDao().loadByRowId(1).getCurDifficultyId());
    }

    @Override
    public Difficulty getNextDifficulty(Long difficultyId) {
        if (mDaoSession.getDifficultyDao().load(difficultyId + 1) != null)
            return mDaoSession.getDifficultyDao().load(difficultyId + 1);

        return mDaoSession.getDifficultyDao().load((long) 1);
    }

    @Override
    public Difficulty getPreviousDifficulty(Long difficultyId) {
        if (mDaoSession.getDifficultyDao().load(difficultyId - 1) != null)
            return mDaoSession.getDifficultyDao().load(difficultyId - 1);

        return mDaoSession.getDifficultyDao().load(
                mDaoSession.getDifficultyDao().count());
    }

    @Override
    public Level getNextLevel() {
        return  mDaoSession.getLevelDao().load(
                mDaoSession.getGameVarsDao().loadByRowId(1).getNextLevelId());
    }

}
