package com.hecate.infinityloop.ui.levels;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hecate.infinityloop.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectLvlPagerAdapter extends PagerAdapter {

    private List<CardView> mViews;

    @BindString(R.string.symbol_hashtag)
    String symbolHashtag;

    @BindView(R.id.card_lvl)
    CardView cardLvl;

    @BindView(R.id.text_lvl_number)
    TextView textLvlNumber;

    public SelectLvlPagerAdapter() {
        mViews = new ArrayList<>();
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.item_lvl, container, false);

        ButterKnife.bind(this, view);

        container.addView(view);

        mViews.set(position, cardLvl);

        setUp(position);

        return view;
    }

    @Override
    public int getCount() {
        return mViews.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    public void addCardItem() {
        mViews.add(null);
    }

    private void setUp(int position) {
        textLvlNumber.setText(String.valueOf(symbolHashtag + (position + 1)));
    }

}
