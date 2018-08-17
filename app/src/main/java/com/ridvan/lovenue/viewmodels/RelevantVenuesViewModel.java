package com.ridvan.lovenue.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.ridvan.lovenue.Service.FoursquareService;
import com.ridvan.lovenue.ServiceContext;
import com.ridvan.lovenue.constants.LovenueConstants;
import com.ridvan.lovenue.models.model.Items;
import com.ridvan.lovenue.models.request.RelevantVenuesRequestModel;
import com.ridvan.lovenue.models.response.RelevantVenuesResponseModel;
import com.ridvan.lovenue.models.response.VenueDetailResponseModel;

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

    public MutableLiveData<List<Items>> getItemsList() {
        return itemsList;
    }

    public MutableLiveData<VenueDetailResponseModel> getVenueDetailData() {
        return venueDetailData;
    }
}
