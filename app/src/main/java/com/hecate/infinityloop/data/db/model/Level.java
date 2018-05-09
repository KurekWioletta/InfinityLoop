package com.hecate.infinityloop.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDifficultyId() {
        return difficultyId;
    }

    public void setDifficultyId(Long difficultyId) {
        this.difficultyId = difficultyId;
    }

    public String getElementsIds() {
        return elementsIds;
    }

    public void setElementsIds(String elementsIds) {
        this.elementsIds = elementsIds;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
