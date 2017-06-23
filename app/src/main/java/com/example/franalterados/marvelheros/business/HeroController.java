package com.example.franalterados.marvelheros.business;

import com.example.franalterados.marvelheros.app.App;
import com.example.franalterados.marvelheros.model.Hero;
import com.example.franalterados.marvelheros.rest.model.DTOHero;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by FranAlterados on 23/6/17.
 */
public class HeroController {

    public static void getAllHeros(final BusinessCallback<List<Hero>> callback) {
        App.getRestClient().getHeroService().getHeros(new Callback<List<DTOHero>>() {
            @Override
            public void success(List<DTOHero> dtoHeros, Response response) {
                List<Hero> lstHero = HeroMapper.lstDtoHeroToLstHero(dtoHeros);
                callback.success(lstHero, response);
            }

            @Override
            public void failure(RetrofitError error) {
                callback.failure(error);
            }
        });
    }
}
