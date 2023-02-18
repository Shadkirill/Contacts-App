package com.contacts.app.ui.contact_info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.contacts.app.data.database.model.Contact;
import com.contacts.app.databinding.FragmentContactsListBinding;
import com.contacts.app.di.component.ActivityComponent;
import com.contacts.app.ui.base.BaseFragment;
import com.contacts.app.ui.contact_list.ContactsFragment;
import java.util.List;

import javax.inject.Inject;

public class ContactInfoFragment extends BaseFragment implements ContactInfoMvpView {

    public static final String TAG = ContactInfoFragment.class.getSimpleName();

    @Inject
    ContactInfoMvpPresenter<ContactInfoMvpView, ContactInfoMvpInteractor> presenter;

    private FragmentContactsListBinding binding;

    public static ContactInfoFragment newInstance() {
        Bundle args = new Bundle();
        ContactInfoFragment fragment = new ContactInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentContactsListBinding.inflate(inflater, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            presenter.onAttach(this);
            contactsAdapter.setItemClickListener(this);
        }
        return binding.getRoot();
    }

    @Override
    protected void setUp(View view) {
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.recyclerView.getContext(),
                layoutManager.getOrientation());
        binding.recyclerView.addItemDecoration(dividerItemDecoration);
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.setAdapter(contactsAdapter);
        presenter.onViewPrepared();
    }

    @Override
    public void updateContacts(List<Contact> contactsList) {
        contactsAdapter.addItems(contactsList);
        showMessage("" + contactsList.size());
    }


    @Override
    public void onItemClick(Contact contact) {
        ((ContactsFragment.ContactActionsHandler)getBaseActivity()).contactClicked(contact);
    }

    public interface ContactActionsHandler {
        void contactClicked(Contact contact);
    }

    @Override
    public void updateContacts(List<Contact> contactsList) {

    }
}
