package com.contacts.app.repository;

import com.contacts.app.data.database.ContactsDao;
import com.contacts.app.data.database.model.Contact;
import com.contacts.app.data.network.ApiService;
import com.contacts.app.data.network.model.ContactResponseModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class ContactsNetworkRepository implements ContactsRepository {

    private final ApiService apiService;

    @Inject
    public ContactsNetworkRepository (
            ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<List<Contact>> getAllContacts() {
        return apiService.getContactsResponse(30).map((Function<List<ContactResponseModel>, List<Contact>>) contactResponseModels -> {
            List<Contact> contactList = new ArrayList<>();
            for (int i = 0; i < contactResponseModels.size(); ++i) {
                contactList.add(
                        new Contact(
                                contactResponseModels.get(i)
                        )
                );
            }
            return contactList;
        });
    }


}
