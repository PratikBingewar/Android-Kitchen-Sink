package dev.learn.phoenix.app.androidkitchensink.views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.learn.phoenix.app.androidkitchensink.R;
import dev.learn.phoenix.app.androidkitchensink.shared.ContainerListAdapter;
import dev.learn.phoenix.app.androidkitchensink.shared.ContainerListItem;

/**
 * Created by sudharti on 7/26/17.
 */
public class ViewsContainerFragment extends Fragment {

    private ListView mViewsListView;

    private List<ContainerListItem> mContainerListItems;
    private ContainerListAdapter mContainerListAdapter;

    public static ViewsContainerFragment newInstance() {
        Bundle args = new Bundle();
        ViewsContainerFragment fragment = new ViewsContainerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContainerListItems = new ArrayList<>();
        populateContainerListItems();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.views_fragment_container, container, false);
        mViewsListView = (ListView) view.findViewById(R.id.list_view_views);

        mContainerListAdapter = new ContainerListAdapter(getContext(), mContainerListItems);
        mViewsListView.setAdapter(mContainerListAdapter);

        return view;
    }

    private void populateContainerListItems() {
        mContainerListItems.add(new ContainerListItem("View Layouts", true));
        mContainerListItems.add(new ContainerListItem("Linear Layout"));
        mContainerListItems.add(new ContainerListItem("Relative Layout"));
        mContainerListItems.add(new ContainerListItem("Percent Relative Layout"));
        mContainerListItems.add(new ContainerListItem("Frame Layout"));
        mContainerListItems.add(new ContainerListItem("ScrollView"));
        mContainerListItems.add(new ContainerListItem("Views", true));
        mContainerListItems.add(new ContainerListItem("TextView"));
        mContainerListItems.add(new ContainerListItem("EditText"));
        mContainerListItems.add(new ContainerListItem("Button"));
        mContainerListItems.add(new ContainerListItem("ImageView"));
        mContainerListItems.add(new ContainerListItem("Spinner"));
        mContainerListItems.add(new ContainerListItem("WebView"));
        mContainerListItems.add(new ContainerListItem("Data Binding", true));
        mContainerListItems.add(new ContainerListItem("Binding Views"));
    }
}
