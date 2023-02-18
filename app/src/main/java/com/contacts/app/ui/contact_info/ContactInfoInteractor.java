package com.contacts.app.ui.contact_info;

import com.contacts.app.data.database.model.Contact;
import com.contacts.app.repository.ContactsRepository;
import com.contacts.app.repository.ContactsStorageRepository;
import com.contacts.app.ui.base.BaseInteractor;

import javax.inject.Inject;

import io.reactivex.Completable;


public class ContactInfoInteractor extends BaseInteractor implements ContactInfoMvpInteractor {

    private ContactsStorageRepository contactsRepository;

    @Inject
    public ContactInfoInteractor(ContactsStorageRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }


    @Override
    public Completable addContact(Contact contact) {
        return contactsRepository.addContact(contact);
    }

    @Override
    public Completable removeContact(Contact contact) {
        return contactsRepository.removeContact(contact);
    }

    @Override
    public Completable updateContact(Contact contact) {
        return contactsRepository.updateContact(contact);
    }
}
