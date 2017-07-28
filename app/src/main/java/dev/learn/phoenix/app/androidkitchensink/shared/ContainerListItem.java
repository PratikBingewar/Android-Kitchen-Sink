package dev.learn.phoenix.app.androidkitchensink.shared;

/**
 * Created by sudharti on 7/26/17.
 */
public class ContainerListItem {
    private String text;
    private boolean isHeading;

    public ContainerListItem(String text) {
        this.text = text;
    }

    public ContainerListItem(String text, boolean isHeading) {
        this.text = text;
        this.isHeading = isHeading;
    }

    public String getText() {
        return text;
    }

    public boolean isHeading() {
        return isHeading;
    }
}
