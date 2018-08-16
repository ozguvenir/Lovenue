package com.ridvan.lovenue.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ridvan.lovenue.R;
import com.ridvan.lovenue.databinding.ActivityVenueDetailBinding;
import com.ridvan.lovenue.viewmodels.VenueDetailViewModel;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class VenueDetailActivity extends AppCompatActivity {

    ActivityVenueDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_venue_detail);

        final VenueDetailViewModel venueDetailViewModel = ViewModelProviders.of(this).get(VenueDetailViewModel.class);
        binding.setDetailViewModel(venueDetailViewModel);
        binding.setLifecycleOwner(this);
    }
}
