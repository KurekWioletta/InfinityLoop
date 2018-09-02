package com.hecate.infinityloop.ui.selectlvl.level;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

public class LevelAdapterTransformer implements ViewPager.PageTransformer {

    private float smallerScale;
    private float startOffset;

    public LevelAdapterTransformer(float smallerScale, float startOffset) {
        this.smallerScale = smallerScale;
        this.startOffset = startOffset;
    }

    @Override
    public void transformPage(View page, float position) {
        float absPosition = Math.abs((position - startOffset));

        if (absPosition >= 1)  {
            page.setScaleY(smallerScale);
        } else {
            page.setScaleY((smallerScale - 1) * absPosition + 1);
        }
    }

}
