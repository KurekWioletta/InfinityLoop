package com.hecate.infinityloop.ui.game;

import com.hecate.infinityloop.di.PerActivity;
import com.hecate.infinityloop.ui.base.MvpPresenter;
import com.hecate.infinityloop.ui.base.MvpView;

public interface GameContract{

    interface View extends MvpView {
        void setUpGameboard(int dimX, int dimY, int[] elements);

        void rotateElement(int position, int angle);
    }

    @PerActivity
    interface Presenter<V extends GameContract.View> extends MvpPresenter<V> {
        void onViewInitialized();

        void onElementClick(int position);
    }

}
