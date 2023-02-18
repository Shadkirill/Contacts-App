package com.contacts.app.ui.contact_info;

import android.net.Uri;

import com.contacts.app.data.database.model.Contact;
import com.contacts.app.ui.base.BasePresenter;
import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ContactInfoPresenter <V extends ContactInfoMvpView,
        I extends ContactInfoMvpInteractor> extends BasePresenter<V, I>
        implements ContactInfoMvpPresenter<V, I> {

    @Inject
    public ContactInfoPresenter(I mvpInteractor, CompositeDisposable compositeDisposable) {
        super(mvpInteractor, compositeDisposable);
    }

    private Contact contact;

    @Override
    public void favouriteButtonCLicked() {
        if (contact.getFavourite()) {
            removeContact();
        } else {
            addContact();
        }
    }

    @Override
    public void avatarClicked() {
        getMvpView().changeAvatar();
    }

    @Override
    public void avatarChanged(Uri uri) {
        if (uri != null) {
            contact.setAvatarFile(uri.toString());
            if (contact.getFavourite()) {
                updateContact();
            } else {
                getMvpView().showContactInformation(contact);
            }
        } else {
            getMvpView().showMessage("Some problem with image");
        }
    }

    private void removeContact() {
        getCompositeDisposable().add(getInteractor()
                .removeContact(contact).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    contact.setFavourite(false);
                    getMvpView().showContactInformation(contact);
                    getMvpView().showMessage("Contact removed from Favourite");
                }, throwable -> {
                    getMvpView().onError("Some error!");
                }));
    }

    private void addContact() {
        getCompositeDisposable().add(getInteractor()
                .addContact(contact).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    contact.setFavourite(true);
                    getMvpView().showContactInformation(contact);
                    getMvpView().showMessage("Contact added to Favourite");
                }, throwable -> {
                    getMvpView().onError("Some error!");
                }));
    }

    private void updateContact() {
        getCompositeDisposable().add(getInteractor()
                .updateContact(contact).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    getMvpView().showContactInformation(contact);
                }, throwable -> {
                    getMvpView().onError("Some error!");
                }));
    }

    @Override
    public void contactLoaded(Contact contact) {
        this.contact = contact;
        getMvpView().showContactInformation(contact);
    }
}
