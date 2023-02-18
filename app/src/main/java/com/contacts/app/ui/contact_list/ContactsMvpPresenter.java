package com.contacts.app.ui.contact_list;


import com.contacts.app.ui.base.MvpPresenter;

public interface ContactsMvpPresenter<V extends ContactsMvpView,
        I extends ContactsMvpInteractor> extends MvpPresenter<V, I> {

    void onViewPrepared();
}
