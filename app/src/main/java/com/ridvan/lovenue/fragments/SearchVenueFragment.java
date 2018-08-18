package com.ridvan.lovenue.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ridvan.lovenue.R;
import com.ridvan.lovenue.databinding.FragmentSearchBinding;
import com.ridvan.lovenue.viewmodels.RelevantVenuesViewModel;

/**
 * Created by ridvanozguvenir on 17.08.2018.
 */
public class SearchVenueFragment extends Fragment {
    public SearchVenueFragment() {
    }

    @SuppressLint("ValidFragment")
    public SearchVenueFragment(String location) {
        this.ll = location;
    }

    private RelevantVenuesViewModel searchViewModel;
    private String ll;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentSearchBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        searchViewModel = ViewModelProviders.of((FragmentActivity) getActivity()).get(RelevantVenuesViewModel.class);
        binding.setSearchViewModel(searchViewModel);

        searchViewModel.getNearMeVisibility().setValue(ll != null);

        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchViewModel.getRelevantVenuesSearchResult(ll);
                getActivity().getFragmentManager().popBackStack();
            }
        });

        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getFragmentManager().popBackStack();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        searchViewModel.getIsSearchFragmentVisible().setValue(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        searchViewModel.getIsSearchFragmentVisible().setValue(false);
    }
}
