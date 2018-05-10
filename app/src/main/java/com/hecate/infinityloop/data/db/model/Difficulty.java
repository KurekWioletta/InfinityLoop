package com.hecate.infinityloop.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "difficulty")
public class Difficulty {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "name")
    private Long name;

    @Property(nameInDb = "finished_levels")
    private int finishedLevels;

    @Generated(hash = 111363046)
    public Difficulty(Long id, Long name, int finishedLevels) {
        this.id = id;
        this.name = name;
        this.finishedLevels = finishedLevels;
    }

    @Generated(hash = 1708722579)
    public Difficulty() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getName() {
        return this.name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public int getFinishedLevels() {
        return this.finishedLevels;
    }

    public void setFinishedLevels(int finishedLevels) {
        this.finishedLevels = finishedLevels;
    }
    
}
