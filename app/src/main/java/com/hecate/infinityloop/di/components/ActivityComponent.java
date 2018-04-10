package com.hecate.infinityloop.di.components;

import com.hecate.infinityloop.di.PerActivity;
import com.hecate.infinityloop.di.modules.ActivityModule;
import com.hecate.infinityloop.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by Wiola on 10.04.2018.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}