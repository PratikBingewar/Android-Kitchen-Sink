package dev.learn.phoenix.app.androidkitchensink.common;

import java.util.ArrayList;
import java.util.List;

import dev.learn.phoenix.app.androidkitchensink.shared.SectionListItem;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.FrameLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.LinearLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.PercentRelativeLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.RelativeLayoutFragment;

/**
 * Created by sudhar on 8/2/17.
 */

public class MetaData {

	private static final MetaData sMetaData = new MetaData();
	private List<Topic> topicsList;

	private final String[] mTopics = {"Views & Layouts", "Styling Views", "Adapter Views", "Event Handling",
			"Networking", "Persistence", "Background Jobs/Services", "Intents",
			"Image Handling", "Surface Views", "Sensors"};

	public static MetaData getInstance() {
		return sMetaData;
	}

	public void init() {
		topicsList = new ArrayList<>();
		loadMetadata();
	}

	public List<Section> getSections(int position) {
		if (position < 0 || position > topicsList.size()) return null;
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
		sectionsList.add(new Section("Layouts", getLayoutsList()));
		sectionsList.add(new Section("Views", getViewsList()));
	}

	private List<SectionListItem> getLayoutsList() {
		SectionListItem[] sectionListItems = new SectionListItem[]{
				new SectionListItem("Linear Layout", LinearLayoutFragment.class),
				new SectionListItem("Relative Layout", RelativeLayoutFragment.class),
				new SectionListItem("Percentage Relative Layout", PercentRelativeLayoutFragment.class),
				new SectionListItem("Frame Layout", FrameLayoutFragment.class)
		};

		return constructList(sectionListItems);
	}

	private List<SectionListItem> getViewsList() {
		SectionListItem[] sectionListItems = new SectionListItem[]{};
		return constructList(sectionListItems);
	}


	private List<SectionListItem> constructList(SectionListItem[] sectionListItems) {
		List<SectionListItem> sectionListItemsList = new ArrayList<>();
		for (SectionListItem sectionListItem : sectionListItems) {
			sectionListItemsList.add(sectionListItem);
		}
		return sectionListItemsList;
	}
}
