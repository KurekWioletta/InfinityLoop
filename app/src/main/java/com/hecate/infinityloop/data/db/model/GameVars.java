package com.hecate.infinityloop.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "game_vars")
public class GameVars {

    @Property(nameInDb = "cur_difficulty_id")
    private long curDifficultyId;

    @Property(nameInDb = "next_level_id")
    private long nextLevelId;

    @Generated(hash = 2020376161)
    public GameVars(long curDifficultyId, long nextLevelId) {
        this.curDifficultyId = curDifficultyId;
        this.nextLevelId = nextLevelId;
    }

    @Generated(hash = 1887781731)
    public GameVars() {
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

}

