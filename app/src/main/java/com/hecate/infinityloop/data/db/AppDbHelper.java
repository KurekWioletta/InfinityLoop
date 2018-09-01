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
    public List<Difficulty> getDifficulties() {
        return mDaoSession.getDifficultyDao().loadAll();
    }

    @Override
    public List<Level> getLevels(Long difficultyId) {
        return mDaoSession.getLevelDao()._queryDifficulty_Levels(difficultyId);
    }

    @Override
    public List<DoneLevel> getDoneLevels(Long difficultyId) {
        QueryBuilder<DoneLevel> qb = mDaoSession.getDoneLevelDao().queryBuilder();
        Join level = qb.join(DoneLevelDao.Properties.LevelId, Level.class);
        level.where(LevelDao.Properties.DifficultyId.eq(difficultyId));
        return qb.list();
    }

    @Override
    public Difficulty getCurrentDifficulty() {
        QueryBuilder<Difficulty> qb = mDaoSession.getDifficultyDao().queryBuilder();
        qb.where(DifficultyDao.Properties.Id.eq(
                mDaoSession.getGameVarsDao().loadByRowId(1).getCurDifficultyId()
        ));
        return qb.list().get(0);
    }

    @Override
    public Level getNextLevel() {
        QueryBuilder<Level> qb = mDaoSession.getLevelDao().queryBuilder();
        qb.where(LevelDao.Properties.Id.eq(
                mDaoSession.getGameVarsDao().loadByRowId(0).getNextLevelId()
        ));
        return qb.list().get(0);
    }

}
