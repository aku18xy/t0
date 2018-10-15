package com.a9be.annuar.mylibrary;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class MyUtil {

    public float convertDpToPixel(float dp){
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }
}
