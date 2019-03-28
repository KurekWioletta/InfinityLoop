package com.hecate.infinityloop.di.modules;

import android.app.Application;
import android.content.Context;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.data.AppDataManager;
import com.hecate.infinityloop.data.DataManager;
import com.hecate.infinityloop.data.db.AppDbHelper;
import com.hecate.infinityloop.data.db.DbHelper;
import com.hecate.infinityloop.data.state.AppStateHelper;
import com.hecate.infinityloop.data.state.StateHelper;
import com.hecate.infinityloop.di.ApplicationContext;
import com.hecate.infinityloop.di.DatabaseInfo;
import com.hecate.infinityloop.utils.AppConst;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class AppModule {

    private final Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConst.DB_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    StateHelper provideStateHelper(AppStateHelper appStateHelper) {
        return appStateHelper;
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/kirvy_regular.otf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

}