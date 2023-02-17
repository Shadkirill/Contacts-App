package com.contacts.app;

import android.app.Application;

import com.contacts.app.di.component.ApplicationComponent;
import com.contacts.app.di.component.DaggerApplicationComponent;
import com.contacts.app.di.module.ApplicationModule;


public class AppCore extends Application {


    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}

