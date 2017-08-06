package dev.learn.phoenix.app.androidkitchensink.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sudharti on 8/3/17.
 */

public class Section implements Serializable {
    private String mTitle;
    private List<FeatureListItem> mFeatureListItems;

    public Section(String mTitle, List<FeatureListItem> mFeatureListItems) {
        this.mTitle = mTitle;
        this.mFeatureListItems = mFeatureListItems;
    }

    public String getTitle() {
        return mTitle;
    }

    public List<FeatureListItem> getSectionListItems() {
        return mFeatureListItems;
    }
}
