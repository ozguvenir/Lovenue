package com.ridvan.lovenue.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;

import com.ridvan.lovenue.R;
import com.ridvan.lovenue.constants.LovenueConstants;
import com.ridvan.lovenue.databinding.ActivityVenueDetailBinding;
import com.ridvan.lovenue.viewmodels.VenueDetailViewModel;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class VenueDetailActivity extends AppCompatActivity {

    ActivityVenueDetailBinding binding;
    VenueDetailViewModel venueDetailViewModel;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_venue_detail);

        venueDetailViewModel = ViewModelProviders.of(this).get(VenueDetailViewModel.class);
        binding.setDetailViewModel(venueDetailViewModel);
        binding.setLifecycleOwner(this);

        String name = getIntent().getStringExtra(LovenueConstants.NAME);
        String category = getIntent().getStringExtra(LovenueConstants.CATEGORY);
        String rating = getIntent().getStringExtra(LovenueConstants.RATING);
        String ratingColor = getIntent().getStringExtra(LovenueConstants.RATING_COLOR);
        String address = getIntent().getStringExtra(LovenueConstants.ADDRESS);
        String url = getIntent().getStringExtra(LovenueConstants.URL);
        String phone = getIntent().getStringExtra(LovenueConstants.PHONE);

        if (ratingColor != null) {
            binding.rating.setTextColor(Color.parseColor("#" + ratingColor));
        }

        binding.url.setMovementMethod(LinkMovementMethod.getInstance());
        binding.phone.setMovementMethod(LinkMovementMethod.getInstance());

        venueDetailViewModel.setDetail(name, category, rating, address, url, phone);
    }
}
