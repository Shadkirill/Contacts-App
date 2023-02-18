package com.contacts.app.ui.main;

import android.os.Bundle;

import com.contacts.app.R;
import com.contacts.app.data.database.model.Contact;
import com.contacts.app.ui.base.BaseActivity;
import com.contacts.app.ui.contact_info.ContactInfoFragment;
import com.contacts.app.ui.contact_list.ContactsFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.contacts.app.databinding.ActivityMainBinding;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView, ContactsFragment.ContactActionsHandler {

    @Inject
    MainMvpPresenter<MainMvpView, MainMvpInteractor> presenter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getActivityComponent().inject(this);
        presenter.onAttach(this);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public void contactClicked(Contact contact) {
        presenter.onContactClick(contact);
    }

    @Override
    public void showContactDetails(Contact contact) {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.fragment_container, ContactInfoFragment.newInstance(contact), ContactInfoFragment.TAG)
                .commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(ContactInfoFragment.TAG);
        if (fragment == null) {
            super.onBackPressed();
        } else {
            onFragmentDetached(ContactInfoFragment.TAG);
        }
    }

}