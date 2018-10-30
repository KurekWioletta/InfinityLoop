package com.hecate.infinityloop.di.modules;

import android.support.v7.app.AppCompatActivity;

import com.hecate.infinityloop.ui.selectlvl.level.LevelAdapter;
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

}
