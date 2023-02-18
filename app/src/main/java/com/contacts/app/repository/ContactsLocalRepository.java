package com.contacts.app.repository;

import com.contacts.app.data.database.ContactsDao;
import com.contacts.app.data.database.model.Contact;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ContactsLocalRepository implements ContactsRepository{

    private final ContactsDao contactsDao;

    @Inject
    public ContactsLocalRepository(ContactsDao contactsDao) {
        this.contactsDao = contactsDao;
    }

    @Override
    public Observable<List<Contact>> getAllContacts() {
        return contactsDao.getAllContacts().map(contactList -> {
            for (int i = 0; i < contactList.size(); ++i) {
                contactList.get(i).setFavourite(true);
            }
            return contactList;
        });
    }
}
