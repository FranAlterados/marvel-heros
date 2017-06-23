package com.example.franalterados.marvelheros.rest;

import com.example.franalterados.marvelheros.R;
import com.example.franalterados.marvelheros.app.App;
import com.example.franalterados.marvelheros.rest.services.HerosService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.JacksonConverter;

/**
 * Created by FranAlterados on 23/6/17.
 */
public class RestClient {

    private static final String BASE_URL = App.INSTANCE.getApplicationContext().getString(R.string.urlApi);

    private HerosService herosService;

    public RestClient() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OkHttpClient client = new OkHttpClient();
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestInterceptor.RequestFacade request) {
                request.addHeader("Accept", "application/json");
//                request.addHeader("Authorization", "Bearer " + auth);

            }
        };
        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .setClient(new OkClient(client))
                .setRequestInterceptor(requestInterceptor)
                .setConverter(new JacksonConverter(mapper))
                .build();
        initServices(restAdapter);
    }

    private void initServices(RestAdapter restAdapter) {
        herosService = restAdapter.create(HerosService.class);
    }

    public HerosService getHerosService() {
        return herosService;
    }
}
