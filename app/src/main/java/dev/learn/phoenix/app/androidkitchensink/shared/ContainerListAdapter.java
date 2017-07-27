package dev.learn.phoenix.app.androidkitchensink.shared;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by sudharti on 7/26/17.
 */

public class ContainerListAdapter extends ArrayAdapter<ContainerListItem> {
    public ContainerListAdapter(Context context, List<ContainerListItem> containerListItems) {
        super(context, 0, containerListItems);
    }
}
