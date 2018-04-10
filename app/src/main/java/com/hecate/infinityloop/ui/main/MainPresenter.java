package com.hecate.infinityloop.ui.main;


import android.support.annotation.Nullable;

import com.hecate.infinityloop.ui.base.BasePresenter;

/**
 * Created by Wiola on 08.04.2018.
 */

public class MainPresenter implements MainContract.Presenter {

    @Nullable
    private MainContract.View mView;

    @Override
    public void onSelectLevelClick() {
        mView.openSelectLevelActivity();
    }

}
