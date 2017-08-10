package dev.learn.phoenix.app.androidkitchensink.topic_layouts_views;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.SupportMapFragment;

import dev.learn.phoenix.app.androidkitchensink.R;

/**
 * Created by sudharti on 7/27/17.
 */

public class FrameLayoutFragment extends Fragment {

    private RelativeLayout mBottomRelativeLayout;
    private FragmentManager mChildFragmentManager;
    private SupportMapFragment mSupportMapFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mChildFragmentManager = getChildFragmentManager();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frame_layout, container, false);
        mBottomRelativeLayout = (RelativeLayout) view.findViewById(R.id.bottom_relative_layout);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSupportMapFragment = (SupportMapFragment) mChildFragmentManager.findFragmentById(R.id.map_container);
                if (mSupportMapFragment == null) {
                    mSupportMapFragment = SupportMapFragment.newInstance();
                }

                mChildFragmentManager.beginTransaction().replace(R.id.map_container, mSupportMapFragment).commit();
                mBottomRelativeLayout.setVisibility(View.VISIBLE);
            }
        }, 200);
    }
}
