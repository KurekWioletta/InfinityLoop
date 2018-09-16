package com.hecate.infinityloop.ui.base;

import android.support.annotation.StringRes;

public interface MvpView<T> {

    void onError(@StringRes int resId);

    void showMessage(@StringRes int resId);

}