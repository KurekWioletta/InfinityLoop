package com.hecate.infinityloop;

import android.app.Application;

import com.hecate.infinityloop.di.components.AppComponent;
import com.hecate.infinityloop.di.components.DaggerAppComponent;
import com.hecate.infinityloop.di.modules.AppModule;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class App extends Application {

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();

        mAppComponent.inject(this);

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    public void setComponent(AppComponent applicationComponent) {
        mAppComponent = applicationComponent;
    }

    public AppComponent getComponent() {
        return mAppComponent;
    }

}