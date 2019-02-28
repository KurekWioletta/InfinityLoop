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

    public static float getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    public static float getNavigationBarHeight(Context context){
        Resources res = context.getResources();
        int resId = res.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resId > 0) {
            return res.getDimensionPixelSize(resId);
        }
        return 0;
    }

    public static int getElementSize(Context context){
        return (int) context.getResources().getDimension(R.dimen.game_element_size);
    }
}
