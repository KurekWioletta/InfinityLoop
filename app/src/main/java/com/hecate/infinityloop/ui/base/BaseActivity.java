package com.hecate.infinityloop.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hecate.infinityloop.App;
import com.hecate.infinityloop.di.components.ActivityComponent;
import com.hecate.infinityloop.di.components.DaggerActivityComponent;
import com.hecate.infinityloop.di.modules.ActivityModule;

import butterknife.Unbinder;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    private Unbinder mUnbinder;
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(((App) getApplication()).getComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void showMessage(int resId) {

    }

    public void setUnBinder(Unbinder unBinder) {
        mUnbinder = unBinder;
    }

}
