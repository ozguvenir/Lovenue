package com.ridvan.lovenue.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class VenueDetailViewModel extends ViewModel {
    private MutableLiveData<String> name = new MutableLiveData<>();
    private MutableLiveData<String> category = new MutableLiveData<>();
    private MutableLiveData<String> rating = new MutableLiveData<>();
    private MutableLiveData<String> description = new MutableLiveData<>();
    private MutableLiveData<String> price = new MutableLiveData<>();
    private MutableLiveData<String> address = new MutableLiveData<>();
    private MutableLiveData<String> formattedPhoneNumber = new MutableLiveData<>();

    public void getVenueDetail() {
        //TODO venue detail service
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<String> getCategory() {
        return category;
    }

    public MutableLiveData<String> getRating() {
        return rating;
    }

    public MutableLiveData<String> getDescription() {
        return description;
    }

    public MutableLiveData<String> getPrice() {
        return price;
    }

    public MutableLiveData<String> getAddress() {
        return address;
    }

    public MutableLiveData<String> getFormattedPhoneNumber() {
        return formattedPhoneNumber;
    }
}
