package com.hecate.infinityloop.di.modules;

import android.app.Application;
import android.content.Context;

import com.hecate.infinityloop.App;
import com.hecate.infinityloop.R;
import com.hecate.infinityloop.di.ApplicationContext;

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
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/kirvy_regular.otf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

}