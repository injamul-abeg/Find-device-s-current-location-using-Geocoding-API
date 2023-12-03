package com.example.Find_Device_Location;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class AddressLatLong {
    public static String getAddressFromCoordinates(Context context, double latitude, double longitude) {
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        String addressText = "";

        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);

            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);

                // Build the address text from address components
                for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
                    addressText += address.getAddressLine(i);
                    if (i < address.getMaxAddressLineIndex()) {
                        addressText += ", ";
                        Log.e(TAG, "getAddressFromCoordinates: "+addressText);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return addressText;
    }

}
