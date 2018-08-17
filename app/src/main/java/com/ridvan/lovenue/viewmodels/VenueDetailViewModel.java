package com.ridvan.lovenue.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.ridvan.lovenue.models.model.Venue;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class VenueDetailViewModel extends ViewModel {
    private MutableLiveData<String> name = new MutableLiveData<>();
    private MutableLiveData<String> category = new MutableLiveData<>();
    private MutableLiveData<String> rating = new MutableLiveData<>();
    private MutableLiveData<String> address = new MutableLiveData<>();
    private MutableLiveData<String> formattedPhoneNumber = new MutableLiveData<>();

    public void setDetail(Venue venue) {
        name.setValue(venue.getName());
        if (venue.getCategories() != null && venue.getCategories().get(0) != null) {
            category.setValue(venue.getCategories().get(0).getPluralName());
        } else {
            category.setValue("Unknown Category");
        }
        rating.setValue(venue.getRating() != null ? venue.getRating().toString() : "?");
        address.setValue(venue.getLocation() != null ? venue.getLocation().getAddress() : "No address found.");
        formattedPhoneNumber.setValue(venue.getContact() != null ? venue.getContact().getFormattedPhone() : "No phone number found.");
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

    public MutableLiveData<String> getAddress() {
        return address;
    }

    public MutableLiveData<String> getFormattedPhoneNumber() {
        return formattedPhoneNumber;
    }
}
