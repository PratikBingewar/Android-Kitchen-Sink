package dev.learn.phoenix.app.androidkitchensink.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dev.learn.phoenix.app.androidkitchensink.shared.ContainerListItem;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.FrameLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.LinearLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.PercentRelativeLayoutFragment;
import dev.learn.phoenix.app.androidkitchensink.topic_layouts_views.RelativeLayoutFragment;

/**
 * Created by sudhar on 8/2/17.
 */

public class MetaData {

    private static final MetaData sMetaData = new MetaData();
    private Map<Integer, Topic> metadataMap;

    private final String[] mTopics = {"Views & Layouts", "Styling Views", "Adapter Views", "Event Handling",
            "Networking", "Persistence", "Background Jobs/Services", "Intents",
            "Image Handling", "Surface Views", "Sensors"};

    public static MetaData getInstance() {
        return sMetaData;
    }

    public void init() {
        metadataMap = new LinkedHashMap<>();
        loadMetadata();
    }

    public Map<Integer, Topic> getMetadata() {
        return metadataMap;
    }

    public Map<Integer, Section> getSectionsMap(int position) {
        if (!metadataMap.containsKey(position)) return null;
        return metadataMap.get(position).getSectionsMap();
    }

    public String[] getTopics() {
        return this.mTopics;
    }

    private void loadMetadata() {
        for (int i = 0; i < mTopics.length; i++) {
            metadataMap.put(0, new Topic(mTopics[i]));
        }

        populateViewsAndLayouts(metadataMap);
    }

    private void populateViewsAndLayouts(Map<Integer, Topic> metadataMap) {
        Topic topic = metadataMap.get(0);
        Map<Integer, Section> sectionsMap = topic.getSectionsMap();
        sectionsMap.put(0, new Section("Layouts", getLayoutsList()));
        sectionsMap.put(1, new Section("Views", getViewsList()));
    }

    private List<ContainerListItem> getLayoutsList() {
        ContainerListItem[] containerListItems = new ContainerListItem[]{
                new ContainerListItem("Linear Layout", LinearLayoutFragment.class),
                new ContainerListItem("Relative Layout", RelativeLayoutFragment.class),
                new ContainerListItem("Percentage Relative Layout", PercentRelativeLayoutFragment.class),
                new ContainerListItem("Frame Layout", FrameLayoutFragment.class)
        };

        return constructList(containerListItems);
    }

    private List<ContainerListItem> getViewsList() {
        ContainerListItem[] containerListItems = new ContainerListItem[]{};
        return constructList(containerListItems);
    }


    private List<ContainerListItem> constructList(ContainerListItem[] containerListItems) {
        List<ContainerListItem> containerListItemsList = new ArrayList<>();
        for (ContainerListItem containerListItem : containerListItems) {
            containerListItemsList.add(containerListItem);
        }
        return containerListItemsList;
    }
}
