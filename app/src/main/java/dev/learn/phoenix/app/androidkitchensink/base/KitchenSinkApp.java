package dev.learn.phoenix.app.androidkitchensink.base;

import android.app.Application;

import dev.learn.phoenix.app.androidkitchensink.util.MetaDataUtil;

/**
 * Created by sudharti on 8/2/17.
 */

public class KitchenSinkApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MetaDataUtil.getInstance().init();
    }
}
