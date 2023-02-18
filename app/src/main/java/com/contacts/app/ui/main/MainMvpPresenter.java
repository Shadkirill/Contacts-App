
package com.contacts.app.ui.main;

import com.contacts.app.data.database.model.Contact;
import com.contacts.app.di.ActivityScope;
import com.contacts.app.ui.base.MvpPresenter;

@ActivityScope
public interface MainMvpPresenter<V extends MainMvpView, I extends MainMvpInteractor>
        extends MvpPresenter<V, I> {

    void onContactClick(Contact contact);
}
