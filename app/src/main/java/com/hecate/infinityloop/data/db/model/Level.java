package com.hecate.infinityloop.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(nameInDb = "level")
public class Level {

    @Id(autoincrement = true)
    private Long id;

    private Long difficultyId;

    @Property(nameInDb = "elements_ids")
    private String elementsIds;

    @Property(nameInDb = "is_finished")
    private boolean isFinished;

    @ToOne(joinProperty = "difficultyId")
    private Difficulty difficulty;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1312663686)
    private transient LevelDao myDao;

    @Generated(hash = 1973678447)
    public Level(Long id, Long difficultyId, String elementsIds,
            boolean isFinished) {
        this.id = id;
        this.difficultyId = difficultyId;
        this.elementsIds = elementsIds;
        this.isFinished = isFinished;
    }

    @Generated(hash = 723561372)
    public Level() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDifficultyId() {
        return this.difficultyId;
    }

    public void setDifficultyId(Long difficultyId) {
        this.difficultyId = difficultyId;
    }

    public String getElementsIds() {
        return this.elementsIds;
    }

    public void setElementsIds(String elementsIds) {
        this.elementsIds = elementsIds;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    @Generated(hash = 937767835)
    private transient Long difficulty__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 30641676)
    public Difficulty getDifficulty() {
        Long __key = this.difficultyId;
        if (difficulty__resolvedKey == null
                || !difficulty__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DifficultyDao targetDao = daoSession.getDifficultyDao();
            Difficulty difficultyNew = targetDao.load(__key);
            synchronized (this) {
                difficulty = difficultyNew;
                difficulty__resolvedKey = __key;
            }
        }
        return difficulty;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1603047116)
    public void setDifficulty(Difficulty difficulty) {
        synchronized (this) {
            this.difficulty = difficulty;
            difficultyId = difficulty == null ? null : difficulty.getId();
            difficulty__resolvedKey = difficultyId;
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
    @Generated(hash = 1363742062)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLevelDao() : null;
    }

}
