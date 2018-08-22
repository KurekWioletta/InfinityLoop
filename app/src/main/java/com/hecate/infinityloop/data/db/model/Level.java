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

    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "is_finished")
    private boolean isFinished;



    @Generated(hash = 882862952)
    public Level(Long id, Long difficultyId, String name, boolean isFinished) {
        this.id = id;
        this.difficultyId = difficultyId;
        this.name = name;
        this.isFinished = isFinished;
    }

    @Generated(hash = 723561372)
    public Level() {
    }


    
    public Long getDifficultyId() {
        return difficultyId;
    }

    public void setDifficultyId(Long difficultyId) {
        this.difficultyId = difficultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

}
