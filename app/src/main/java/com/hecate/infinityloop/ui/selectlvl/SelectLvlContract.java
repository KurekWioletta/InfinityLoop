package com.hecate.infinityloop.ui.selectlvl;

import com.hecate.infinityloop.data.db.model.Level;
import com.hecate.infinityloop.di.PerActivity;
import com.hecate.infinityloop.ui.base.MvpPresenter;
import com.hecate.infinityloop.ui.base.MvpView;

import java.util.List;

public class SelectLvlContract {

    interface View extends MvpView<SelectLvlContract.Presenter> {

        void refreshTextViewDifficulty(String difficulty);

        void refreshTextViewProgress(int doneLevels, int allLevels);

        void refreshViewPager(List<Level> levelList);
    }

    @PerActivity
    interface Presenter<V extends View> extends MvpPresenter<V> {

        void onViewInitialized();

        void onPreviousDifficultyClick();

        void onNextDifficultyClick();
    }

}
