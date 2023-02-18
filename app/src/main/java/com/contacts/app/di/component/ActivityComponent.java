package com.contacts.app.di.component;


import com.contacts.app.ui.main.MainActivity;
import com.contacts.app.di.ActivityScope;
import com.contacts.app.di.module.ActivityModule;
import com.contacts.app.ui.contact_list.ContactsFragment;

import dagger.Component;


@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(ContactsFragment contactsFragment);
}

