package com.hecate.infinityloop.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "game_vars")
public class GameVars {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "next_to_play_difficulty_id")
    private long nextToPlayDifficultyId; // holds id of difficulty that contains first unfinished level

    @Property(nameInDb = "next_to_play_level_id")
    private long nextToPlayLevelId; // holds id of level that should be played next (all level before this one are finished)

    @Property(nameInDb = "is_import_finished")
    private boolean isImportFinished;

    @Generated(hash = 470473197)
    public GameVars(Long id, long nextToPlayDifficultyId, long nextToPlayLevelId, boolean isImportFinished) {
        this.id = id;
        this.nextToPlayDifficultyId = nextToPlayDifficultyId;
        this.nextToPlayLevelId = nextToPlayLevelId;
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

    public long getNextToPlayDifficultyId() {
        return this.nextToPlayDifficultyId;
    }

    public void setNextToPlayDifficultyId(long nextToPlayDifficultyId) {
        this.nextToPlayDifficultyId = nextToPlayDifficultyId;
    }

    public long getNextToPlayLevelId() {
        return this.nextToPlayLevelId;
    }

    public void setNextToPlayLevelId(long nextToPlayLevelId) {
        this.nextToPlayLevelId = nextToPlayLevelId;
    }

    public boolean getIsImportFinished() {
        return this.isImportFinished;
    }

    public void setIsImportFinished(boolean isImportFinished) {
        this.isImportFinished = isImportFinished;
    }

}

