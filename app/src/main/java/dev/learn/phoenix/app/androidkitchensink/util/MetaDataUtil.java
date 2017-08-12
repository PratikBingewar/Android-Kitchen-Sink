package dev.learn.phoenix.app.androidkitchensink.util;

import java.util.ArrayList;
import java.util.List;

import dev.learn.phoenix.app.androidkitchensink.common.FeatureListItem;
import dev.learn.phoenix.app.androidkitchensink.common.Section;
import dev.learn.phoenix.app.androidkitchensink.common.Topic;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.ButtonFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.ConstraintLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.CoordinatorLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.DataBindingFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.EditTextFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.FrameLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.ImageViewFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.LinearLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.MapViewFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.PercentRelativeLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.RelativeLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.ScrollViewFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.SoftKeyBoardDemoFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.TextViewFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.WebViewFragment;

/**
 * Created by sudhar on 8/2/17.
 */

public class MetaDataUtil {

    private static final MetaDataUtil S_META_DATA_UTIL = new MetaDataUtil();
    private final String[] mTopics = {"VIEWS & LAYOUTS", "STYLING VIEWS", "ADAPTER VIEWS", "EVENT HANDLING",
            "NETWORKING", "PERSISTENCE", "BACKGROUND JOBS/SERVICES", "INTENTS",
            "IMAGE HANDLING", "SURFACE VIEWS", "SENSORS"};
    private List<Topic> topicsList;

    public static MetaDataUtil getInstance() {
        return S_META_DATA_UTIL;
    }

    public void init() {
        topicsList = new ArrayList<>();
        loadMetadata();
    }

    public List<Section> getSections(int position) {
        if (position < 0 || position >= topicsList.size()) return null;
        return topicsList.get(position).getSections();
    }

    public String[] getTopics() {
        return this.mTopics;
    }

    private void loadMetadata() {
        for (int i = 0; i < mTopics.length; i++) {
            topicsList.add(new Topic(mTopics[i]));
        }

        populateViewsAndLayouts(topicsList.get(0));
    }

    private void populateViewsAndLayouts(Topic topic) {
        List<Section> sectionsList = topic.getSections();
        sectionsList.add(new Section("LAYOUTS", getLayoutsList()));
        sectionsList.add(new Section("VIEWS", getViewsList()));
        sectionsList.add(new Section("OTHER", getLayoutsViewsOtherList()));
    }

    private List<FeatureListItem> getLayoutsList() {
        FeatureListItem[] featureListItems = new FeatureListItem[]{
                new FeatureListItem("LinearLayout", LinearLayoutFragment.class),
                new FeatureListItem("RelativeLayout", RelativeLayoutFragment.class),
                new FeatureListItem("PercentageRelativeLayout", PercentRelativeLayoutFragment.class),
                new FeatureListItem("FrameLayout", FrameLayoutFragment.class),
                new FeatureListItem("ConstraintLayout", ConstraintLayoutFragment.class),
                new FeatureListItem("CoordinatorLayout", CoordinatorLayoutFragment.class)
        };

        return constructList(featureListItems);
    }

    private List<FeatureListItem> getViewsList() {
        FeatureListItem[] featureListItems = new FeatureListItem[]{
                new FeatureListItem("TextView", TextViewFragment.class),
                new FeatureListItem("Button", ButtonFragment.class),
                new FeatureListItem("EditText", EditTextFragment.class),
                new FeatureListItem("ImageView", ImageViewFragment.class),
                new FeatureListItem("WebView", WebViewFragment.class),
                new FeatureListItem("ScrollView", ScrollViewFragment.class),
                new FeatureListItem("MapView", MapViewFragment.class)
        };
        return constructList(featureListItems);
    }

    private List<FeatureListItem> getLayoutsViewsOtherList() {
        FeatureListItem[] featureListItems = new FeatureListItem[]{
                new FeatureListItem("Data Binding", DataBindingFragment.class),
                new FeatureListItem("Soft Keyboard Demo", SoftKeyBoardDemoFragment.class)
        };
        return constructList(featureListItems);
    }


    private List<FeatureListItem> constructList(FeatureListItem[] featureListItems) {
        List<FeatureListItem> featureListItemsList = new ArrayList<>();
        for (FeatureListItem featureListItem : featureListItems) {
            featureListItemsList.add(featureListItem);
        }
        return featureListItemsList;
    }
}
