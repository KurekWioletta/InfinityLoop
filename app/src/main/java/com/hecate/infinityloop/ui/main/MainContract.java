package com.hecate.infinityloop.ui.main;

import com.hecate.infinityloop.ui.base.BasePresenter;
import com.hecate.infinityloop.ui.base.BaseView;

/**
 * Created by Wiola on 12.03.2018.
 */

public interface MainContract extends BaseView {

    interface View extends BaseView<Presenter> {
        void openMapActivity();
    }

    interface Presenter extends BasePresenter<View> {
        void onSelectLevelClick();
    }

}
