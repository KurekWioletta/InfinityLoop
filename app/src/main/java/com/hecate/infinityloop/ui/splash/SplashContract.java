package com.hecate.infinityloop.ui.splash;

import com.hecate.infinityloop.di.PerActivity;
import com.hecate.infinityloop.ui.base.MvpPresenter;
import com.hecate.infinityloop.ui.base.MvpView;

public interface SplashContract {

    interface View extends MvpView {
        void openMainActivity();

        void showAppLoading();

        void hideAppLoading();
    }

    @PerActivity
    interface Presenter<V extends View> extends MvpPresenter<V> {
    }
}
