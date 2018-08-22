package com.hecate.infinityloop.ui.levels;

import com.hecate.infinityloop.di.PerActivity;
import com.hecate.infinityloop.ui.base.MvpPresenter;
import com.hecate.infinityloop.ui.base.MvpView;

public class SelectLvlContract {

    interface View extends MvpView<SelectLvlContract.Presenter> {
        void refreshTextViewDifficulty(String difficulty);

        void refreshTextViewProgress(int allLevels, int doneLevels);

        void refreshViewPager(String difficulty);
    }

    @PerActivity
    interface Presenter<V extends View> extends MvpPresenter<V> {
        void onViewInitialized();
    }

}
