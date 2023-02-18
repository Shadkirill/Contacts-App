package com.contacts.app.ui.contact_info;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.contacts.app.R;
import com.contacts.app.data.database.model.Contact;
import com.contacts.app.databinding.FragmentContactInfoBinding;
import com.contacts.app.databinding.FragmentContactsListBinding;
import com.contacts.app.di.component.ActivityComponent;
import com.contacts.app.ui.base.BaseFragment;
import com.contacts.app.ui.contact_list.ContactsFragment;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;


public class ContactInfoFragment extends BaseFragment implements ContactInfoMvpView {

    public static final String TAG = ContactInfoFragment.class.getSimpleName();
    private static final String KEY_CONTACT = "key_contact";
    private static final int SELECT_PICTURE = 201;

    @Inject
    ContactInfoMvpPresenter<ContactInfoMvpView, ContactInfoMvpInteractor> presenter;

    private FragmentContactInfoBinding binding;

    public static ContactInfoFragment newInstance(Contact contact) {
        Bundle args = new Bundle();
        args.putParcelable(KEY_CONTACT, contact);
        ContactInfoFragment fragment = new ContactInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Contact contact = getArguments().getParcelable(KEY_CONTACT);
        binding = FragmentContactInfoBinding.inflate(inflater, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            presenter.onAttach(this);
            presenter.contactLoaded(contact);
        }
        return binding.getRoot();
    }

    @Override
    protected void setUp(View view) {
        binding.buttonFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.favouriteButtonCLicked();
            }
        });
        binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.avatarClicked();;
            }
        });
    }

    @Override
    public void showContactInformation(Contact contact) {
        binding.textViewFirstName.setText(contact.getFirstName());
        binding.textViewSecondName.setText(contact.getLastName());
        binding.textViewEmail.setText("Email: " + contact.getEmail());
        binding.textViewGender.setText("Gender: " + contact.getGender());
        Glide
                .with(this)
                .load(contact.getAvatarUri())
                .placeholder(R.drawable.avatar_placeholder)
                .into(binding.imageView);
        if (contact.getFavourite()) {
            binding.buttonFavourite.setText("Remove");
        } else {
            binding.buttonFavourite.setText("ADD");
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void changeAvatar() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"), SELECT_PICTURE);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == SELECT_PICTURE) {
            Uri imageUri = data.getData();
            presenter.avatarChanged(imageUri);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
