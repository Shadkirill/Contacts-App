package com.contacts.app.ui.contact_info;


import android.net.Uri;

import com.contacts.app.data.database.model.Contact;
import com.contacts.app.ui.base.MvpPresenter;

public interface ContactInfoMvpPresenter<V extends ContactInfoMvpView,
        I extends ContactInfoMvpInteractor> extends MvpPresenter<V, I> {

    void favouriteButtonCLicked();
    void avatarClicked();
    void avatarChanged(Uri uri);
    void contactLoaded(Contact contact);
}
