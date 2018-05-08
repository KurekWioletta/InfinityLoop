package com.hecate.infinityloop.ui.levels.level;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.ui.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LvlAdapter extends PagerAdapter {

    private List<CardView> mViews;

    @BindView(R.id.card_lvl)
    CardView cardLvl;

    @BindView(R.id.text_lvl_number)
    TextView textLvlNumber;

    public LvlAdapter() {
        mViews = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.item_lvl, container, false);

        ButterKnife.bind(this, view);

        container.addView(view);

        cardLvl.setMaxCardElevation(5 * 10);
        mViews.set(position, cardLvl);

        setUp(position);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void setUp(int position){
        Log.e("vp", "setUp");
        textLvlNumber.setText(position);
    }

}
