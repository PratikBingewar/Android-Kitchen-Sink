package dev.learn.phoenix.app.androidkitchensink.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import dev.learn.phoenix.app.androidkitchensink.R;
import dev.learn.phoenix.app.androidkitchensink.base.views.AnimatedActionBarDrawerToggle;
import dev.learn.phoenix.app.androidkitchensink.shared.ProgressBarFragment;
import dev.learn.phoenix.app.androidkitchensink.util.MetaDataUtil;


/**
 * Created by sudhar on 7/25/17.
 */
public class NavDrawerFragment extends Fragment {

    private View mDrawerFragment;
    private ListView mNavDrawerListView;
    private DrawerLayout mDrawerLayout;

    private AnimatedActionBarDrawerToggle mActionBarToggle;

    private String[] mNavDrawerArray;
    private ArrayAdapter<String> mNavDrawerAdapter;
    private NavDrawerCallbacks mNavDrawerCallbacks;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mNavDrawerCallbacks = (NavDrawerCallbacks) getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNavDrawerArray = MetaDataUtil.getInstance().getTopics();
        mNavDrawerAdapter = new ArrayAdapter<>(getContext(), R.layout.item_nav_drawer_list, mNavDrawerArray);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mNavDrawerListView = (ListView) inflater.inflate(R.layout.fragment_nav_drawer, container, false);
        mNavDrawerListView.setAdapter(mNavDrawerAdapter);
        mNavDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectItem(i);
            }
        });
        return mNavDrawerListView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mNavDrawerCallbacks = null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mActionBarToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setUp(int navDrawerFragmentId, DrawerLayout drawerLayout) {
        this.mDrawerLayout = drawerLayout;
        this.mDrawerFragment = getActivity().findViewById(navDrawerFragmentId);

        mActionBarToggle = new AnimatedActionBarDrawerToggle(getActivity(), mDrawerLayout,
                R.string.nav_drawer_open, R.string.nav_drawer_close);
        mActionBarToggle.syncState();
        mDrawerLayout.addDrawerListener(mActionBarToggle);

        ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeButtonEnabled(true);

        selectItem(0);
    }

    private void selectItem(final int position) {
        if (mNavDrawerCallbacks != null) {
            getFragmentManager().beginTransaction().replace(R.id.frame_main_content, ProgressBarFragment.getInstance()).commit();
            if (isDrawerOpen()) closeDrawer();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mNavDrawerCallbacks.onNavDrawerListItemClicked(position);
                }
            }, 200);
            mNavDrawerListView.setItemChecked(position, true);
        }
    }

    private boolean isDrawerOpen() {
        return mDrawerLayout.isDrawerOpen(mDrawerFragment);
    }

    private void closeDrawer() {
        mDrawerLayout.closeDrawer(mDrawerFragment);
    }

    public void toggleMenu(boolean enabled) {
        if (enabled) {
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);
            mActionBarToggle.animateToMenu();
        } else {
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            mActionBarToggle.animateToBackArrow();
        }
    }

    public interface NavDrawerCallbacks {
        public void onNavDrawerListItemClicked(int position);
    }
}
