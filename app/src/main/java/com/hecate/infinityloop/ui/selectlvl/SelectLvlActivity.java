package com.hecate.infinityloop.ui.selectlvl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.data.db.model.Level;
import com.hecate.infinityloop.ui.base.BaseActivity;
import com.hecate.infinityloop.ui.selectlvl.level.LevelAdapter;
import com.hecate.infinityloop.ui.selectlvl.level.LevelAdapterTransformer;
import com.hecate.infinityloop.utils.ViewConstants;
import com.hecate.infinityloop.utils.ScreenUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectLvlActivity extends BaseActivity implements SelectLvlContract.View {

    @Inject
    SelectLvlPresenter<SelectLvlContract.View> mPresenter;

    @Inject
    LevelAdapter mLevelAdapter;

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
    public void refreshTextViewProgress(int doneLevels, int allLevels) {
        mTextViewProgress.setText(doneLevels + "/" + allLevels);
    }

    @Override
    public void refreshViewPager(List<Level> levelList) {
        for(Level level : levelList){
            mLevelAdapter.addItem(level);
        }
        mLevelAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.image_select_lvl_previous_difficulty)
    void onPreviousDifficultyClick(View v) {
        mPresenter.onPreviousDifficultyClick();
    }

    @OnClick(R.id.image_select_lvl_next_difficulty)
    void onNextDifficultyClick(View v) {
        mPresenter.onNextDifficultyClick();
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SelectLvlActivity.class);
        return intent;
    }

    private void setUp() {
        float screenWidth = ScreenUtils.getScreenWidth(this);
        float scale = ViewConstants.VIEW_PAGER_SMALLER_SCALE;

        int partialWidth = (int) getResources().getDimension(R.dimen.view_pager_padding);
        int pageMargin = (int) getResources().getDimension(R.dimen.view_pager_page_margin);

        int viewPagerPadding = partialWidth + pageMargin;

        mViewPager.setPageMargin(pageMargin);

        mViewPager.setPageTransformer(false, new LevelAdapterTransformer(
                scale,
                viewPagerPadding/(screenWidth - 2*viewPagerPadding)));

        mViewPager.setAdapter(mLevelAdapter);
        mViewPager.setOffscreenPageLimit(4);
        mPresenter.onViewInitialized();
    }
}
