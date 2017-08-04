package dev.learn.phoenix.app.androidkitchensink.shared;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import dev.learn.phoenix.app.androidkitchensink.R;
import dev.learn.phoenix.app.androidkitchensink.common.Section;

/**
 * Created by sudharti on 8/3/17.
 */

public class SectionFragment extends Fragment {
    private Section mSection;
    private ListView mListView;

    public static SectionFragment newInstance(Section section) {
        SectionFragment sectionFragment = new SectionFragment();
        sectionFragment.mSection = section;
        return sectionFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mListView = (ListView) inflater.inflate(R.layout.fragment_section, container, false);
        return mListView;
    }
}
