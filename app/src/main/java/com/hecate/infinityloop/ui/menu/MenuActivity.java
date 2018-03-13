package com.hecate.infinityloop.ui.menu;

import android.os.Bundle;
import android.view.View;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.ui.base.BaseActivity;
import com.hecate.infinityloop.ui.maps.MapsActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends BaseActivity implements MenuContract {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setUnBinder(ButterKnife.bind(this));
    }

    @Override
    public void openMapActivity() {
        startActivity(MapsActivity.getStartIntent(this));
        finish();
    }

    @OnClick(R.id.text_menu_select)
    void onGoogleLoginClick(View v) {
        //mPresenter.onSelectLevelClick();
    }
}
