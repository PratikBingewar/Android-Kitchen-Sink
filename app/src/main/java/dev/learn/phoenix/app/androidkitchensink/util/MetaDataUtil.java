package dev.learn.phoenix.app.androidkitchensink.util;

import java.util.ArrayList;
import java.util.List;

import dev.learn.phoenix.app.androidkitchensink.common.FeatureListItem;
import dev.learn.phoenix.app.androidkitchensink.common.Section;
import dev.learn.phoenix.app.androidkitchensink.common.Topic;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.ButtonFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.EditTextFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.FrameLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.LinearLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.PercentRelativeLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.RelativeLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.TextViewFragment;

/**
 * Created by sudhar on 8/2/17.
 */

public class MetaDataUtil {

	private static final MetaDataUtil S_META_DATA_UTIL = new MetaDataUtil();
	private final String[] mTopics = { "Home", "Views & Layouts", "Styling Views", "Adapter Views", "Event Handling",
			"Networking", "Persistence", "Background Jobs/Services", "Intents",
			"Image Handling", "Surface Views", "Sensors" };
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

		populateViewsAndLayouts(topicsList.get(1));
	}

	private void populateViewsAndLayouts(Topic topic) {
		List<Section> sectionsList = topic.getSections();
		sectionsList.add(new Section("LAYOUTS", getLayoutsList()));
		sectionsList.add(new Section("VIEWS", getViewsList()));
	}

	private List<FeatureListItem> getLayoutsList() {
		FeatureListItem[] featureListItems = new FeatureListItem[] {
				new FeatureListItem("Linear Layout", LinearLayoutFragment.class),
				new FeatureListItem("Relative Layout", RelativeLayoutFragment.class),
				new FeatureListItem("Percentage Relative Layout", PercentRelativeLayoutFragment.class),
				new FeatureListItem("Frame Layout", FrameLayoutFragment.class)
		};

		return constructList(featureListItems);
	}

	private List<FeatureListItem> getViewsList() {
		FeatureListItem[] featureListItems = new FeatureListItem[]{
				new FeatureListItem("Button", ButtonFragment.class),
				new FeatureListItem("Text View", TextViewFragment.class),
				new FeatureListItem("Edit Text", EditTextFragment.class)
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
