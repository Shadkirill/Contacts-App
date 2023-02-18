package com.contacts.app.ui.contact_list;

import com.contacts.app.data.database.model.Contact;
import com.contacts.app.ui.base.MvpInteractor;

import java.util.List;

import io.reactivex.Observable;

public interface ContactsMvpInteractor extends MvpInteractor {
    Observable<List<Contact>> getContactsApiCall(int size);
}
