package com.hecate.infinityloop.ui.levels;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.ui.base.BaseActivity;

import butterknife.ButterKnife;

public class SelectLvlActivity extends BaseActivity{

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SelectLvlActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_lvl);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
    }
}
