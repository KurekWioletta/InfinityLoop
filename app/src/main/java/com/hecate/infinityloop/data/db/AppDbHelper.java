package com.hecate.infinityloop.data.db;

import com.hecate.infinityloop.data.db.model.DaoMaster;
import com.hecate.infinityloop.data.db.model.DaoSession;
import com.hecate.infinityloop.data.db.model.Difficulty;
import com.hecate.infinityloop.data.db.model.FinishedLevel;
import com.hecate.infinityloop.data.db.model.FinishedLevelDao;
import com.hecate.infinityloop.data.db.model.Level;
import com.hecate.infinityloop.data.db.model.LevelDao;

import org.greenrobot.greendao.query.Join;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDbHelper implements DbHelper{

    private DaoSession mDaoSession;
    private DbOpenHelper mDbOpenHelper;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        this.mDbOpenHelper = dbOpenHelper;
    }

    //create db and import data
    @Override
    public Observable<Boolean> createDatabase() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession = new DaoMaster(mDbOpenHelper.getWritableDb()).newSession();
                return true;
            }
        });
    }

    //database queries ----> todo: make methods asynchronous like createDatabase()
    @Override
    public List<Difficulty> getDifficultyList() {
        return mDaoSession.getDifficultyDao().loadAll();
    }

    @Override
    public List<Level> getLevelList(Long difficultyId) {
        return mDaoSession.getLevelDao()._queryDifficulty_LevelList(difficultyId);
    }

    @Override
    public List<FinishedLevel> getFinishedLevelList(Long difficultyId) {
        QueryBuilder<FinishedLevel> qb = mDaoSession.getFinishedLevelDao().queryBuilder();
        Join level = qb.join(FinishedLevelDao.Properties.LevelId, Level.class);
        level.where(LevelDao.Properties.DifficultyId.eq(difficultyId));
        return qb.list();
    }

    @Override
    public Difficulty getNextToPlayDifficulty() {
        return  mDaoSession.getDifficultyDao().load(
                mDaoSession.getGameVarsDao().loadByRowId(1).getNextToPlayDifficultyId());
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

}
