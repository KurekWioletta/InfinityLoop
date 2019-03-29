package com.hecate.infinityloop.ui.game;

import com.hecate.infinityloop.data.gameplay.model.Element;
import com.hecate.infinityloop.di.PerActivity;
import com.hecate.infinityloop.ui.base.MvpPresenter;
import com.hecate.infinityloop.ui.base.MvpView;

import java.util.List;

public interface GameContract{

    interface View extends MvpView {
        void setUpGameboard(int dimX, List<Element> elementList);

        void rotateElement(int position, int angle);
    }

    @PerActivity
    interface Presenter<V extends GameContract.View> extends MvpPresenter<V> {
        void onViewInitialized();

        void onElementClick(int position);
    }

}
