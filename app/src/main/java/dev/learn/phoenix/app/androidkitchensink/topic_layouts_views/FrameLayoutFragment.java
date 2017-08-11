package dev.learn.phoenix.app.androidkitchensink.topic_layouts_views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import dev.learn.phoenix.app.androidkitchensink.R;

/**
 * Created by sudharti on 7/27/17.
 */

public class FrameLayoutFragment extends Fragment implements OnMapReadyCallback {

    private RelativeLayout mBottomRelativeLayout;
    private MapView mMapView;
    private CameraPosition mCameraPosition;

    private static final float LAT = 40.729f;
    private static final float LONG = -73.9f;
    private static final float TILT = 10f;
    private static final float ZOOM = 12f;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCameraPosition = CameraPosition.builder()
                .target(new LatLng(LAT, LONG))
                .tilt(TILT)
                .zoom(ZOOM)
                .build();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frame_layout, container, false);
        mMapView = (MapView) view.findViewById(R.id.map_view);
        mBottomRelativeLayout = (RelativeLayout) view.findViewById(R.id.bottom_relative_layout);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMapView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mMapView.onCreate(savedInstanceState);
                MapsInitializer.initialize(getActivity().getApplicationContext());
                mMapView.getMapAsync(FrameLayoutFragment.this);
                mMapView.onResume();
            }
        }, 300);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(mCameraPosition));
    }
}
