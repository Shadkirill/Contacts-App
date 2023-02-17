package com.contacts.app.data.network;

import com.contacts.app.data.network.model.ContactResponseModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    String ENDPOINT = "https://random-data-api.com/";

    @GET("api/users/random_user")
    Observable<List<ContactResponseModel>> getContactsResponse(
            @Query("size") int size);

}
