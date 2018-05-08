package com.hecate.infinityloop.ui.levels;

import com.hecate.infinityloop.ui.base.BasePresenter;

import javax.inject.Inject;

public class SelectLvlPresenter<V extends SelectLvlContract.View> extends BasePresenter<V> implements SelectLvlContract.Presenter<V> {

    @Inject
    public SelectLvlPresenter() {
        //super(dataManager, schedulerProvider, compositeDisposable);
    }
}
