package com.hecate.infinityloop.ui.levels.level;

import com.hecate.infinityloop.ui.base.MvpPresenter;
import com.hecate.infinityloop.ui.base.MvpView;

public class LvlContract {
    interface View extends MvpView<Presenter> {
    }

    interface Presenter<V extends LvlContract.View> extends MvpPresenter<V> {
    }
}
