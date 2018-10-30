package com.hecate.infinityloop.ui.game;

import android.util.Log;

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

    }

    @Override
    public void onGameboardTouch(int width, float screenWidth, float posX, int height, float screenHeight, float posY) {
        if (width > screenWidth) {
            if (posX > 0) {
                posX = 0;
            } else if (posX + width < screenWidth) {
                posX = screenWidth - width;
            }
            getMvpView().setGameboardPositionX(posX);
        }

        if (height > screenHeight) {
            if (posY > 0) {
                posY = 0;
            } else if (posY + height < screenHeight) {
                posY = screenHeight - height;
            }
            getMvpView().setGameboardPositionY(posY);
        }
    }
}
