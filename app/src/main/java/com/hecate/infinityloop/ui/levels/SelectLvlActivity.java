package com.hecate.infinityloop.ui.levels;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectLvlActivity extends BaseActivity implements SelectLvlContract.View {

    @Inject
    SelectLvlPresenter<SelectLvlContract.View> mPresenter;

    @Inject
    SelectLvlPagerAdapter mPagerAdapter;

    @BindView(R.id.pager_select_lvl)
    ViewPager mViewPager;

    @BindView(R.id.text_select_lvl_difficulty)
    TextView mTextViewDifficulty;

    @BindView(R.id.text_select_lvl_progress)
    TextView mTextViewProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_lvl);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    public void refreshTextViewDifficulty(String difficulty) {
        mTextViewDifficulty.setText(difficulty);
    }

    @Override
    public void refreshTextViewProgress(int allLevels, int doneLevels) {
        mTextViewProgress.setText(doneLevels + '/' + allLevels);
    }

    @Override
    public void refreshViewPager(String difficulty) {
        //todo
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SelectLvlActivity.class);
        return intent;
    }

    private void setUp() {
        mViewPager.setAdapter(mPagerAdapter);

        mViewPager.setOffscreenPageLimit(4);

        mPagerAdapter.addCardItem();
        mPagerAdapter.addCardItem();
        mPagerAdapter.addCardItem();

        mPagerAdapter.notifyDataSetChanged();

        mPresenter.onViewInitialized();
    }
}
