package com.hecate.infinityloop.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

public class ViewUtils {

    public static int getDrawableResourseId(Context context, String name) throws RuntimeException {
        try {
            return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
        } catch (Exception e) {
            throw new RuntimeException("Error getting Resource ID", e);
        }
    }

    public static RotateAnimation rotateBitmap(int angle, int duration) {
        RotateAnimation animation = new RotateAnimation(angle - 90,
                angle,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f);

        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(0);
        animation.setFillAfter(true);
        animation.setDuration(duration);

        return animation;
    }
}
