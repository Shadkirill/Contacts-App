package com.contacts.app.ui.contact_list.favourite;

import com.contacts.app.data.database.model.Contact;
import com.contacts.app.repository.ContactsRepository;
import com.contacts.app.ui.base.BaseInteractor;
import com.contacts.app.ui.contact_list.ContactsInteractor;
import com.contacts.app.ui.contact_list.ContactsMvpInteractor;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;

public class FavouriteContactsInteractor extends ContactsInteractor implements ContactsMvpInteractor {

    private ContactsRepository contactsRepository;

    @Inject
    public FavouriteContactsInteractor(@Named("Local") ContactsRepository contactsRepository) {
        super(contactsRepository);
    }
}
