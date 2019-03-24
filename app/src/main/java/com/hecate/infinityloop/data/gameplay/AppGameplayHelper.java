package com.hecate.infinityloop.data.gameplay;

import javax.inject.Inject;

public class AppGameplayHelper implements GameplayHelper{

    private int[] mRotationAnglesArray; // holds the angles that each element on a gameboard is rotated

    @Inject
    public AppGameplayHelper() {
    }

    public int[] getRotationAnglesArray() {
        return mRotationAnglesArray;
    }

    public void setRotationAnglesArray(int[] mRotationDegressArray) {
        mRotationAnglesArray = mRotationDegressArray;
    }
}
