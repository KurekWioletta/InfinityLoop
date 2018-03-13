package com.hecate.infinityloop.ui.menu;

import com.hecate.infinityloop.ui.base.BasePresenter;
import com.hecate.infinityloop.ui.base.BaseView;

/**
 * Created by Wiola on 12.03.2018.
 */

public interface MenuContract extends BaseView {

    interface View extends BaseView<Presenter> {
        void openMapActivity();
    }

    interface Presenter extends BasePresenter<View> {
        void onChooseMapClick();
    }

}
