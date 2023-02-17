package com.contacts.app.di.module;


import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.contacts.app.di.ActivityContext;
import com.contacts.app.di.ActivityScope;
import com.contacts.app.ui.contacts.ContactsInteractor;
import com.contacts.app.ui.contacts.ContactsMvpInteractor;
import com.contacts.app.ui.contacts.ContactsMvpPresenter;
import com.contacts.app.ui.contacts.ContactsMvpView;
import com.contacts.app.ui.contacts.ContactsPresenter;

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

    @Provides
    @ActivityScope
    ContactsMvpInteractor provideContactsMvpInteractor(ContactsInteractor interactor) {
        return interactor;
    }

}

