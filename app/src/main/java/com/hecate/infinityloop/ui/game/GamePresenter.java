package com.hecate.infinityloop.ui.game;

import com.hecate.infinityloop.data.DataManager;
import com.hecate.infinityloop.data.gameplay.Gameplay;
import com.hecate.infinityloop.data.gameplay.model.Element;
import com.hecate.infinityloop.ui.base.BasePresenter;
import com.hecate.infinityloop.utils.MathUtils;
import com.hecate.infinityloop.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class GamePresenter<V extends GameContract.View> extends BasePresenter<V> implements GameContract.Presenter<V> {

    @Inject
    Gameplay mGameplay;

    @Inject
    public GamePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {
        int dimX = Integer.parseInt(getDataManager().getCurrentLevelDimensions().split("x", -1)[0]);
        int dimY = Integer.parseInt(getDataManager().getCurrentLevelDimensions().split("x", -1)[1]);

        mGameplay.initializeElements(dimX, dimY);
        mGameplay.generateGameMap(dimX, dimY);
        mGameplay.adjustElements(dimX, dimY);
        mGameplay.rotateElements(dimX, dimY);

        getMvpView().setUpGameboard(dimX, mGameplay.getElements());
    }

    @Override
    public void onElementClick(int position) {
        mGameplay.getElement(position).rotate();
        getMvpView().rotateElement(position, mGameplay.getElement(position).getRotationAngle());
    }
}

