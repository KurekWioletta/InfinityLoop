package com.hecate.infinityloop.data.db;

import com.hecate.infinityloop.data.db.model.DaoMaster;
import com.hecate.infinityloop.data.db.model.DaoSession;
import com.hecate.infinityloop.data.db.model.DifficultyDao;
import com.hecate.infinityloop.data.db.model.Level;
import com.hecate.infinityloop.data.db.model.LevelDao;

import org.greenrobot.greendao.query.QueryBuilder;

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
    public String getDifficulty(Long id) {
        return mDaoSession.getDifficultyDao().queryBuilder()
                .where(DifficultyDao.Properties.Id.eq(id)).list().get(0).getName();
    }

    @Override
    public List<Level> getLevels(Long difficultyId) {
        return mDaoSession.getLevelDao()._queryDifficulty_Levels(difficultyId);
    }

    @Override
    public List<Level> getDoneLevels(Long difficultyId) {
        QueryBuilder<Level> qb = mDaoSession.getLevelDao().queryBuilder();
        qb.and(LevelDao.Properties.IsFinished.eq(true), LevelDao.Properties.DifficultyId.eq(difficultyId));
        return qb.list();
    }
}
