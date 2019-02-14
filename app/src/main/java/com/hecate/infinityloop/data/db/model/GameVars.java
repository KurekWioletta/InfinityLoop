package com.hecate.infinityloop.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "game_vars")
public class GameVars {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "cur_difficulty_id")
    private long currentDifficultyId;

    @Property(nameInDb = "next_level_id")
    private long nextLevelId;

    @Property(nameInDb = "is_import_finished")
    private boolean isImportFinished;

    @Generated(hash = 187630310)
    public GameVars(Long id, long currentDifficultyId, long nextLevelId,
            boolean isImportFinished) {
        this.id = id;
        this.currentDifficultyId = currentDifficultyId;
        this.nextLevelId = nextLevelId;
        this.isImportFinished = isImportFinished;
    }

    @Generated(hash = 1887781731)
    public GameVars() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCurrentDifficultyId() {
        return this.currentDifficultyId;
    }

    public void setCurrentDifficultyId(long currentDifficultyId) {
        this.currentDifficultyId = currentDifficultyId;
    }

    public long getNextLevelId() {
        return this.nextLevelId;
    }

    public void setNextLevelId(long nextLevelId) {
        this.nextLevelId = nextLevelId;
    }

    public boolean getIsImportFinished() {
        return this.isImportFinished;
    }

    public void setIsImportFinished(boolean isImportFinished) {
        this.isImportFinished = isImportFinished;
    }

}

