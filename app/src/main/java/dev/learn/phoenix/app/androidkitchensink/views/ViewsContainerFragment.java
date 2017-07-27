package dev.learn.phoenix.app.androidkitchensink.views;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import dev.learn.phoenix.app.androidkitchensink.R;

/**
 * Created by sudharti on 7/26/17.
 */

public class ViewsContainerFragment extends Fragment {

    private ListView mViewsListView;

    public static ViewsContainerFragment newInstance() {
        Bundle args = new Bundle();
        ViewsContainerFragment fragment = new ViewsContainerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.views_fragment_container, container, false);
        mViewsListView = (ListView) view.findViewById(R.id.list_view_views);
        return view;
    }
}
