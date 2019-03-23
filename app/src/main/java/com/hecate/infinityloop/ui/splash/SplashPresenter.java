package com.hecate.infinityloop.ui.splash;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.data.DataManager;
import com.hecate.infinityloop.ui.base.BasePresenter;
import com.hecate.infinityloop.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class SplashPresenter<V extends SplashContract.View> extends BasePresenter<V> implements SplashContract.Presenter<V> {

    @Inject
    public SplashPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mMvpView) {
        super.onAttach(mMvpView);

        createDatabase();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void createDatabase() {
        getMvpView().showAppLoading();

        getCompositeDisposable().add(getDataManager()
                .createDatabase()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribeWith(new DisposableObserver<Boolean>() {
                    @Override
                    public void onNext(Boolean aBoolean) {
                        //todo - generic abstract class that will work as a Response wrapper
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().hideAppLoading();
                        getMvpView().onError(R.string.err_database_create);
                    }

                    @Override
                    public void onComplete() {
                        getMvpView().openMainActivity();
                    }
                })
        );
    }

}
