package com.contacts.app.di.module;


import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.contacts.app.data.database.model.Contact;
import com.contacts.app.di.ActivityContext;
import com.contacts.app.di.ActivityScope;
import com.contacts.app.repository.ContactsLocalRepository;
import com.contacts.app.repository.ContactsLocalStorageRepository;
import com.contacts.app.repository.ContactsNetworkRepository;
import com.contacts.app.repository.ContactsRepository;
import com.contacts.app.repository.ContactsStorageRepository;
import com.contacts.app.ui.contact_info.ContactInfoInteractor;
import com.contacts.app.ui.contact_info.ContactInfoMvpInteractor;
import com.contacts.app.ui.contact_info.ContactInfoMvpPresenter;
import com.contacts.app.ui.contact_info.ContactInfoMvpView;
import com.contacts.app.ui.contact_info.ContactInfoPresenter;
import com.contacts.app.ui.contact_list.ContactsAdapter;
import com.contacts.app.ui.contact_list.ContactsInteractor;
import com.contacts.app.ui.contact_list.ContactsMvpInteractor;
import com.contacts.app.ui.contact_list.ContactsMvpPresenter;
import com.contacts.app.ui.contact_list.ContactsMvpView;
import com.contacts.app.ui.contact_list.ContactsPresenter;
import com.contacts.app.ui.contact_list.favourite.FavouriteContactsInteractor;
import com.contacts.app.ui.contact_list.favourite.FavouriteContactsPresenter;
import com.contacts.app.ui.main.MainInteractor;
import com.contacts.app.ui.main.MainMvpInteractor;
import com.contacts.app.ui.main.MainMvpPresenter;
import com.contacts.app.ui.main.MainMvpView;
import com.contacts.app.ui.main.MainPresenter;

import java.util.ArrayList;

import javax.inject.Named;

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
    @Named("Network")
    ContactsMvpPresenter<ContactsMvpView, ContactsMvpInteractor> provideNetworkContactsPresenter(
            ContactsPresenter<ContactsMvpView, ContactsMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @Named("Local")
    ContactsMvpPresenter<ContactsMvpView, ContactsMvpInteractor> provideLocalContactsPresenter(
            FavouriteContactsPresenter<ContactsMvpView, ContactsMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @Named("Network")
    ContactsRepository provideContactsNetworkRepository(ContactsNetworkRepository contactsRepository) {
        return contactsRepository;
    }

    @Provides
    @Named("Local")
    ContactsRepository provideContactsLocalRepository(ContactsLocalRepository contactsRepository) {
        return contactsRepository;
    }

    @Provides
    @Named("Network")
    ContactsMvpInteractor provideNetworkContactsMvpInteractor(ContactsInteractor interactor) {
        return interactor;
    }

    @Provides
    @Named("Local")
    ContactsMvpInteractor provideLocalContactsMvpInteractor(FavouriteContactsInteractor interactor) {
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

    @Provides
    @ActivityScope
    MainMvpPresenter<MainMvpView, MainMvpInteractor> provideMainMvpPresenter(
            MainPresenter<MainMvpView, MainMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @ActivityScope
    MainMvpInteractor provideMainMvpInteractor(MainInteractor interactor) {
        return interactor;
    }

    @Provides
    @ActivityScope
    ContactInfoMvpPresenter<ContactInfoMvpView, ContactInfoMvpInteractor> provideContactInfoMvpPresenter(
            ContactInfoPresenter<ContactInfoMvpView, ContactInfoMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @ActivityScope
    ContactInfoMvpInteractor provideContactInfoMvpInteractor(ContactInfoInteractor interactor) {
        return interactor;
    }

    @Provides
    @ActivityScope
    ContactsStorageRepository provideContactStorageRepository(ContactsLocalStorageRepository repository) {
        return repository;
    }


}

