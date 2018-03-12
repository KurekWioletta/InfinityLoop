package com.hecate.infinityloop.ui.menu;

import android.os.Bundle;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.ui.base.BaseActivity;
import com.hecate.infinityloop.ui.map.MapActivity;

public class MenuActivity extends BaseActivity implements MenuView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public void openMapActivity() {
        startActivity(MapActivity.getStartIntent(this));
        finish();
    }


}
