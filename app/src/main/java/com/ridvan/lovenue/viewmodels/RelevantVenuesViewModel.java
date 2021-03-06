package com.ridvan.lovenue.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.ridvan.lovenue.service.FoursquareService;
import com.ridvan.lovenue.ServiceContext;
import com.ridvan.lovenue.constants.LovenueConstants;
import com.ridvan.lovenue.models.model.Items;
import com.ridvan.lovenue.models.request.RelevantVenuesRequestModel;
import com.ridvan.lovenue.models.response.RelevantVenuesResponseModel;
import com.ridvan.lovenue.models.response.VenueDetailResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class RelevantVenuesViewModel extends ViewModel {
    private MutableLiveData<List<Items>> itemsList = new MutableLiveData<>();
    private MutableLiveData<VenueDetailResponseModel> venueDetailData = new MutableLiveData<>();

    private MutableLiveData<Boolean> isSearchFragmentVisible = new MutableLiveData<>();

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
    private MutableLiveData<Boolean> nearMeVisibility = new MutableLiveData<>();

    public RelevantVenuesViewModel() {
        sortByDistance.setValue(false);
        nearMe.setValue(false);
        priceOne.setValue(false);
        priceTwo.setValue(false);
        priceThree.setValue(false);
        priceFour.setValue(false);
        openNow.setValue(false);
    }

    public void getRelevantVenues(RelevantVenuesRequestModel relevantVenuesRequestModel) {
        FoursquareService fourSquareService = ServiceContext.instance.retrofit.create(FoursquareService.class);
        final Call<RelevantVenuesResponseModel> call = fourSquareService.getRelevantVenues(LovenueConstants.FOURSQUARE_CLIENT_KEY, LovenueConstants.FOURSQUARE_CLIENT_SECRET, relevantVenuesRequestModel.getLl(), relevantVenuesRequestModel.getNear(), LovenueConstants.FOURSQUARE_REQUEST_VERSION, relevantVenuesRequestModel.getRadius(), relevantVenuesRequestModel.getSection(), null, relevantVenuesRequestModel.getOpenNow(), relevantVenuesRequestModel.getSortByDistance(), LovenueConstants.NOF_RESULT_LIMIT);
        call.enqueue(new Callback<RelevantVenuesResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<RelevantVenuesResponseModel> call, @NonNull Response<RelevantVenuesResponseModel> response) {
                RelevantVenuesResponseModel responseModel = response.body();
                if (responseModel != null && responseModel.getResponse() != null) {
                    if (responseModel.getResponse().getGroups() != null && responseModel.getResponse().getGroups().size() > 0) {
                        itemsList.setValue(responseModel.getResponse().getGroups().get(0).getItems());
                    }
                } else {
                    itemsList.setValue(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<RelevantVenuesResponseModel> call, @NonNull Throwable t) {
                itemsList.setValue(null);
            }
        });
    }

    public void getVenueDetail(String venueId) {
        FoursquareService fourSquareService = ServiceContext.instance.retrofit.create(FoursquareService.class);
        final Call<VenueDetailResponseModel> call = fourSquareService.getVenueDetail(venueId, LovenueConstants.FOURSQUARE_CLIENT_KEY, LovenueConstants.FOURSQUARE_CLIENT_SECRET, LovenueConstants.FOURSQUARE_REQUEST_VERSION);
        call.enqueue(new Callback<VenueDetailResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<VenueDetailResponseModel> call, @NonNull Response<VenueDetailResponseModel> response) {
                VenueDetailResponseModel responseModel = response.body();
                if (responseModel != null) {
                    venueDetailData.setValue(responseModel);
                } else {
                    venueDetailData.setValue(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<VenueDetailResponseModel> call, @NonNull Throwable t) {
                venueDetailData.setValue(null);
            }
        });
    }

    public void getRelevantVenuesSearchResult(String ll) {
        List<String> priceList = new ArrayList<>();
        String price = "";
        if (Boolean.TRUE.equals(priceOne.getValue())) {
            priceList.add("1");
        }
        if (Boolean.TRUE.equals(priceTwo.getValue())) {
            priceList.add("2");
        }
        if (Boolean.TRUE.equals(priceThree.getValue())) {
            priceList.add("3");
        }
        if (Boolean.TRUE.equals(priceFour.getValue())) {
            priceList.add("4");
        }
        if (priceList.size() > 1) {
            for (int i = 0; i < priceList.size(); i++) {
                if (i == priceList.size() - 1) {
                    price += priceList.get(i);
                } else {
                    price += priceList.get(i) + ",";
                }
            }
        } else {
            if (priceList.size() > 0) {
                price = priceList.get(0);
            } else {
                price = null;
            }
        }

        RelevantVenuesRequestModel relevantVenuesRequestModel = new RelevantVenuesRequestModel(ll, locationInput.getValue(), radiusInput.getValue(), sectionInput.getValue(), price, Boolean.TRUE.equals(openNow.getValue()) ? "1" : "0", Boolean.TRUE.equals(sortByDistance.getValue()) ? "1" : "0");
        FoursquareService fourSquareService = ServiceContext.instance.retrofit.create(FoursquareService.class);
        final Call<RelevantVenuesResponseModel> call = fourSquareService.getRelevantVenues(LovenueConstants.FOURSQUARE_CLIENT_KEY, LovenueConstants.FOURSQUARE_CLIENT_SECRET, relevantVenuesRequestModel.getLl(), relevantVenuesRequestModel.getNear(), LovenueConstants.FOURSQUARE_REQUEST_VERSION, relevantVenuesRequestModel.getRadius(), relevantVenuesRequestModel.getSection(), price, relevantVenuesRequestModel.getOpenNow(), relevantVenuesRequestModel.getSortByDistance(), LovenueConstants.NOF_RESULT_LIMIT);
        call.enqueue(new Callback<RelevantVenuesResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<RelevantVenuesResponseModel> call, @NonNull Response<RelevantVenuesResponseModel> response) {
                RelevantVenuesResponseModel responseModel = response.body();
                if (responseModel != null && responseModel.getResponse() != null) {
                    if (responseModel.getResponse().getGroups() != null && responseModel.getResponse().getGroups().size() > 0) {
                        itemsList.setValue(responseModel.getResponse().getGroups().get(0).getItems());
                    }
                } else {
                    itemsList.setValue(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<RelevantVenuesResponseModel> call, @NonNull Throwable t) {
                itemsList.setValue(null);
            }
        });
    }

    public MutableLiveData<List<Items>> getItemsList() {
        return itemsList;
    }

    public MutableLiveData<VenueDetailResponseModel> getVenueDetailData() {
        return venueDetailData;
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

    public MutableLiveData<Boolean> getNearMeVisibility() {
        return nearMeVisibility;
    }

    public MutableLiveData<Boolean> getIsSearchFragmentVisible() {
        return isSearchFragmentVisible;
    }
}
