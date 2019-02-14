package com.hecate.infinityloop.ui.selectlvl;

import com.hecate.infinityloop.data.DataManager;
import com.hecate.infinityloop.data.db.model.Difficulty;
import com.hecate.infinityloop.data.db.model.Level;
import com.hecate.infinityloop.ui.base.BasePresenter;
import com.hecate.infinityloop.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SelectLvlPresenter<V extends SelectLvlContract.View> extends BasePresenter<V> implements SelectLvlContract.Presenter<V> {

    @Inject
    public SelectLvlPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {
        Difficulty difficulty = getDataManager().getDifficulty();
        getDifficultyData(difficulty);
    }

    @Override
    public void onPreviousDifficultyClick() {
        Difficulty difficulty = getDataManager().getPreviousDifficulty(
                getDataManager().getCurrentDifficultyId());

        getDataManager().setCurrentDifficultyId(difficulty.getId());
        getDifficultyData(difficulty);
    }

    @Override
    public void onNextDifficultyClick() {
        Difficulty difficulty = getDataManager().getNextDifficulty(
                getDataManager().getCurrentDifficultyId());

        getDataManager().setCurrentDifficultyId(difficulty.getId());
        getDifficultyData(difficulty);
    }

    @Override
    public void onLevelClick(Level level) {
        getDataManager().setCurrentLevelId(level.getId());
        getDataManager().setCurrentLevelData(level.getElements(), level.getDimensions());

        getMvpView().openGameActivity();
    }

    private void getDifficultyData(Difficulty difficulty){
        getMvpView().refreshTextViewDifficulty(
                difficulty.getName());

        getMvpView().refreshTextViewProgress(
                getDataManager().getFinishedLevelList(difficulty.getId()).size(),
                getDataManager().getLevelList(difficulty.getId()).size());

        getMvpView().refreshViewPager(
                getDataManager().getLevelList(difficulty.getId()));
    }
}
