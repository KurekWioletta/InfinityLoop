package com.hecate.infinityloop.ui.main;

import android.os.Bundle;
import android.view.View;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.ui.base.BaseActivity;
import com.hecate.infinityloop.ui.levels.SelectLevelActivity;

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

    @OnClick(R.id.text_menu_select_level)
    void onSelectLevelClick(View v) {
        mPresenter.onSelectLevelClick();
    }

    @Override
    public void openSelectLevelActivity() {
        startActivity(SelectLevelActivity.getStartIntent(this));
        finish();
    }

}
