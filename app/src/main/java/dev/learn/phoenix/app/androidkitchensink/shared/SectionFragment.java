package dev.learn.phoenix.app.androidkitchensink.shared;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.List;

import dev.learn.phoenix.app.androidkitchensink.R;
import dev.learn.phoenix.app.androidkitchensink.common.FeatureListItem;
import dev.learn.phoenix.app.androidkitchensink.common.Section;

/**
 * Created by sudharti on 8/3/17.
 */

public class SectionFragment extends Fragment implements AdapterView.OnItemClickListener {

    private static final String SECTION = "SECTION";
    private static final String TAG = SectionFragment.class.getSimpleName();

    private ListView mListView;

    private Section mSection;
    private List<FeatureListItem> mFeatureListItems;
    private SectionListAdapter mSectionListAdapter;

    public static SectionFragment newInstance(Section section) {
        SectionFragment sectionFragment = new SectionFragment();

        Bundle args = new Bundle();
        args.putSerializable(SECTION, (Serializable) section);
        sectionFragment.setArguments(args);

        return sectionFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mSection = (Section) getArguments().getSerializable(SECTION);
        this.mFeatureListItems = mSection.getSectionListItems();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mListView = (ListView) inflater.inflate(R.layout.fragment_section, container, false);
        mListView.setOnItemClickListener(this);
        return mListView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSectionListAdapter = new SectionListAdapter(getContext(), this.mFeatureListItems);
    }

    @Override
    public void onResume() {
        super.onResume();
        mListView.setAdapter(mSectionListAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        FeatureListItem featureListItem = mFeatureListItems.get(i);
        Class clazz = featureListItem.getClazz();
        try {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_main_content, (Fragment) clazz.newInstance())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(null).commit();
        } catch (java.lang.InstantiationException | IllegalAccessException e) {
            Log.e(TAG, e.getMessage());
        }
    }
}
