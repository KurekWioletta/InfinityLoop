package com.hecate.infinityloop.utils;

import com.hecate.infinityloop.BuildConfig;

import timber.log.Timber;

public class AppLogger {

    public static void init() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static void d(String s, Object... objects) {
        Timber.d(s, objects);
    }

    public static void e(String s, Object... objects) {
        Timber.e(s, objects);
    }
}
