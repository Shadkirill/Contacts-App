package com.contacts.app.ui.contacts;

import com.contacts.app.data.network.ApiService;
import com.contacts.app.data.network.model.ContactResponseModel;
import com.contacts.app.ui.base.BaseInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ContactsInteractor extends BaseInteractor implements ContactsMvpInteractor {

    private ApiService apiService;

    @Inject
    public ContactsInteractor(ApiService apiService) {
        this.apiService = apiService;
    }


    public Observable<List<ContactResponseModel>> getContactsApiCall(int size) {
        return apiService.getContactsResponse(size);
    }

}
