package com.contacts.app.di.module;


import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.contacts.app.data.database.model.Contact;
import com.contacts.app.di.ActivityContext;
import com.contacts.app.di.ActivityScope;
import com.contacts.app.ui.contact_list.ContactsAdapter;
import com.contacts.app.ui.contact_list.ContactsInteractor;
import com.contacts.app.ui.contact_list.ContactsMvpInteractor;
import com.contacts.app.ui.contact_list.ContactsMvpPresenter;
import com.contacts.app.ui.contact_list.ContactsMvpView;
import com.contacts.app.ui.contact_list.ContactsPresenter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

 private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @ActivityScope
    ContactsMvpPresenter<ContactsMvpView, ContactsMvpInteractor> provideContactsPresenter(
            ContactsPresenter<ContactsMvpView, ContactsMvpInteractor> presenter) {
        return presenter;
    }

   /* @Provides
    @ActivityScope
    ContactsRepository provideContactsRepository(ContactsRepository contactsRepository) {
        return contactsRepository;
    }*/

    @Provides
    @ActivityScope
    ContactsMvpInteractor provideContactsMvpInteractor(ContactsInteractor interactor) {
        return interactor;
    }

    @Provides
    ContactsAdapter provideContactAdapter() {
        return new ContactsAdapter(new ArrayList<Contact>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }


}

