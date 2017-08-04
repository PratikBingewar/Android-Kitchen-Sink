package dev.learn.phoenix.app.androidkitchensink.common;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dev.learn.phoenix.app.androidkitchensink.shared.ContainerListItem;

/**
 * Created by sudharti on 8/3/17.
 */
public class Topic {
    private String mLabel;
    private Map<Integer, Section> mSectionsMap;

    public Topic(String label) {
        this.mLabel = label;
        this.mSectionsMap = new LinkedHashMap<>();
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String mLabel) {
        this.mLabel = mLabel;
    }

    public Map<Integer, Section> getSectionsMap() {
        return mSectionsMap;
    }

    public void setSectionsMap(Map<Integer, Section> mSectionsMap) {
        this.mSectionsMap = mSectionsMap;
    }
}
