package com.hecate.infinityloop.ui.game;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.data.DataManager;
import com.hecate.infinityloop.ui.base.BasePresenter;
import com.hecate.infinityloop.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class GamePresenter<V extends GameContract.View> extends BasePresenter<V> implements GameContract.Presenter<V>  {


    int logos[] = {R.drawable.ic_element_1, R.drawable.ic_element_1, R.drawable.ic_element_1, R.drawable.ic_element_1,
            R.drawable.ic_element_1, R.drawable.ic_element_1, R.drawable.ic_element_1, R.drawable.ic_element_1,
            R.drawable.ic_element_1, R.drawable.ic_element_1, R.drawable.ic_element_1, R.drawable.ic_element_1,
            R.drawable.ic_element_1, R.drawable.ic_element_1, R.drawable.ic_element_1, R.drawable.ic_element_1,
            R.drawable.ic_element_1, R.drawable.ic_element_1, R.drawable.ic_element_1, R.drawable.ic_element_1,};

    @Inject
    public GamePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {
        int dimX = Integer.parseInt(getDataManager().getCurrentLevelDimensions().split("x", -1)[0]);
        int dimY = Integer.parseInt(getDataManager().getCurrentLevelDimensions().split("x", -1)[1]);

        getMvpView().setUpGameboard(dimX, dimY,logos);
    }

}
