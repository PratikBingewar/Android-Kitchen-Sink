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

public class Metadata {

    private static final Metadata sMetadata = new Metadata();
    private Map<String, Map<String, List<ContainerListItem>>> metadataMap;

    private final String[] topics = {"Views & Layouts", "Styling Views", "Adapter Views", "Event Handling",
            "Networking", "Persistence", "Background Jobs/Services", "Intents",
            "Image Handling", "Surface Views", "Sensors"};

    public static Metadata getInstance() {
        return sMetadata;
    }

    public void init() {
        metadataMap = new LinkedHashMap<>();
        loadMetadata();
    }

    public Map<String, Map<String, List<ContainerListItem>>> getMetadata() {
        return metadataMap;
    }

    public String[] getTopics() {
        return topics;
    }

    public Map<String, List<ContainerListItem>> getTopicMap(int position) {
        return metadataMap.get(topics[position]);
    }

    private void loadMetadata() {
        for (String topic : topics) {
            metadataMap.put(topic, new LinkedHashMap<String, List<ContainerListItem>>());
        }

        populateViewsAndLayouts(metadataMap);
    }

    private void populateViewsAndLayouts(Map<String, Map<String, List<ContainerListItem>>> metadataMap) {
        Map<String, List<ContainerListItem>> sectionsMap = metadataMap.get("Views & Layouts");
        sectionsMap.put("Layouts", getLayoutsList());
        sectionsMap.put("Views", getViewsList());
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
