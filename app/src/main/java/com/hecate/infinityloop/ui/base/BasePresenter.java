package com.hecate.infinityloop.ui.base;

import com.hecate.infinityloop.data.DataManager;

import javax.inject.Inject;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private final DataManager mDataManager;

    private V mMvpView;

    @Inject
    public BasePresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

}
