package com.hecate.infinityloop.di.modules;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.hecate.infinityloop.data.db.DbHelper;
import com.hecate.infinityloop.ui.levels.SelectLvlPagerAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    SelectLvlPagerAdapter provideSelectLvlPagerAdapter(AppCompatActivity activity) {
        return new SelectLvlPagerAdapter();
    }


}
