package com.hecate.infinityloop.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.hecate.infinityloop.R;

public class DimensionsUtils {

    public static float getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    public static int getElementSize(Context context){
        return (int) context.getResources().getDimension(R.dimen.game_image_element_size);
    }
}
