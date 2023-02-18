package com.contacts.app.ui.contact_list;

import com.contacts.app.ui.base.BasePresenter;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ContactsPresenter <V extends ContactsMvpView,
        I extends ContactsMvpInteractor> extends BasePresenter<V, I>
        implements ContactsMvpPresenter<V, I> {

    @Inject
    public ContactsPresenter(@Named("Network") I mvpInteractor, CompositeDisposable compositeDisposable) {
        super(mvpInteractor, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        getCompositeDisposable().add(getInteractor()
                .getContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(contactList -> {
                    if (contactList != null) {
                        getMvpView().updateContacts(contactList);
                    }
                    getMvpView().hideLoading();
                }, throwable -> {
                    if (!isViewAttached()) {
                        return;
                    }
                    getMvpView().hideLoading();
                    getMvpView().showMessage("Some error happened");
                }));
    }
}
