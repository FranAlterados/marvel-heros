package com.example.franalterados.marvelheros.business;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by FranAlterados on 23/6/17.
 */
public interface BusinessCallback<T> {
    /**
     * Successful HTTP response.
     */
    void success(T t, Response response);

    /**
     * Unsuccessful HTTP response due to network failure, non-2XX status code, or unexpected
     * exception.
     */
    void failure(RetrofitError error);
}
