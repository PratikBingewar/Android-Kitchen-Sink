package dev.learn.phoenix.app.androidkitchensink.shared;

/**
 * Created by sudharti on 7/26/17.
 */
public class ContainerListItem {
    private String mText;
    private boolean isHeading;
    private Class mClazz;

    public ContainerListItem(String text, Class clazz) {
        this(text, false, clazz);
    }

    protected ContainerListItem(String text, boolean isHeading, Class clazz) {
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
