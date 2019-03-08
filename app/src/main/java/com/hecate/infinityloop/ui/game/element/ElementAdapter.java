package com.hecate.infinityloop.ui.game.element;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.hecate.infinityloop.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ElementAdapter extends BaseAdapter {

    private List<View> mViewList;
    private int[] mElementsArray;
    private Context mContext;

    @BindView(R.id.image_game_element)
    ImageView elementImageView;

    public ElementAdapter(Context context, int[] elementsArray) {
        mContext = context;
        mElementsArray = elementsArray;
        mViewList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mElementsArray.length;
    }

    @Override
    public View getItem(int position) {
        return mViewList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup container) {
        if (view == null) {
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_element, container, false);

            ButterKnife.bind(this, view);

            elementImageView.setImageResource(mElementsArray[position]);

            mViewList.add(elementImageView);
        }

        return  view;
    }
}
