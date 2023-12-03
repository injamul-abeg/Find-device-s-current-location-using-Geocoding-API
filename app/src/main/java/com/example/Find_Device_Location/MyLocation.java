package com.example.Find_Device_Location;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import androidx.core.app.ActivityCompat;


public class MyLocation {

    private double longVal = 0.0;
    private double latVal = 0.0;


    public MyLocation(Context context) {

        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        // String provider = ;
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location loc = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, true));


        longVal = loc.getLongitude();
        latVal = loc.getLatitude();

        final LocationListener locationListener = location1 -> {
            longVal = location1.getLongitude();
            latVal = location1.getLatitude();
        };
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);
        String location = AddressLatLong.getAddressFromCoordinates(context, latVal, longVal);
    }

    public double getLongVal() {
        return longVal;
    }

    public double getLatVal() {
        return latVal;
    }
}
