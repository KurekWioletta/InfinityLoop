package com.hecate.infinityloop.di.modules;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.hecate.infinityloop.di.ActivityContext;
import com.hecate.infinityloop.di.PerActivity;
import com.hecate.infinityloop.ui.main.MainContract;
import com.hecate.infinityloop.ui.main.MainPresenter;
import com.hecate.infinityloop.ui.selectlvl.SelectLvlContract;
import com.hecate.infinityloop.ui.selectlvl.SelectLvlPresenter;
import com.hecate.infinityloop.ui.selectlvl.level.LevelAdapter;
import com.hecate.infinityloop.ui.selectlvl.level.LevelAdapterTransformer;
import com.hecate.infinityloop.ui.splash.SplashContract;
import com.hecate.infinityloop.ui.splash.SplashPresenter;
import com.hecate.infinityloop.utils.rx.AppSchedulerProvider;
import com.hecate.infinityloop.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    LevelAdapter provideSelectLvlPagerAdapter() {
        return new LevelAdapter();
    }
/*
    @Provides
    @PerActivity
    SplashPresenter<SplashContract.View> provideSplashPresenter(SplashPresenter<SplashContract.View> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainPresenter<MainContract.View> provideMainPresenter(MainPresenter<MainContract.View> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SelectLvlPresenter<SelectLvlContract.View> provideSelectLvlPresenter(SelectLvlPresenter<SelectLvlContract.View> presenter) {
        return presenter;
    }
*/
}
