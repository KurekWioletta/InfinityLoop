package com.hecate.infinityloop.ui.levels;

import com.hecate.infinityloop.di.PerActivity;
import com.hecate.infinityloop.ui.base.MvpPresenter;
import com.hecate.infinityloop.ui.base.MvpView;

public class SelectLvlContract {

    interface View extends MvpView<SelectLvlContract.Presenter> {
    }

    @PerActivity
    interface Presenter<V extends View> extends MvpPresenter<V> {
    }

}
