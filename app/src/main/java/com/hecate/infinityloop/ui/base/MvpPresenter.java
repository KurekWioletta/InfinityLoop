package com.hecate.infinityloop.ui.base;


public interface MvpPresenter<V> {

    void onAttach(V mvpView);

    void onDetach();

}