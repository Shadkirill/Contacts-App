package com.contacts.app.ui.contact_list.favourite;

import com.contacts.app.ui.base.BasePresenter;
import com.contacts.app.ui.contact_list.ContactsMvpInteractor;
import com.contacts.app.ui.contact_list.ContactsMvpPresenter;
import com.contacts.app.ui.contact_list.ContactsMvpView;
import com.contacts.app.ui.contact_list.ContactsPresenter;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FavouriteContactsPresenter<V extends ContactsMvpView,
        I extends ContactsMvpInteractor> extends ContactsPresenter<V, I> {

    @Inject
    public FavouriteContactsPresenter(@Named("Local") I mvpInteractor, CompositeDisposable compositeDisposable) {
        super(mvpInteractor, compositeDisposable);
    }

}
