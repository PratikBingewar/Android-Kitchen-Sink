package dev.learn.phoenix.app.androidkitchensink.common;

import java.io.Serializable;
import java.util.List;

import dev.learn.phoenix.app.androidkitchensink.shared.SectionListItem;

/**
 * Created by sudharti on 8/3/17.
 */

public class Section implements Serializable {
    private String mTitle;
    private List<SectionListItem> mSectionListItems;

    public Section(String mTitle, List<SectionListItem> mSectionListItems) {
        this.mTitle = mTitle;
        this.mSectionListItems = mSectionListItems;
    }

    public String getTitle() {
        return mTitle;
    }

    public List<SectionListItem> getSectionListItems() {
        return mSectionListItems;
    }
}
