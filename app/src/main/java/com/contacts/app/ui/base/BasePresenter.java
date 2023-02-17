package com.contacts.app.ui.base;


import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


public class BasePresenter<V extends MvpView, I extends MvpInteractor>
        implements MvpPresenter<V, I> {

    private static final String TAG = "BasePresenter";

    private final CompositeDisposable mCompositeDisposable;

    private V mMvpView;
    private I mMvpInteractor;

    @Inject
    public BasePresenter(I mvpInteractor,
                         CompositeDisposable compositeDisposable) {
        mMvpInteractor = mvpInteractor;
        mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mMvpView = null;
        mMvpInteractor = null;
    }

    @Override
    public V getMvpView() {
        return mMvpView;
    }

    @Override
    public I getInteractor() {
        return mMvpInteractor;
    }

    @Override
    public boolean isViewAttached() {
        return mMvpView != null;
    }

    @Override
    public void checkViewAttached() throws MvpViewNotAttachedException {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
