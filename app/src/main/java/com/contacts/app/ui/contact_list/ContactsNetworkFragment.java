package com.contacts.app.ui.contact_list;

import android.os.Bundle;

import com.contacts.app.di.component.ActivityComponent;

import javax.inject.Inject;
import javax.inject.Named;

public class ContactsNetworkFragment extends ContactsFragment {

    @Inject
    @Named("Network")
    ContactsMvpPresenter<ContactsMvpView, ContactsMvpInteractor> presenter;

    public static ContactsNetworkFragment newInstance() {
        Bundle args = new Bundle();
        ContactsNetworkFragment fragment = new ContactsNetworkFragment();
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
