package com.hecate.infinityloop.di.components;

import com.hecate.infinityloop.di.PerActivity;
import com.hecate.infinityloop.di.modules.ActivityModule;
import com.hecate.infinityloop.ui.levels.SelectLvlActivity;
import com.hecate.infinityloop.ui.main.MainActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(SelectLvlActivity activity);

}