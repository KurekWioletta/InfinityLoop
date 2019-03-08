package com.hecate.infinityloop.data.game;

import javax.inject.Inject;

public class AppGameStateHelper implements GameStateHelper{

    private int[] mRotationAnglesArray; // holds the angles that each element on a gameboard is rotated

    @Inject
    public AppGameStateHelper() {
    }

    public int[] getRotationAnglesArray() {
        return mRotationAnglesArray;
    }

    public void setRotationAnglesArray(int[] mRotationDegressArray) {
        this.mRotationAnglesArray = mRotationDegressArray;
    }
}
