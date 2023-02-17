package com.contacts.app.ui.contacts;

import com.contacts.app.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ContactsPresenter <V extends ContactsMvpView,
        I extends ContactsMvpInteractor> extends BasePresenter<V, I>
        implements ContactsMvpPresenter<V, I> {

    @Inject
    public ContactsPresenter(I mvpInteractor, CompositeDisposable compositeDisposable) {
        super(mvpInteractor, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {

    }
}
