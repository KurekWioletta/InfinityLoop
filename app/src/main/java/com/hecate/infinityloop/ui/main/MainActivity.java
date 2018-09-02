package com.hecate.infinityloop.ui.main;

import android.os.Bundle;
import android.view.View;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.ui.base.BaseActivity;
import com.hecate.infinityloop.ui.selectlvl.SelectLvlActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    MainPresenter<MainContract.View> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
    }

    @Override
    public void openSelectLevelActivity() {
        startActivity(SelectLvlActivity.getStartIntent(this));
    }

    @OnClick(R.id.text_menu_play)
    void onPlayClick(View v) {
        //todo
    }

    @OnClick(R.id.text_menu_select_lvl)
    void onSelectLevelClick(View v) {
        mPresenter.onSelectLevelClick();
    }

    @OnClick(R.id.text_menu_share)
    void onShareClick(View v) {
        //todo
    }
}
