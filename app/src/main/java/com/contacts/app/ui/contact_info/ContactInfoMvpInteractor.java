package com.contacts.app.ui.contact_info;

import com.contacts.app.data.database.model.Contact;
import com.contacts.app.ui.base.MvpInteractor;

import java.util.List;

import io.reactivex.Completable;


public interface ContactInfoMvpInteractor extends MvpInteractor {

    Completable addContact(Contact contact);
    Completable removeContact(Contact contact);
    Completable updateContact(Contact contact);

}
