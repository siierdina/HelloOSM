/**
 * @author Brad Leege <bleege@gmail.com>
 * Created on 2/23/14 at 11:36 AM
 */

package ruichenteng.helloosm;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.tileprovider.tilesource.WebSourceTileLayer;
import com.mapbox.mapboxsdk.views.MapView;

public class MainActivity extends ActionBarActivity {
    private TextView tv;
    private MapView mv;
    private WebSourceTileLayer ws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        mv = (MapView) findViewById(R.id.mapView);
        mv.setUserLocationEnabled(true);
        mv.loadFromGeoJSONURL("https://raw.githubusercontent.com/tengr/HelloOSM/master/MelbourneCBD.geojson");
        //setUpWebServiceIfNeeded();
        LatLng mLatLng = mv.getUserLocation();
        mv.setZoom(14);
        mv.setCenter(mLatLng);
        Log.i("***************************MY Location ***********************************","");
        Log.i("My Location ", mLatLng.toString());
        tv.setText("My Location is : " + mLatLng.toString());

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpWebServiceIfNeeded();
    }

    /**
     *Set up web service to download Open Street Map data
     */
    private void setUpWebServiceIfNeeded(){
        if(ws == null) {
            ws = new WebSourceTileLayer("openstreetmap", "http://tile.openstreetmap.org/{z}/{x}/{y}.png");
            ws.setName("OpenStreetMap")
                    .setAttribution("© OpenStreetMap Contributors")
                    .setMinimumZoomLevel(1)
                    .setMaximumZoomLevel(18);
            mv.setTileSource(ws);
        }
    }
}