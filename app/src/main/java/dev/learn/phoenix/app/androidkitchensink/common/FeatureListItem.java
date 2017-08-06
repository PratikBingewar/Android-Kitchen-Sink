package dev.learn.phoenix.app.androidkitchensink.common;

import java.io.Serializable;

/**
 * Created by sudharti on 7/26/17.
 */
public class FeatureListItem implements Serializable {
    private String mText;
    private Class mClazz;

    public FeatureListItem(String text, Class clazz) {
        this.mText = text;
        this.mClazz = clazz;
    }

    public String getText() {
        return mText;
    }

    public Class getClazz() {
        return mClazz;
    }
}
