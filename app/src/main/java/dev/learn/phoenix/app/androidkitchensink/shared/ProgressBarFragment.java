package dev.learn.phoenix.app.androidkitchensink.shared;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.learn.phoenix.app.androidkitchensink.R;

/**
 * Created by sudharti on 8/7/17.
 */

public class ProgressBarFragment extends Fragment {

    private static final ProgressBarFragment mProgressBarFragment = new ProgressBarFragment();

    public static ProgressBarFragment getInstance() {
        return mProgressBarFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_progress_bar, container, false);
    }
}
