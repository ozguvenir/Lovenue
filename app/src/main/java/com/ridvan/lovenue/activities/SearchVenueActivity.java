package com.ridvan.lovenue.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ridvan.lovenue.R;
import com.ridvan.lovenue.databinding.ActivitySearchBinding;
import com.ridvan.lovenue.viewmodels.SearchVenueViewModel;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class SearchVenueActivity extends AppCompatActivity {

    ActivitySearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        final SearchVenueViewModel searchViewModel = ViewModelProviders.of(this).get(SearchVenueViewModel.class);
        binding.setSearchViewModel(searchViewModel);
        binding.setLifecycleOwner(this);

        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchViewModel.getRelevantVenuesSearchResult();
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
