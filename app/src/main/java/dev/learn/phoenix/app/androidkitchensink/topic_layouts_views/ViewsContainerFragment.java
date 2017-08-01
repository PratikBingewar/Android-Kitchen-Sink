package dev.learn.phoenix.app.androidkitchensink.topic_layouts_views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.learn.phoenix.app.androidkitchensink.R;
import dev.learn.phoenix.app.androidkitchensink.shared.ContainerListAdapter;
import dev.learn.phoenix.app.androidkitchensink.shared.ContainerListHeading;
import dev.learn.phoenix.app.androidkitchensink.shared.ContainerListItem;

/**
 * Created by sudharti on 7/26/17.
 */
public class ViewsContainerFragment extends Fragment {

    private static final String TAG = ViewsContainerFragment.class.getSimpleName();

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
        View view = inflater.inflate(R.layout.fragment_container, container, false);
        mContainerListAdapter = new ContainerListAdapter(getContext(), mContainerListItems);
        return view;
    }

    /*@Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ContainerListItem containerListItem = mContainerListItems.get(i);
        Class clazz = containerListItem.getClazz();
        if (!containerListItem.isHeading() && clazz != null) {
            try {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_main_content, (Fragment) clazz.newInstance())
                        .addToBackStack(containerListItem.getText()).commit();
            } catch (java.lang.InstantiationException | IllegalAccessException | ClassCastException e) {
                Log.e(TAG, e.getMessage());
            }
        }
    }*/

    private void populateContainerListItems() {
        mContainerListItems.add(new ContainerListHeading("View Layouts"));
        mContainerListItems.add(new ContainerListItem("Linear Layout", LinearLayoutFragment.class));
        mContainerListItems.add(new ContainerListItem("Relative Layout", RelativeLayoutFragment.class));
        mContainerListItems.add(new ContainerListItem("Percent Relative Layout", null));
        mContainerListItems.add(new ContainerListItem("Frame Layout", null));
        mContainerListItems.add(new ContainerListItem("ScrollView", null));
        mContainerListItems.add(new ContainerListHeading("Views"));
        mContainerListItems.add(new ContainerListItem("TextView", null));
        mContainerListItems.add(new ContainerListItem("EditText", null));
        mContainerListItems.add(new ContainerListItem("Button", null));
        mContainerListItems.add(new ContainerListItem("ImageView", null));
        mContainerListItems.add(new ContainerListItem("Spinner", null));
        mContainerListItems.add(new ContainerListItem("WebView", null));
        mContainerListItems.add(new ContainerListHeading("Data Binding"));
        mContainerListItems.add(new ContainerListItem("Binding Views", null));
    }
}
