package com.hecate.infinityloop.ui.levels.level;

import com.hecate.infinityloop.ui.base.BasePresenter;

import javax.inject.Inject;

public class LvlPresenter<V extends LvlContract.View> extends BasePresenter<V> implements LvlContract.Presenter<V> {

    @Inject
    public LvlPresenter() {
    }

}
