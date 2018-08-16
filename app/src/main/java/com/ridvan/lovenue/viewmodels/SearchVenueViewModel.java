package com.ridvan.lovenue.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.ridvan.lovenue.Service.FoursquareService;
import com.ridvan.lovenue.ServiceContext;
import com.ridvan.lovenue.constants.LovenueConstants;
import com.ridvan.lovenue.models.request.RelevantVenuesRequestModel;
import com.ridvan.lovenue.models.response.RelevantVenuesResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class SearchVenueViewModel extends ViewModel {
    private MutableLiveData<Boolean> sortByDistance = new MutableLiveData<>();
    private MutableLiveData<Boolean> nearMe = new MutableLiveData<>();
    private MutableLiveData<String> locationInput = new MutableLiveData<>();
    private MutableLiveData<String> radiusInput = new MutableLiveData<>();
    private MutableLiveData<String> sectionInput = new MutableLiveData<>();
    private MutableLiveData<Boolean> priceOne = new MutableLiveData<>();
    private MutableLiveData<Boolean> priceTwo = new MutableLiveData<>();
    private MutableLiveData<Boolean> priceThree = new MutableLiveData<>();
    private MutableLiveData<Boolean> priceFour = new MutableLiveData<>();
    private MutableLiveData<Boolean> openNow = new MutableLiveData<>();

    public SearchVenueViewModel() {
        sortByDistance.setValue(Boolean.FALSE);
        getNearMe().setValue(false);
        getPriceOne().setValue(false);
        getPriceTwo().setValue(false);
        getPriceThree().setValue(false);
        getPriceFour().setValue(false);
        getOpenNow().setValue(false);
    }

    public void getRelevantVenuesSearchResult() {
        //TODO
        RelevantVenuesRequestModel relevantVenuesRequestModel = new RelevantVenuesRequestModel();
        FoursquareService fourSquareService = ServiceContext.instance.retrofit.create(FoursquareService.class);
        final Call<RelevantVenuesResponseModel> call = fourSquareService.getRelevantVenues(LovenueConstants.FOURSQUARE_CLIENT_KEY, LovenueConstants.FOURSQUARE_CLIENT_SECRET, relevantVenuesRequestModel.getLl(), relevantVenuesRequestModel.getNear(), LovenueConstants.FOURSQUARE_REQUEST_VERSION, relevantVenuesRequestModel.getRadius(), relevantVenuesRequestModel.getSection(), relevantVenuesRequestModel.getOpenNow(), relevantVenuesRequestModel.getSortByDistance(), LovenueConstants.NOF_RESULT_LIMIT);
        call.enqueue(new Callback<RelevantVenuesResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<RelevantVenuesResponseModel> call, @NonNull Response<RelevantVenuesResponseModel> response) {
                RelevantVenuesResponseModel responseModel = response.body();
                if (responseModel != null && responseModel.getResponse() != null) {
                    if (responseModel.getResponse().getGroups() != null && responseModel.getResponse().getGroups().size() > 0) {

                    }
                } else {

                }
            }

            @Override
            public void onFailure(@NonNull Call<RelevantVenuesResponseModel> call, @NonNull Throwable t) {

            }
        });
    }

    public MutableLiveData<Boolean> getSortByDistance() {
        return sortByDistance;
    }

    public MutableLiveData<Boolean> getNearMe() {
        return nearMe;
    }

    public MutableLiveData<String> getLocationInput() {
        return locationInput;
    }

    public MutableLiveData<String> getRadiusInput() {
        return radiusInput;
    }

    public MutableLiveData<String> getSectionInput() {
        return sectionInput;
    }

    public MutableLiveData<Boolean> getPriceOne() {
        return priceOne;
    }

    public MutableLiveData<Boolean> getPriceTwo() {
        return priceTwo;
    }

    public MutableLiveData<Boolean> getPriceThree() {
        return priceThree;
    }

    public MutableLiveData<Boolean> getPriceFour() {
        return priceFour;
    }

    public MutableLiveData<Boolean> getOpenNow() {
        return openNow;
    }
}
