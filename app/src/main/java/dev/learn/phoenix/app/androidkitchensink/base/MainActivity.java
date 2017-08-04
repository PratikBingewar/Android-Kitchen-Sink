package dev.learn.phoenix.app.androidkitchensink.base;

import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import java.util.Map;

import dev.learn.phoenix.app.androidkitchensink.R;
import dev.learn.phoenix.app.androidkitchensink.base.NavDrawerFragment.NavDrawerCallbacks;
import dev.learn.phoenix.app.androidkitchensink.common.MetaData;
import dev.learn.phoenix.app.androidkitchensink.common.Section;
import dev.learn.phoenix.app.androidkitchensink.shared.ContainerFragment;

public class MainActivity extends AppCompatActivity implements NavDrawerCallbacks {

    private DrawerLayout mDrawerLayout;
    private FrameLayout mFrameMainContent;

    private NavDrawerFragment mNavDrawerFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_base);
        mFrameMainContent = (FrameLayout) findViewById(R.id.frame_main_content);

        mNavDrawerFragment = (NavDrawerFragment) mFragmentManager.findFragmentById(R.id.fragment_nav_drawer);
        mNavDrawerFragment.setUp(R.id.fragment_nav_drawer, mDrawerLayout);
    }

    @Override
    public void onNavDrawerListItemClicked(int position) {
        Map<Integer, Section> sectionsMap = MetaData.getInstance().getSectionsMap(position);
        if (sectionsMap != null) {
            ContainerFragment containerFragment = ContainerFragment.newInstance(sectionsMap);
            mFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_main_content, containerFragment)
                    .commit();
        }
    }
}
