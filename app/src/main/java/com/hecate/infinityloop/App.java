package com.hecate.infinityloop;

import android.app.Application;


import com.hecate.infinityloop.di.AppComponent;
import com.hecate.infinityloop.di.AppModule;
import com.hecate.infinityloop.di.DaggerAppComponent;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Wiola on 08.03.2018.
 */

public class App extends Application {

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build();

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

}