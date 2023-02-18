package com.contacts.app.ui.contact_list;

import com.contacts.app.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ContactsPresenter <V extends ContactsMvpView,
        I extends ContactsMvpInteractor> extends BasePresenter<V, I>
        implements ContactsMvpPresenter<V, I> {

    @Inject
    public ContactsPresenter(I mvpInteractor, CompositeDisposable compositeDisposable) {
        super(mvpInteractor, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        getCompositeDisposable().add(getInteractor()
                .getContactsApiCall(10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(contactList -> {
                    if (contactList != null && contactList.size() > 0) {
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
