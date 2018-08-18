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
    private MutableLiveData<String> address = new MutableLiveData<>();
    private MutableLiveData<String> url = new MutableLiveData<>();
    private MutableLiveData<String> formattedPhoneNumber = new MutableLiveData<>();
    private MutableLiveData<String> priceTier = new MutableLiveData<>();

    public void setDetail(String nameValue, String categoryValue, String ratingValue, String addressValue, String urlValue, String phoneValue, String priceTierValue) {
        name.setValue(nameValue);
        category.setValue(categoryValue);
        rating.setValue(ratingValue);
        address.setValue(addressValue);
        url.setValue(urlValue);
        formattedPhoneNumber.setValue(phoneValue);
        priceTier.setValue(priceTierValue);
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

    public MutableLiveData<String> getUrl() {
        return url;
    }

    public MutableLiveData<String> getFormattedPhoneNumber() {
        return formattedPhoneNumber;
    }

    public MutableLiveData<String> getPriceTier() {
        return priceTier;
    }
}
