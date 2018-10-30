package com.hecate.infinityloop.di.components;

import com.hecate.infinityloop.di.PerActivity;
import com.hecate.infinityloop.di.modules.ActivityModule;
import com.hecate.infinityloop.ui.game.GameActivity;
import com.hecate.infinityloop.ui.selectlvl.SelectLvlActivity;
import com.hecate.infinityloop.ui.main.MainActivity;
import com.hecate.infinityloop.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity activity);

    void inject(MainActivity activity);

    void inject(SelectLvlActivity activity);

    void inject(GameActivity activity);

}