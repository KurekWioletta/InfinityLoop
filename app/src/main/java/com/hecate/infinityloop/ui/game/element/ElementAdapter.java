package com.hecate.infinityloop.ui.game.element;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.hecate.infinityloop.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ElementAdapter extends BaseAdapter {

    private int[] logos;
    private Context mContext;

    @BindView(R.id.image_game_element)
    ImageView gameElementImageView;

    public ElementAdapter(Context context, int[] logos) {
        mContext = context;
        this.logos = logos;
    }

    @Override
    public int getCount() {
        return logos.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup container) {
        if (view == null) {
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_element, container, false);

            ButterKnife.bind(this, view);

            gameElementImageView.setImageResource(logos[position]);
        }

        return  view;
    }
}
