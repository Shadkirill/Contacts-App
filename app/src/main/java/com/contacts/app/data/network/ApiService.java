package com.contacts.app.data.network;

import com.contacts.app.data.network.model.ContactResponseModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    String ENDPOINT = "https://random-data-api.com/";

    @GET("api/users/random_user")
    Observable<ContactResponseModel> getContactsResponse(
            @Query("size") int size);


}
