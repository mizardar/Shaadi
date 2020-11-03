package com.mizardar.shaaditest.repository.online;

import com.mizardar.shaaditest.model.network.APIResponse;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Single;

public interface UserAPI {

    @GET("api/?results=10")
    Single<Response<APIResponse>> getUsersList();
}
