package dev.learn.phoenix.app.androidkitchensink.base;

import android.app.Application;
import android.util.Log;

import dev.learn.phoenix.app.androidkitchensink.common.Metadata;

import static android.content.ContentValues.TAG;

/**
 * Created by sudharti on 8/2/17.
 */

public class KitchenSinkApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Metadata.getInstance().init();
    }
}
