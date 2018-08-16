package com.ridvan.lovenue.activities;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.ridvan.lovenue.R;
import com.ridvan.lovenue.adapter.VenueRecyclerViewAdapter;
import com.ridvan.lovenue.databinding.ActivityMainBinding;
import com.ridvan.lovenue.listener.RecyclerViewClickListener;
import com.ridvan.lovenue.viewmodels.RelevantVenuesViewModel;

import static com.ridvan.lovenue.constants.LovenueConstants.LOCATION_KEY;
import static com.ridvan.lovenue.constants.LovenueConstants.MY_PERMISSIONS_REQUEST_LOCATION;

public class MainActivity extends AppCompatActivity {

    private Location lastLocation;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationCallback locationCallback;

    ActivityMainBinding binding;
    RelevantVenuesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(RelevantVenuesViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        this.bindViewElements();
        this.updateValuesFromBundle(savedInstanceState);
        this.startLocationUpdates();
    }

    private void bindViewElements() {
        final FloatingActionButton fab = binding.fab;

        // preferred recycler view
        VenueRecyclerViewAdapter adapter = new VenueRecyclerViewAdapter(viewModel.getItemsList().getValue(), new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                //TODO: Detail activity
            }
        });
        binding.venueRecyclerView.setAdapter(adapter);
        binding.venueRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // hide fab when scrolling
        binding.venueRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0)
                    fab.hide();
                else if (dy < 0)
                    fab.show();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Search activity
            }
        });
    }

    private void updateValuesFromBundle(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return;
        }
        // Update the value of location from the Bundle.
        if (savedInstanceState.keySet().contains(LOCATION_KEY)) {
            lastLocation = savedInstanceState.getParcelable(LOCATION_KEY);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(LOCATION_KEY, lastLocation);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startLocationUpdates();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.stopLocationUpdates();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.stopLocationUpdates();
    }

    protected void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                showAlertDialog(getString(R.string.permission_location_description));
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
        } else {
            if (locationCallback == null) {
                locationCallback = new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        onLocationUpdate(locationResult.getLastLocation());
                    }
                };
            }

            getFusedLocationProviderClient()
                    .requestLocationUpdates(
                            getLocationRequest(),
                            locationCallback,
                            Looper.getMainLooper());
        }

    }

    protected void stopLocationUpdates() {
        if (locationCallback != null) {
            getFusedLocationProviderClient().removeLocationUpdates(locationCallback);
            locationCallback = null;
        }
    }

    private FusedLocationProviderClient getFusedLocationProviderClient() {
        if (fusedLocationProviderClient == null) {
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        }
        return fusedLocationProviderClient;
    }

    protected void onLocationUpdate(Location location) {
        this.lastLocation = location;

        if (lastLocation != null) {
            //TODO post for new list
        }
    }

    protected LocationRequest getLocationRequest() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        locationRequest.setInterval(300000);
        locationRequest.setMaxWaitTime(900000);
        locationRequest.setNumUpdates(Integer.MAX_VALUE);
        return locationRequest;
    }

    private void showAlertDialog(String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setCancelable(true)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(final DialogInterface dialog, final int id) {
                dialog.cancel();
            }
        });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startLocationUpdates();
                } else {
                    stopLocationUpdates();
                }
            }
        }
    }
}
