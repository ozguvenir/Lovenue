package com.ridvan.lovenue.constants;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class LovenueConstants {
    // Location Constants
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 188;
    public static final String LOCATION_KEY = "location_key";
    // Foursquare Constants
    public static final String FOURSQUARE_BASE_URL = "https://api.foursquare.com/v2/";
    public static final String FOURSQUARE_CLIENT_KEY = "VC0DONE42YC3DBAJ2VURGLSKVNVMDR2B3JXI0AQG5QH2VQTE";
    public static final String FOURSQUARE_CLIENT_SECRET = "GJXR2OKHQLS3LMOVCO5YBVFLN53WQKOXBU2AITHKJ51S2LYV";
    public static final String NOF_RESULT_LIMIT = "40";
    @SuppressLint("SimpleDateFormat")
    public static final String FOURSQUARE_REQUEST_VERSION = new SimpleDateFormat("yyyyMMdd").format(new Date());
    // Detail Constants
    public static final String NAME = "name";
    public static final String CATEGORY = "category";
    public static final String RATING = "rating";
    public static final String ADDRESS = "address";
    public static final String URL = "url";
    public static final String PHONE = "phone";
    public static final String RATING_COLOR = "ratingColor";
    public static final String PRICE_TIER = "priceTier";
}
