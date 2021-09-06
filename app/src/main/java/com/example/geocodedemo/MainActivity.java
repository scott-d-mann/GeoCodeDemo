package com.example.geocodedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Geocoder geocoder;
    private List<Address> revGeoAddresses;
    private List<Address> geoAddresses;

    // Latrobe University
    private Double latitude = -37.720627;
    private Double longitude = 145.045647;

    String locationName = "La Trobe University, Bundoora VIC 3086";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Geocoder object to access API
        geocoder = new Geocoder(this);

        //********* Get address from Latitude Longitude (Reverse Geocode) **********
        try {
            revGeoAddresses = geocoder.getFromLocation(latitude, longitude, 5);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Address a : revGeoAddresses) {
            Log.d("RevAddress", "Address: " + a.toString());
            //to see full list of data you can ghet from the address object see https://developer.android.com/reference/android/location/Address
        }

        //********* Get Latitude Longitude from Address (Geocode) **********
        try {
            geoAddresses = geocoder.getFromLocationName(locationName, 2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Address b : revGeoAddresses) {
            Log.d("GeoAddress", "Latitude: " + b.getLatitude() + " Longitude: " + b.getLongitude() + " Feature Name: " + b.getFeatureName());
            //to see full list of data you can ghet from the address object see https://developer.android.com/reference/android/location/Address
        }
    }
}