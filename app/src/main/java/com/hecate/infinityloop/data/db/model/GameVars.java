package com.hecate.infinityloop.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "game_vars")
public class GameVars {

    @Property(nameInDb = "cur_difficulty_id")
    private int curDifficultyId;

    @Property(nameInDb = "next_level_id")
    private int nextLevelId;

    @Generated(hash = 2105774496)
    public GameVars(int curDifficultyId, int nextLevelId) {
        this.curDifficultyId = curDifficultyId;
        this.nextLevelId = nextLevelId;
    }

    @Generated(hash = 1887781731)
    public GameVars() {
    }

    public int getCurDifficultyId() {
        return this.curDifficultyId;
    }

    public void setCurDifficultyId(int curDifficultyId) {
        this.curDifficultyId = curDifficultyId;
    }

    public int getNextLevelId() {
        return this.nextLevelId;
    }

    public void setNextLevelId(int nextLevelId) {
        this.nextLevelId = nextLevelId;
    }

}

