package com.contacts.app.repository;

import com.contacts.app.data.database.ContactsDao;
import com.contacts.app.data.database.model.Contact;

import javax.inject.Inject;

import io.reactivex.Completable;

public class ContactsLocalStorageRepository implements ContactsStorageRepository {
    private final ContactsDao contactsDao;

    @Inject
    public ContactsLocalStorageRepository(ContactsDao contactsDao) {
        this.contactsDao = contactsDao;
    }

    @Override
    public Completable addContact(Contact contact) {
        return contactsDao.insert(contact);
    }

    @Override
    public Completable removeContact(Contact contact) {
        return contactsDao.delete(contact);
    }

    @Override
    public Completable updateContact(Contact contact) {
        return contactsDao.update(contact);
    }
}
