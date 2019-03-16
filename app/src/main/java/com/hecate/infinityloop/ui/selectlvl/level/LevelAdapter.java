package com.hecate.infinityloop.ui.selectlvl.level;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.data.db.model.Level; // needed refactor - should not be here
import com.hecate.infinityloop.ui.selectlvl.SelectLvlActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LevelAdapter extends PagerAdapter {

    private List<CardView> mViewList;
    private List<Level> mLevelList;
    private Context mContext;

    @BindString(R.string.symbol_hashtag)
    String symbolHashtag;

    @BindView(R.id.card_lvl)
    CardView lvlCardView;

    @BindView(R.id.text_lvl_number)
    TextView lvlNumberTextView;

    public LevelAdapter() {
        mViewList = new ArrayList<>();
        mLevelList = new ArrayList<>();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.item_lvl, container, false);

        ButterKnife.bind(this, view);

        container.addView(view);

        mViewList.set(position, lvlCardView);
        mContext = container.getContext();

        setUp(position);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewList.get(position));
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @OnClick(R.id.card_lvl)
    void onLevelClick() {
        ((SelectLvlActivity)mContext).onLevelClicked();
    }

    public void clear(ViewPager pager) {
        pager.setAdapter (null);
        mViewList.clear();
        mLevelList.clear();
        pager.setAdapter (this);
    }

    public void addItem(Level level) {
        mViewList.add(null);
        mLevelList.add(level);
    }

    public Level getLevel(int position) {
        return mLevelList.get(position);
    }

    private void setUp(int position) {
        lvlNumberTextView.setText(String.valueOf(symbolHashtag + (position + 1)));
    }
}
