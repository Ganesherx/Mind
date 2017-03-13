package com.example.ganesh.mind.Utils;

import com.example.ganesh.mind.BuildConfig;

public class Constants {

    public static final String FIREBASE_URL = BuildConfig.UNIQUE_FIREBASE_ROOT_URL;

    public static final String FIREBASE_LOCATION_ACTIVE_CARDS = "ActiveCards";
    public static final String FIREBASE_URL_ACTIVE_CARDS = FIREBASE_URL + "/" + FIREBASE_LOCATION_ACTIVE_CARDS;
}
