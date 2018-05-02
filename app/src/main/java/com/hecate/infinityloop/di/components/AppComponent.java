package com.hecate.infinityloop.di.components;

import android.app.Application;
import android.content.Context;

import com.hecate.infinityloop.App;
import com.hecate.infinityloop.di.ApplicationContext;
import com.hecate.infinityloop.di.modules.AppModule;

import javax.inject.Singleton;
import dagger.Component;
import dagger.android.AndroidInjector;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent extends AndroidInjector<App> {

    void inject(App app);

    @ApplicationContext
    Context context();

    Application application();

}