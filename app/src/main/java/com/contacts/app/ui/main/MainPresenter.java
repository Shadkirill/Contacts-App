
package com.contacts.app.ui.main;

import com.contacts.app.data.database.model.Contact;
import com.contacts.app.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;



public class MainPresenter<V extends MainMvpView, I extends MainMvpInteractor>
        extends BasePresenter<V, I> implements MainMvpPresenter<V, I> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(I mvpInteractor,
                         CompositeDisposable compositeDisposable) {
        super(mvpInteractor, compositeDisposable);
    }

    @Override
    public void onBackClick() {

    }

    @Override
    public void onContactClick(Contact contact) {

    }
}
