package com.boolea.oaxaca.ui.base;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.single.BasePermissionListener;

import java.util.Locale;
import java.util.Objects;

/**
 * Created by oscar on 26/05/19
 * operez@na-at.com.mx
 */
public class BaseFragmentLocation extends BaseFragment {


    private LocationRequest mLocationRequest;
    private LocationCallback mLocationCallBack;
    private FusedLocationProviderClient mFusedLocationClient;
    protected Location mCurrentLocation;
    public static final int INTERVAL = 30000;


    @Override
    public void onStart() {
        super.onStart();

        Dexter.withActivity(getActivity())
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new BasePermissionListener() {

                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        super.onPermissionGranted(response);
                        initFusedLocationClient();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        super.onPermissionDenied(response);
                        showToast("Es necesario aceptar el permiso de ubicación");
                    }
                }).check();

        initFusedLocationClient();
    }

    private void initFusedLocationClient() {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(Objects.requireNonNull(getContext()));
        try {
            mLocationRequest = LocationRequest.create();
            mLocationRequest.setInterval(INTERVAL);
            mLocationRequest.setFastestInterval(INTERVAL / 2);
            mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

            mLocationCallBack = new LocationCallback() {
                @Override
                public void onLocationResult(LocationResult locationResult) {
                    mCurrentLocation = locationResult.getLastLocation();
                    stopLocationUpdates();
                    super.onLocationResult(locationResult);
                }

                @Override
                public void onLocationAvailability(LocationAvailability locationAvailability) {
                    super.onLocationAvailability(locationAvailability);
                }
            };

            LocationServices.getFusedLocationProviderClient(getContext())
                    .requestLocationUpdates(mLocationRequest, mLocationCallBack, null);

        } catch (SecurityException ex) {
            ex.printStackTrace();
        }

    }

    private void stopLocationUpdates() {
        if (mFusedLocationClient != null)
            mFusedLocationClient.removeLocationUpdates(mLocationCallBack);
        mFusedLocationClient = null;
        mLocationRequest = null;
    }


    protected void intentShowDirections(float sourceLatitude, float sourceLongitude, float destinationLatitude, float destinationLongitude, String placeName) {
        String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?saddr=%f,%f(%s)&daddr=%f,%f (%s)", sourceLatitude, sourceLongitude, "Tu ubicación", destinationLatitude, destinationLongitude, placeName);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }


}
