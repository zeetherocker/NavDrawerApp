package com.zeeshan.navdrawerapp;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Locate_us extends ActionBarActivity {

    private final LatLng LOCATION_MVIT = new LatLng(13.151043, 77.609890);
    private final LatLng LOCATION_SCIENCE = new LatLng(13.150812, 77.609026);
    private final LatLng LOCATION_NB = new LatLng(13.150893, 77.610195);
    private final LatLng LOCATION_NA = new LatLng(13.151428, 77.607093);
    private final LatLng LOCATION_LIB = new LatLng(13.151283, 77.608933);
    private final LatLng LOCATION_PL = new LatLng(13.150273, 77.609734);
    private final LatLng LOCATION_CS = new LatLng(13.151042, 77.608881);
    private final LatLng LOCATION_CA = new LatLng(13.149867, 77.610226);
    private final LatLng LOCATION_ME = new LatLng(13.150604, 77.608400);
    private final LatLng LOCATION_CB = new LatLng(13.150856, 77.608690);
    private final float LOCATION_ANGLE = 270;
    private final float LOCATION_ZOOM = 18;
    private final float LOCATION_TILT = 60;
    private static int layout_type = 1;


    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locate_us);
        setUpMapIfNeeded();


        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    public static void getLayout(CheckBox cb) {
        if (cb.isChecked())
            layout_type = 1;
        else if (!cb.isChecked())
            layout_type = 0;
    }

    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(LOCATION_MVIT).title("MVIT"));
        mMap.addMarker(new MarkerOptions().position(LOCATION_SCIENCE).title("Science Block"));
        mMap.addMarker(new MarkerOptions().position(LOCATION_NB).title("New Block (EC,CS,IS,TC)"));
        mMap.addMarker(new MarkerOptions().position(LOCATION_NA).title("Auditorium"));
        mMap.addMarker(new MarkerOptions().position(LOCATION_PL).title("Parking Lot"));
        mMap.addMarker(new MarkerOptions().position(LOCATION_CS).title("Coffee Shop"));
        mMap.addMarker(new MarkerOptions().position(LOCATION_CA).title("Canteen"));
        mMap.addMarker(new MarkerOptions().position(LOCATION_ME).title("Mechanical Block"));
        mMap.addMarker(new MarkerOptions().position(LOCATION_CB).title("Civil and EEE Block"));
        mMap.addMarker(new MarkerOptions().position(LOCATION_LIB).title("Library"));
        CameraPosition pos = new CameraPosition(LOCATION_MVIT, LOCATION_ZOOM, LOCATION_TILT, LOCATION_ANGLE);
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(pos);
        mMap.animateCamera(update);
        if (layout_type == 1)
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        else if (layout_type == 0)
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setMyLocationEnabled(true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        if(id==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
