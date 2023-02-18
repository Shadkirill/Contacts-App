package com.contacts.app.ui.contact_info;


import com.contacts.app.ui.base.MvpPresenter;

public interface ContactInfoMvpPresenter<V extends ContactInfoMvpView,
        I extends ContactInfoMvpInteractor> extends MvpPresenter<V, I> {

    void onViewPrepared();
}
