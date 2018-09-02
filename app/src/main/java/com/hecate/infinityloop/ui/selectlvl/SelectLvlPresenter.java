package com.hecate.infinityloop.ui.selectlvl;

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
        Difficulty difficulty = getDataManager().getPreviousDifficulty(
                getDataManager().getChosenDifficulty());

        getDataManager().setChosenDifficulty(difficulty.getId());
        getDifficultyData(difficulty);
    }

    @Override
    public void onNextDifficultyClick() {
        Difficulty difficulty = getDataManager().getNextDifficulty(
                getDataManager().getChosenDifficulty());

        getDataManager().setChosenDifficulty(difficulty.getId());
        getDifficultyData(difficulty);
    }

    private void getDifficultyData(Difficulty difficulty){
        getMvpView().refreshTextViewDifficulty(
                difficulty.getName());

        getMvpView().refreshTextViewProgress(
                getDataManager().getDoneLevelList(difficulty.getId()).size(),
                getDataManager().getLevelList(difficulty.getId()).size());

        getMvpView().refreshViewPager(
                getDataManager().getLevelList(difficulty.getId()));
    }
}