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
import com.mapbox.mapboxsdk.overlay.UserLocationOverlay;
import com.mapbox.mapboxsdk.views.MapView;

public class MainActivity extends ActionBarActivity {
    private TextView tv;
    private MapView mv;
    private UserLocationOverlay myLocationOverlay;
    private String currentMap = "Current Map";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        mv = (MapView) findViewById(R.id.mapView);

        mv.setMinZoomLevel(mv.getTileProvider().getMinimumZoomLevel());
        mv.setMaxZoomLevel(mv.getTileProvider().getMaximumZoomLevel());
        mv.setCenter(mv.getTileProvider().getCenterCoordinate());
        mv.setZoom(0);
        currentMap = "Current Map";
        // Show user location (purposely not in follow mode)
        mv.setUserLocationEnabled(true);
        LatLng mLatLng = mv.getUserLocation();
        Log.i("***************************MY Location ***********************************","");
        Log.i("My Location ", mLatLng.toString());
        mv.setUserLocationTrackingMode(UserLocationOverlay.TrackingMode.FOLLOW);
        mv.setUserLocationRequiredZoom(12);
        tv.setText(mLatLng.toString());
    }
}