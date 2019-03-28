package com.hecate.infinityloop.data.gameplay.model;

public class Element {

    // holds angle of rotated element
    private int mRotationAngle = 0;

    // hold side from which an element is connected to another
    private int mRight;
    private int mLeft;
    private int mTop;
    private int mBottom;

    public Element() {
    }

    public int getRotationAngle() {
        return mRotationAngle;
    }

    public void setRotationAngle(int rotation) {
        mRotationAngle += rotation;
        if (mRotationAngle == 360)
            mRotationAngle = 0;
    }

    public int getConnectionCounter() {
        return mTop + mRight + mBottom + mLeft;
    }

    public int getBottom() {
        return mBottom;
    }

    public void setBottom(int bottom) {
        mBottom =bottom;
    }

    public int getTop() {
        return mTop;
    }

    public void setTop(int top) {
        mTop = top;
    }

    public int getLeft() {
        return mLeft;
    }

    public void setLeft(int left) {
        mLeft = left;
    }

    public int getRight() {
        return mRight;
    }

    public void setRight(int right) {
        mRight = right;
    }
}
