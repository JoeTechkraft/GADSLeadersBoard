package com.jonathan.gadsleadersboard.network;

import com.jonathan.gadsleadersboard.api.GadsApi;
import com.jonathan.gadsleadersboard.api.GoogleFormApi;

public class NetworkService {

    public GadsApi getGadsApi() {
        return new RetrofitClient(RetrofitClient.GADS_BASE_URL).createService(GadsApi.class);
    }

    public GoogleFormApi getGoogleFormApi() {
        return new RetrofitClient(RetrofitClient.GOOGLE_FORMS_BASE_URL).createService(GoogleFormApi.class);
    }
}
