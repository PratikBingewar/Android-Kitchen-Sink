package dev.learn.phoenix.app.androidkitchensink.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sudharti on 8/3/17.
 */
public class Topic {
    private String mLabel;
    private List<Section> mSectionsList;

    public Topic(String label) {
        this.mLabel = label;
        this.mSectionsList = new ArrayList<>();
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String mLabel) {
        this.mLabel = mLabel;
    }

    public List<Section> getSections() {
        return mSectionsList;
    }

    public void setSectionsMap(List<Section> sectionsList) {
        this.mSectionsList = sectionsList;
    }
}
