package com.contacts.app.ui.contacts;

import com.contacts.app.data.database.model.Contact;
import com.contacts.app.ui.base.MvpView;

import java.util.List;


public interface ContactsMvpView extends MvpView {

    void updateContacts(List<Contact> contactsList);
}
