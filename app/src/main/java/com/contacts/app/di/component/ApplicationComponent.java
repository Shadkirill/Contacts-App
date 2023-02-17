package com.contacts.app.di.component;

import android.app.Application;
import android.content.Context;

import com.contacts.app.AppCore;
import com.contacts.app.data.database.ContactsDao;
import com.contacts.app.data.network.ApiService;
import com.contacts.app.di.ApplicationContext;
import com.contacts.app.di.ApplicationScope;
import com.contacts.app.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;



@ApplicationScope
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(AppCore app);

    @ApplicationContext
    Context context();

    Application application();

    ApiService apiService();

    ContactsDao contactsDao();
}
