package com.ridvan.lovenue.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ridvan.lovenue.R;
import com.ridvan.lovenue.constants.LovenueConstants;
import com.ridvan.lovenue.databinding.ActivitySearchBinding;
import com.ridvan.lovenue.models.model.Items;
import com.ridvan.lovenue.viewmodels.RelevantVenuesViewModel;

import java.util.List;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class SearchVenueActivity extends AppCompatActivity {

    ActivitySearchBinding binding;
    private String ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        final RelevantVenuesViewModel searchViewModel = ViewModelProviders.of(this).get(RelevantVenuesViewModel.class);
        binding.setSearchViewModel(searchViewModel);
        binding.setLifecycleOwner(this);

        ll = getIntent().getStringExtra(LovenueConstants.LATLONG);

        searchViewModel.getNearMeVisibility().setValue(ll != null); // if location is null, user must enter location input

        searchViewModel.getItemsList().observe(this, new Observer<List<Items>>() {
            @Override
            public void onChanged(@Nullable List<Items> items) {
                Intent intent = new Intent(SearchVenueActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchVenueActivity.this, MainActivity.class);
                intent.putExtra("search", "fromsearch");
                startActivity(intent);
                finish();
            }
        });

        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
