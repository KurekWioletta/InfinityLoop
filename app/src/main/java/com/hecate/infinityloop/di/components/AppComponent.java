package com.hecate.infinityloop.di.components;

import android.app.Application;

import com.hecate.infinityloop.App;
import com.hecate.infinityloop.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by Wiola on 10.03.2018.
 */

@Singleton
@Component(modules = {
        AppModule.class})

public interface AppComponent {
    void inject(App app);

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder application(Application application);

    }
}