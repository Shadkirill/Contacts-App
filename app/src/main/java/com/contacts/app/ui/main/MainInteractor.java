package com.contacts.app.ui.main;


import com.contacts.app.ui.base.BaseInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


public class MainInteractor extends BaseInteractor
        implements MainMvpInteractor {
    @Inject
    public MainInteractor() {}
    /*private QuestionRepository mQuestionRepository;

    @Inject
    public MainInteractor(PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper,
                          QuestionRepository questionRepository) {

        super(preferencesHelper, apiHelper);
        mQuestionRepository = questionRepository;
    }

    @Override
    public Observable<LogoutResponse> doLogoutApiCall() {
        return getApiHelper().doLogoutApiCall();
    }

    @Override
    public Observable<List<Question>> getAllQuestions() {
        return mQuestionRepository.getAllQuestions();
    }

    @Override
    public String getCurrentUserName() {
        return getPreferencesHelper().getCurrentUserName();
    }

    @Override
    public String getCurrentUserEmail() {
        return getPreferencesHelper().getCurrentUserEmail();
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return getPreferencesHelper().getCurrentUserProfilePicUrl();
    }
*/
}
