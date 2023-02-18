package com.contacts.app.ui.contact_list;

import com.contacts.app.data.database.model.Contact;
import com.contacts.app.repository.ContactsRepository;
import com.contacts.app.ui.base.BaseInteractor;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;

public class ContactsInteractor extends BaseInteractor implements ContactsMvpInteractor {

    private ContactsRepository contactsRepository;

    @Inject
    public ContactsInteractor(@Named("Network") ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @Override
    public Observable<List<Contact>> getContacts() {
        return contactsRepository.getAllContacts();
    }

}
