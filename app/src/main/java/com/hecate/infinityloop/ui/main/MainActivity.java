package com.hecate.infinityloop.ui.main;

import android.os.Bundle;
import android.view.View;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.ui.base.BaseActivity;
import com.hecate.infinityloop.ui.maps.MapsActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUnBinder(ButterKnife.bind(this));
    }

    @Override
    public void openMapActivity() {
        startActivity(MapsActivity.getStartIntent(this));
        finish();
    }

    @OnClick(R.id.text_menu_choose_map)
    void onSelectLevelClick(View v) {
        mPresenter.onSelectLevelClick();
    }
}
