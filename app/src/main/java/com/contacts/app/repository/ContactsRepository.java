package com.contacts.app.repository;

import com.contacts.app.data.database.model.Contact;
import com.contacts.app.data.network.ApiService;
import com.contacts.app.data.network.model.ContactResponseModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class ContactsRepository {

    private final ApiService apiService;

    @Inject
    public ContactsRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<List<Contact>> getAllUsers() {
        return apiService.getContactsResponse(10).map((Function<List<ContactResponseModel>, List<Contact>>) contactResponseModels -> {
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
