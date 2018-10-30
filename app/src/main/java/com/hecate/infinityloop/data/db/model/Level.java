package com.hecate.infinityloop.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "level")
public class Level {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "difficulty_id")
    private Long difficultyId;

    @Property(nameInDb = "number")
    private int number;

    @Property(nameInDb = "dimension")
    private String dimension;

    @Property(nameInDb = "elements")
    private String elements;

    @Generated(hash = 1619521941)
    public Level(Long id, Long difficultyId, int number, String dimension,
            String elements) {
        this.id = id;
        this.difficultyId = difficultyId;
        this.number = number;
        this.dimension = dimension;
        this.elements = elements;
    }

    @Generated(hash = 723561372)
    public Level() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDifficultyId() {
        return this.difficultyId;
    }

    public void setDifficultyId(Long difficultyId) {
        this.difficultyId = difficultyId;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getElements() {
        return this.elements;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }

    public String getDimension() {
        return this.dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

}
