package com.hecate.infinityloop.ui.main;

import com.hecate.infinityloop.di.PerActivity;
import com.hecate.infinityloop.ui.base.MvpPresenter;
import com.hecate.infinityloop.ui.base.MvpView;

public interface MainContract{

    interface View extends MvpView {
        void openSelectLevelActivity();
    }

    @PerActivity
    interface Presenter<V extends View> extends MvpPresenter<V> {
        void onSelectLevelClick();
    }

}
