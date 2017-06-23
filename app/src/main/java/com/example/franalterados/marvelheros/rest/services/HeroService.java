package com.example.franalterados.marvelheros.rest.services;

import com.example.franalterados.marvelheros.rest.model.DTOSuperheroes;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by FranAlterados on 23/6/17.
 */
public interface HeroService {

    @GET("/bins/bvyob")
    public void getHeros(Callback<DTOSuperheroes> callback);

}
