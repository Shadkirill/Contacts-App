package com.contacts.app.ui.main;

import com.contacts.app.data.database.model.Contact;
import com.contacts.app.ui.base.MvpView;

public interface MainMvpView extends MvpView {
    void showContactDetails(Contact contact);
}
