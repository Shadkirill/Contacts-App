package com.contacts.app.repository;

import com.contacts.app.data.database.model.Contact;

import java.util.List;

import io.reactivex.Observable;

public interface ContactsRepository {
    Observable<List<Contact>> getAllContacts();
}
