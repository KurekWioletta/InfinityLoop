package com.hecate.infinityloop.ui.game;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.data.DataManager;
import com.hecate.infinityloop.ui.base.BasePresenter;
import com.hecate.infinityloop.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class GamePresenter<V extends GameContract.View> extends BasePresenter<V> implements GameContract.Presenter<V>  {

    @Inject
    public GamePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {
        // initializing game
        int dimX = Integer.parseInt(getDataManager().getCurrentLevelDimensions().split("x", -1)[0]);
        int dimY = Integer.parseInt(getDataManager().getCurrentLevelDimensions().split("x", -1)[1]);

        generateGameMap(dimX, dimY);
        int[] elementsArray = generateElementsArray(dimX, dimY);

        getMvpView().setUpGameboard(dimX, dimY, elementsArray);
    }

    @Override
    public void onElementClick(int position) {
        getDataManager().getRotationAnglesArray()[position] += 90;
        getMvpView().rotateElement(position, getDataManager().getRotationAnglesArray()[position]);
    }

    private void generateGameMap(int dimX, int dimY) {
        int[][] gameStateArray = new int[dimX][dimY];
        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                //todo
            }
        }
        //getDataManager().setGameStateArray(gameStateArray);
    }

    private int[] generateElementsArray(int dimX, int dimY) {
        // creating array of elements on gameboard
        int[] gameElementsArray = new int[dimX * dimY];
        for (int i = 0; i < dimX * dimY; i++) {
            gameElementsArray[i] = R.drawable.ic_element_1;
        }

        // creating array of the angles that each element is rotated
        int[] rotationAnglesArray = new int[dimX * dimY];
        getDataManager().setRotationAnglesArray(rotationAnglesArray);

        return gameElementsArray;
    }
}

