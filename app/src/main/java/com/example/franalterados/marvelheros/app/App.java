package com.example.franalterados.marvelheros.app;

import android.app.Application;

import com.example.franalterados.marvelheros.rest.RestClient;

/**
 * Created by FranAlterados on 23/6/17.
 */
public class App extends Application {

    public static App INSTANCE;
    private static RestClient REST_CLIENT;

    public static RestClient getRestClient() {
        return REST_CLIENT;
    }

    public static void setRestClient(RestClient restClient) {
        REST_CLIENT = restClient;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        REST_CLIENT = new RestClient();

    }
}
