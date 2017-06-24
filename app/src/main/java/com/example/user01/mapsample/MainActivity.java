package com.example.user01.mapsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mMapView;
    private GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMapView = (MapView) findViewById(R.id.lite_map);
        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.setClickable(false);
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getApplicationContext());
        mGoogleMap = googleMap;
        mGoogleMap.getUiSettings().setMapToolbarEnabled(false);
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(59.330650, 18.067360), 13f));
        mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(59.330650, 18.067360)).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher_round)));

        // Set the map type back to normal.
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
   }
}
