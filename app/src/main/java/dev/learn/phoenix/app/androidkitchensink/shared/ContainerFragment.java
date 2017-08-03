package dev.learn.phoenix.app.androidkitchensink.shared;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Map;

import dev.learn.phoenix.app.androidkitchensink.R;

/**
 * Created by sudharti on 7/31/17.
 */
public class ContainerFragment extends Fragment {

    private ViewPager mViewPager;
    private Map<String, List<ContainerListItem>> mTopicMap;

    public static ContainerFragment newInstance(Map<String, List<ContainerListItem>> topicMap) {
        ContainerFragment containerFragment = new ContainerFragment();
        containerFragment.mTopicMap = topicMap;
        return containerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_container, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        return view;
    }
}
