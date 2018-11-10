package com.hecate.infinityloop.ui.game;

import android.content.Context;

import com.hecate.infinityloop.di.PerActivity;
import com.hecate.infinityloop.ui.base.MvpPresenter;
import com.hecate.infinityloop.ui.base.MvpView;

public class GameContract{

    interface View extends MvpView {
        String getIntentExtras();

        void setUpGameboard();

        void setGameboardPositionX(float posX);

        void setGameboardPositionY(float posY);
    }

    @PerActivity
    interface Presenter<V extends GameContract.View> extends MvpPresenter<V> {
        void onViewInitialized();

        void onGameboardTouch(int width, float screenWidth, float posX, int height, float screenHeight, float posY);
    }

}
