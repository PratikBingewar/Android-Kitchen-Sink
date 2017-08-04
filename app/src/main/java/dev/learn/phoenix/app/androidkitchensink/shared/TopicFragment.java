package dev.learn.phoenix.app.androidkitchensink.shared;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Map;

import dev.learn.phoenix.app.androidkitchensink.R;
import dev.learn.phoenix.app.androidkitchensink.common.Section;

/**
 * Created by sudharti on 7/31/17.
 */
public class TopicFragment extends Fragment {

    private ViewPager mViewPager;
    private Map<Integer, Section> mSectionsMap;
    private TopicViewPagerAdapter mViewPagerAdapter;

    public static TopicFragment newInstance(Map<Integer, Section> sectionsMap) {
        TopicFragment topicFragment = new TopicFragment();
        topicFragment.mSectionsMap = sectionsMap;
        return topicFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_container, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mViewPagerAdapter = new TopicViewPagerAdapter(getFragmentManager(), mSectionsMap);
        mViewPager.setAdapter(mViewPagerAdapter);
        return view;
    }
}
