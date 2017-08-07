package dev.learn.phoenix.app.androidkitchensink.base;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import java.util.List;

import dev.learn.phoenix.app.androidkitchensink.R;
import dev.learn.phoenix.app.androidkitchensink.base.NavDrawerFragment.NavDrawerCallbacks;
import dev.learn.phoenix.app.androidkitchensink.common.Section;
import dev.learn.phoenix.app.androidkitchensink.shared.TopicFragment;
import dev.learn.phoenix.app.androidkitchensink.util.MetaDataUtil;

public class MainActivity extends AppCompatActivity implements NavDrawerCallbacks, FragmentManager.OnBackStackChangedListener {

    private DrawerLayout mDrawerLayout;
    private FrameLayout mFrameLayout;

    private NavDrawerFragment mNavDrawerFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_base);
        mFrameLayout = (FrameLayout) findViewById(R.id.frame_main_content);

        mNavDrawerFragment = (NavDrawerFragment) mFragmentManager.findFragmentById(R.id.fragment_nav_drawer);
        mNavDrawerFragment.setUp(R.id.fragment_nav_drawer, mDrawerLayout);

        mFragmentManager.addOnBackStackChangedListener(this);

        getSupportActionBar().setElevation(0);
    }

    @Override
    public void onNavDrawerListItemClicked(int position) {
        List<Section> sectionList = MetaDataUtil.getInstance().getSections(position);
        if (sectionList != null) {
            TopicFragment topicFragment = TopicFragment.newInstance(sectionList);
            mFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_main_content, topicFragment)
                    .commit();
        }
    }


    @Override
    public void onBackStackChanged() {
        mNavDrawerFragment.toggleMenu((mFragmentManager.getBackStackEntryCount() == 0));
    }
}
