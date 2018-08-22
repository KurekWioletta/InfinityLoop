package com.hecate.infinityloop.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "game_vars")
public class GameVars {

    @Property(nameInDb = "cur_difficulty")
    private Difficulty curDifficulty;

    @Property(nameInDb = "next_level")
    private Level nextLevel;

    public Difficulty getCurDifficulty() {
        return curDifficulty;
    }

    public void setCurDifficulty(Difficulty curDifficulty) {
        this.curDifficulty = curDifficulty;
    }

    public Level getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(Level nextLevel) {
        this.nextLevel = nextLevel;
    }
}
