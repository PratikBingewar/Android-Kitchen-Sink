package dev.learn.phoenix.app.androidkitchensink.shared;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import dev.learn.phoenix.app.androidkitchensink.R;
import dev.learn.phoenix.app.androidkitchensink.common.Section;

/**
 * Created by sudharti on 7/31/17.
 */
public class TopicFragment extends Fragment {

	private static final String SECTIONS = "SECTIONS";

	private ViewPager mViewPager;
	private List<Section> mSectionsList;
	private TopicViewPagerAdapter mViewPagerAdapter;

	public static TopicFragment newInstance(List<Section> sectionsList) {
		TopicFragment topicFragment = new TopicFragment();

		Bundle args = new Bundle();
		args.putSerializable(SECTIONS, (Serializable) sectionsList);
		topicFragment.setArguments(args);

		return topicFragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.mSectionsList = (List<Section>) getArguments().getSerializable(SECTIONS);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_container, container, false);
		mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mViewPagerAdapter = new TopicViewPagerAdapter(getChildFragmentManager(), mSectionsList);
		mViewPager.setAdapter(mViewPagerAdapter);
	}
}
