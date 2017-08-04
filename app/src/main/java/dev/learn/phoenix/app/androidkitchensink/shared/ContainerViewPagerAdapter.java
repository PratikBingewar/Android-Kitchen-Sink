package dev.learn.phoenix.app.androidkitchensink.shared;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.Map;

import dev.learn.phoenix.app.androidkitchensink.common.Section;

/**
 * Created by sudharti on 8/2/17.
 */

public class ContainerViewPagerAdapter extends FragmentPagerAdapter {

    private Map<Integer, Section> mSectionsMap;

    public ContainerViewPagerAdapter(FragmentManager fragmentManager, Map<Integer, Section> sectionsMap) {
        super(fragmentManager);
        this.mSectionsMap = sectionsMap;
    }

    @Override
    public Fragment getItem(int position) {
        SectionFragment sectionFragment = SectionFragment.newInstance(getSection(position));
        return sectionFragment;
    }

    @Override
    public int getCount() {
        return mSectionsMap.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Section section = getSection(position);
        if (section != null) {
            return section.getTitle();
        }

        return "";
    }

    private Section getSection(int position) {
        if (mSectionsMap != null && mSectionsMap.containsKey(position)) {
            return mSectionsMap.get(position);
        }
        return null;
    }
}
