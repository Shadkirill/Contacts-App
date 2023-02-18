package com.contacts.app.ui.contact_list.favourite;

import android.os.Bundle;

import com.contacts.app.di.component.ActivityComponent;
import com.contacts.app.ui.contact_list.ContactsFragment;
import com.contacts.app.ui.contact_list.ContactsMvpInteractor;
import com.contacts.app.ui.contact_list.ContactsMvpPresenter;
import com.contacts.app.ui.contact_list.ContactsMvpView;
import com.contacts.app.ui.contact_list.ContactsPresenter;

import javax.inject.Inject;
import javax.inject.Named;

public class FavouriteContactsFragment extends ContactsFragment {

    @Inject
    @Named("Local")
    ContactsMvpPresenter<ContactsMvpView, ContactsMvpInteractor> presenter;

    public static FavouriteContactsFragment newInstance() {
        Bundle args = new Bundle();
        FavouriteContactsFragment fragment = new FavouriteContactsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public ContactsMvpPresenter<ContactsMvpView, ContactsMvpInteractor> getPresenter() {
        return presenter;
    }

    @Override
    public void inject(ActivityComponent component) {
        component.inject(this);
    }
}
