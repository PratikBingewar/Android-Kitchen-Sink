package dev.learn.phoenix.app.androidkitchensink.common;

import java.util.List;

import dev.learn.phoenix.app.androidkitchensink.shared.ContainerListItem;

/**
 * Created by sudharti on 8/3/17.
 */

public class Section {
    private String mTitle;
    private List<ContainerListItem> mContainerListItems;

    public Section(String mTitle, List<ContainerListItem> mContainerListItems) {
        this.mTitle = mTitle;
        this.mContainerListItems = mContainerListItems;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public List<ContainerListItem> getContainerListItems() {
        return mContainerListItems;
    }

    public void setContainerListItems(List<ContainerListItem> mContainerListItems) {
        this.mContainerListItems = mContainerListItems;
    }
}
