package helmet.init.user.helmetapp;

import android.content.Context;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

public class MapDemo extends AppCompatActivity implements LocationListener {


    private GoogleMap googleMap;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    double latitude,longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_demo);


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);


        try {
            // Loading map
            initilizeMap();

            double latitude =  30.361;
            double longitude =   76.8485;


            // googleMap.setMyLocationEnabled(true);
// create marker
            MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Ambala ");

// adding marker
            googleMap.addMarker(marker);

        } catch (Exception e) {
            e.printStackTrace();
        }

 }

    private void initilizeMap() {

        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();

            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();

                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);




            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.e("lat and long",location.getLatitude()+"  "+location.getLongitude()+"");

        latitude=location.getLatitude();
        longitude=location.getLongitude();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Log.d("Latitude","status");
    }

    @Override
    public void onProviderEnabled(String s) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.d("Latitude","disable");

    }
}
