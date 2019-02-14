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

    @Property(nameInDb = "dimensions")
    private String dimensions;

    @Property(nameInDb = "elements")
    private String elements;

    @Generated(hash = 689231465)
    public Level(Long id, Long difficultyId, int number, String dimensions,
            String elements) {
        this.id = id;
        this.difficultyId = difficultyId;
        this.number = number;
        this.dimensions = dimensions;
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

    public String getDimensions() {
        return this.dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getElements() {
        return this.elements;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }

}
