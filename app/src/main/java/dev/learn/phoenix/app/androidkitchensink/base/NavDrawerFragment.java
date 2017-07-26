package dev.learn.phoenix.app.androidkitchensink.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import dev.learn.phoenix.app.androidkitchensink.R;

/**
 * Created by sudhar on 7/25/17.
 */
public class NavDrawerFragment extends Fragment {

	private View mDrawerFragment;
	private ListView mNavDrawerListView;
	private DrawerLayout mDrawerLayout;

	private List<String> mNavDrawerList;
	private NavDrawerAdapter mNavDrawerAdapter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mNavDrawerListView = (ListView) inflater.inflate(R.layout.base_fragment_nav_drawer, container, false);
		return mNavDrawerListView;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	public void setUp(int navDrawerFragmentId, DrawerLayout drawerLayout) {
		this.mDrawerLayout = drawerLayout;
		this.mDrawerFragment = getActivity().findViewById(navDrawerFragmentId);
	}
}
