package dev.learn.phoenix.app.androidkitchensink.shared;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.Map;

/**
 * Created by sudharti on 8/2/17.
 */

public class ContainerViewPagerAdapter extends FragmentPagerAdapter {

    private Map<String, List<ContainerListItem>> mSectionsMap;

    public ContainerViewPagerAdapter(FragmentManager fragmentManager, Map<String, List<ContainerListItem>> sectionsMap) {
        super(fragmentManager);
        this.mSectionsMap = sectionsMap;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return mSectionsMap.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
