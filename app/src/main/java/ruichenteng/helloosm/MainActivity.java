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
import com.mapbox.mapboxsdk.overlay.Icon;
import com.mapbox.mapboxsdk.overlay.Marker;
import com.mapbox.mapboxsdk.overlay.UserLocationOverlay;
import com.mapbox.mapboxsdk.views.MapView;
import com.mapbox.mapboxsdk.views.util.TilesLoadedListener;

//import com.crashlytics.android.Crashlytics;


public class MainActivity extends ActionBarActivity {
    private TextView tv;
    private MapView mv;
    private UserLocationOverlay myLocationOverlay;
    private String currentMap = "Current Map";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //Crashlytics.start(this);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        if(tv == null) {
            Log.i("TextView:", "TextView is null");
        }
        mv = (MapView) findViewById(R.id.mapView);
        if(mv==null) {
            Log.i("MapView:", "MapView is null");
        }
        if(2==2){
            mv.setMinZoomLevel(mv.getTileProvider().getMinimumZoomLevel());
            mv.setMaxZoomLevel(mv.getTileProvider().getMaximumZoomLevel());
            mv.setCenter(mv.getTileProvider().getCenterCoordinate());
            mv.setZoom(0);
            currentMap = "Current Map";

            // Show user location (purposely not in follow mode)
            mv.setUserLocationEnabled(true);

            mv.loadFromGeoJSONURL("https://gist.githubusercontent.com/tmcw/10307131/raw/21c0a20312a2833afeee3b46028c3ed0e9756d4c/map.geojson");
//        setButtonListeners();
            Marker m = new Marker(mv, "Edinburgh", "Scotland", new LatLng(55.94629, -3.20777));
            m.setIcon(new Icon(this, Icon.Size.SMALL, "marker-stroked", "FF0000"));
            mv.addMarker(m);

            m = new Marker(mv, "Stockholm", "Sweden", new LatLng(59.32995, 18.06461));
            m.setIcon(new Icon(this, Icon.Size.MEDIUM, "city", "FFFF00"));
            mv.addMarker(m);

            m = new Marker(mv, "Prague", "Czech Republic", new LatLng(50.08734, 14.42112));
            m.setIcon(new Icon(this, Icon.Size.LARGE, "land-use", "00FFFF"));
            mv.addMarker(m);

            m = new Marker(mv, "Prague2", "Czech Republic", new LatLng(50.0875, 14.42112));
            m.setIcon(new Icon(getBaseContext(), Icon.Size.LARGE, "land-use", "00FF00"));
            mv.addMarker(m);

            m = new Marker(mv, "Athens", "Greece", new LatLng(37.97885, 23.71399));
            mv.addMarker(m);

            mv.setOnTilesLoadedListener(new TilesLoadedListener() {
                @Override
                public boolean onTilesLoaded() {
                    return false;
                }

                @Override
                public boolean onTilesLoadStarted() {
                    // TODO Auto-generated method stub
                    return false;
                }
            });
        }

    }

}