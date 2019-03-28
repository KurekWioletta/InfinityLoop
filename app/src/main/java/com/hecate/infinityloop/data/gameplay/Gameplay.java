package com.hecate.infinityloop.data.gameplay;

import com.hecate.infinityloop.data.gameplay.model.Element;
import com.hecate.infinityloop.utils.MathUtils;

import static java.lang.Math.abs;

public class Gameplay{

    private int mDimY;
    private Element[][] mElements;
    private int[] mElementTypes;
    private int[] mRotationAngles;

    public Gameplay() {
    }

    public void initializeElements(int x, int y) {
        mDimY = y;
        mElements = new Element[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                mElements[i][j] = new Element();
            }
        }
    }

    public Element getElement(int position) {
        int x = position/mDimY;
        int y = position%mDimY;
        return mElements[x][y];
    }

    public int[] getElementTypes() {
        return mElementTypes;
    }

    public int[] getRotationAngles() {
        return mRotationAngles;
    }

    /**
     * Randomly assigns possible connections to all elements on gameboard.
     * For example, when two elements are connected by a horizontal line,
     * element[0][0].getRight() equals 1 and element[0][1].getLeft() equals 1.
     *
     * todo: optionally generate connections of available types.
     */
    public void generateGameMap(int dimX, int dimY) {
        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                if (i == dimX - 1) mElements[i][j].setBottom(0);
                else mElements[i][j].setBottom(MathUtils.getRandomNumberInRange(0, 1));

                if (j == dimX - 1) mElements[i][j].setRight(0);
                else mElements[i][j].setRight(MathUtils.getRandomNumberInRange(0, 1));

                if (i == 0) mElements[i][j].setTop(0);
                else mElements[i][j].setTop(mElements[i - 1][j].getBottom());

                if (j == 0) mElements[i][j].setLeft(0);
                else mElements[i][j].setLeft(mElements[i][j - 1].getRight());
            }
        }
    }

    /**
     * Matches line types and rotation angles to elements based on number and type of connections.
     */
    public void adjustElements(int dimX, int dimY) {
        mElementTypes = new int[dimX * dimY];
        mRotationAngles = new int[dimX * dimY];

        int position = 0;

        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                int connectionCounter = mElements[i][j].getConnectionCounter();
                mElementTypes[position] = connectionCounter;

                switch (connectionCounter) {
                    case 1:
                        adjustUnevenElementRotation(mElements[i][j], 1);
                        break;
                    case 2:
                        int elementType = abs(mElements[i][j].getTop() - mElements[i][j].getBottom());
                        adjustEvenElementRotation(mElements[i][j], elementType);
                        mElementTypes[position] = 20 + elementType;
                        break;
                    case 3:
                        adjustUnevenElementRotation(mElements[i][j], 0);
                        break;
                }
                mRotationAngles[position++] = mElements[i][j].getRotationAngle();
            }
        }
    }

    /**
     * @param determinant (1) rotation is based on the side with connection (1 connection)
     *                    (0) rotation is based on the side without connection (3 connections)
     */
    private void adjustUnevenElementRotation(Element element, int determinant) {
        if (element.getRight() == determinant)
            element.setRotationAngle(90);
        else if (element.getBottom() == determinant)
            element.setRotationAngle(180);
        else if (element.getLeft() == determinant)
            element.setRotationAngle(270);
    }

    /**
     * @param lineType (1) curved line
     *                 (0) straight line
     */
    private void adjustEvenElementRotation(Element element, int lineType) {
        if (lineType == 0 && element.getTop() == 1)
            element.setRotationAngle(90);
        else {
            if (element.getBottom() == 1 && element.getLeft() == 1)
                element.setRotationAngle(90);
            else if (element.getLeft() == 1 && element.getTop() == 1)
                element.setRotationAngle(180);
            else if (element.getTop() == 1 && element.getRight() == 1)
                element.setRotationAngle(270);
        }
    }
}
