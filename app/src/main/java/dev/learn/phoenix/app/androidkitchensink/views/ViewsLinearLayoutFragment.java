package dev.learn.phoenix.app.androidkitchensink.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.learn.phoenix.app.androidkitchensink.R;

/**
 * Created by sudharti on 7/26/17.
 */
public class ViewsLinearLayoutFragment extends Fragment {

    public static ViewsLinearLayoutFragment newInstance() {
        return new ViewsLinearLayoutFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.views_fragment_linear_layout, container, false);
        return view;
    }
}
