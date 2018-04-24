package com.hecate.infinityloop.ui.base;


import javax.inject.Inject;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V>  {

    private V mMvpView;

    @Inject
    public BasePresenter() {}

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

}
