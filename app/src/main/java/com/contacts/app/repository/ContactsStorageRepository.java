package com.contacts.app.repository;

import com.contacts.app.data.database.model.Contact;

import io.reactivex.Completable;

public interface ContactsStorageRepository {
    Completable addContact(Contact contact);
    Completable removeContact(Contact contact);
    Completable updateContact(Contact contact);
}
