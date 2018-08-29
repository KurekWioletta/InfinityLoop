package com.hecate.infinityloop.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(nameInDb = "level_state")
public class LevelState {

    @Property(nameInDb = "level_id")
    private Long levelId;

    @Property(nameInDb = "is_finished")
    private boolean isFinished;

    @Property(nameInDb = "score")
    private boolean score;

    @ToOne(joinProperty = "levelId")
    private Level level;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1887216132)
    private transient LevelStateDao myDao;

    @Generated(hash = 1348675457)
    public LevelState(Long levelId, boolean isFinished, boolean score) {
        this.levelId = levelId;
        this.isFinished = isFinished;
        this.score = score;
    }

    @Generated(hash = 653299111)
    public LevelState() {
    }

    public Long getLevelId() {
        return this.levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public boolean getScore() {
        return this.score;
    }

    public void setScore(boolean score) {
        this.score = score;
    }

    @Generated(hash = 959019489)
    private transient Long level__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1184076255)
    public Level getLevel() {
        Long __key = this.levelId;
        if (level__resolvedKey == null || !level__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LevelDao targetDao = daoSession.getLevelDao();
            Level levelNew = targetDao.load(__key);
            synchronized (this) {
                level = levelNew;
                level__resolvedKey = __key;
            }
        }
        return level;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1750736975)
    public void setLevel(Level level) {
        synchronized (this) {
            this.level = level;
            levelId = level == null ? null : level.getId();
            level__resolvedKey = levelId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1971619349)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLevelStateDao() : null;
    }

}
