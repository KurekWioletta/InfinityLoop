package com.hecate.infinityloop.ui.main;

import com.hecate.infinityloop.data.DataManager;
import com.hecate.infinityloop.ui.base.BasePresenter;

import javax.inject.Inject;

public class MainPresenter<V extends MainContract.View> extends BasePresenter<V> implements MainContract.Presenter<V> {

    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onSelectLevelClick() {
        getMvpView().openSelectLevelActivity();
    }

}
