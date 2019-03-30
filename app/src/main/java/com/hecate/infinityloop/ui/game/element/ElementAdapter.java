package com.hecate.infinityloop.ui.game.element;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.hecate.infinityloop.R;
import com.hecate.infinityloop.data.gameplay.model.Element;
import com.hecate.infinityloop.utils.AppConst;
import com.hecate.infinityloop.utils.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ElementAdapter extends BaseAdapter {

    private List<View> mViewList;
    private List<Element> mElementList;
    private Context mContext;
    private StringBuffer mResourceName;

    @BindView(R.id.image_game_element)
    ImageView elementImageView;

    public ElementAdapter(Context context) {
        mViewList = new ArrayList<>();
        mElementList = new ArrayList<>();
        mContext = context;
        mResourceName = new StringBuffer(AppConst.ELEMENT_RESOURCE_NAME);
    }

    @Override
    public int getCount() {
        return mElementList.size();
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

            setUp(position);

            mViewList.add(elementImageView);
        }
        return  view;
    }

    public void addItems(List<Element> elementList) {
        mElementList.addAll(elementList);
    }

    /**
     * Sets up elementImageView. To avoid a drop in performance,
     * controls resource name using a StringBuffer.
     */
    private void setUp(int position) {
        int lineType = mElementList.get(position).getLineType();
        int rotationAngle = mElementList.get(position).getRotationAngle();

        if (lineType != 0) {
            mResourceName.append(lineType);
            elementImageView.setImageResource(ViewUtils.getDrawableResourseId(mContext, mResourceName.toString()));
            mResourceName.delete(AppConst.ELEMENT_RESOURCE_NAME.length(), mResourceName.length());

            RotateAnimation animation = ViewUtils.rotateBitmap(rotationAngle, 0);
            elementImageView.startAnimation(animation);
        }
    }
}
