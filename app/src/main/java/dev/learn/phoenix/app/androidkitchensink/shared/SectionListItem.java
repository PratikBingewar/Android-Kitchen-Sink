package dev.learn.phoenix.app.androidkitchensink.shared;

import java.io.Serializable;

/**
 * Created by sudharti on 7/26/17.
 */
public class SectionListItem implements Serializable {
    private String mText;
    private boolean isHeading;
    private Class mClazz;

    public SectionListItem(String text, Class clazz) {
        this(text, false, clazz);
    }

    protected SectionListItem(String text, boolean isHeading, Class clazz) {
        this.mText = text;
        this.isHeading = isHeading;
        this.mClazz = clazz;
    }

    public String getText() {
        return mText;
    }

    public boolean isHeading() {
        return isHeading;
    }

    public Class getClazz() {
        return mClazz;
    }
}
