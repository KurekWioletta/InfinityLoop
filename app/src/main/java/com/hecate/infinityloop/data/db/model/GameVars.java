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
    private long curDifficultyId;

    @Property(nameInDb = "next_level_id")
    private long nextLevelId;

    @Property(nameInDb = "is_import_finished")
    private boolean isImportFinished;

    @Generated(hash = 1525815661)
    public GameVars(Long id, long curDifficultyId, long nextLevelId,
            boolean isImportFinished) {
        this.id = id;
        this.curDifficultyId = curDifficultyId;
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

    public long getCurDifficultyId() {
        return this.curDifficultyId;
    }

    public void setCurDifficultyId(long curDifficultyId) {
        this.curDifficultyId = curDifficultyId;
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

