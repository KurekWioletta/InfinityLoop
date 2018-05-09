package com.hecate.infinityloop.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "difficulty")
public class Difficulty {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "name")
    private Long name;

    @Property(nameInDb = "finished_levels")
    private int finishedLevels;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public int getFinishedLevels() {
        return finishedLevels;
    }

    public void setFinishedLevels(int finishedLevels) {
        this.finishedLevels = finishedLevels;
    }
}
