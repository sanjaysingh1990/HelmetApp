
package helmet.init.user.helmetapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

public class LocateActivity extends AppCompatActivity {

    TextView locateMap;
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_locate);

        locateMap = (TextView) findViewById(R.id.locate);

        Typeface descfont = Typeface.createFromAsset(getAssets(), "fonts/gillsans.ttf");
        locateMap.setTypeface(descfont);


        try {
            // Loading map
            initilizeMap();

            double latitude =  30.361;
            double longitude =   76.8485;

            // googleMap.setMyLocationEnabled(true);
// create marker
            MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Ambala Cantt ");

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
}
