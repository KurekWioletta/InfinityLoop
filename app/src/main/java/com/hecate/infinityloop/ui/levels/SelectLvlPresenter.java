package com.hecate.infinityloop.ui.levels;

import android.util.Log;

import com.hecate.infinityloop.data.DataManager;
import com.hecate.infinityloop.data.db.model.Difficulty;
import com.hecate.infinityloop.ui.base.BasePresenter;

import javax.inject.Inject;

public class SelectLvlPresenter<V extends SelectLvlContract.View> extends BasePresenter<V> implements SelectLvlContract.Presenter<V> {

    @Inject
    public SelectLvlPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onViewInitialized() {
        Difficulty difficulty = getDataManager().getCurrentDifficulty();
        getDataManager().setChosenDifficulty(difficulty.getId());
        getDifficultyData(difficulty);
    }

    @Override
    public void onPreviousDifficultyClick() {
        //Difficulty difficulty = getDataManager().getNextLevel();
        Log.e("aaaa", "prv");
    }

    @Override
    public void onNextDifficultyClick() {
        Log.e("aaaa", "nxt");
    }

    private void getDifficultyData(Difficulty difficulty){
        getMvpView().refreshTextViewDifficulty(
                difficulty.getName()
        );

        getMvpView().refreshTextViewProgress(
                getDataManager().getDoneLevels(difficulty.getId()).size(),
                getDataManager().getLevels(difficulty.getId()).size()
        );

        getMvpView().refreshViewPager(
                getDataManager().getLevels(difficulty.getId())
        );
    }
}
