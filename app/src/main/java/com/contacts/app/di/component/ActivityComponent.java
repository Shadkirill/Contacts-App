package com.contacts.app.di.component;


import com.contacts.app.MainActivity;
import com.contacts.app.di.ActivityScope;
import com.contacts.app.di.module.ActivityModule;

import dagger.Component;


@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}

