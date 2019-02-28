package com.hecate.infinityloop.ui.game;

import com.hecate.infinityloop.di.PerActivity;
import com.hecate.infinityloop.ui.base.MvpPresenter;
import com.hecate.infinityloop.ui.base.MvpView;

public class GameContract{

    public interface View extends MvpView {
        void setUpGameboard(int dimX, int dimY, int[] elements);
    }

    @PerActivity
    public
    interface Presenter<V extends GameContract.View> extends MvpPresenter<V> {
        void onViewInitialized();
    }

}
