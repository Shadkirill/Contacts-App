package com.contacts.app.ui.contact_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.contacts.app.R;
import com.contacts.app.data.database.model.Contact;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    private List<Contact> contactsList;
    private ItemClickListener itemClickListener;

    public ContactsAdapter(List<Contact> contactsList) {
        this.contactsList = contactsList;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContactViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactsList.get(position);
        holder.firstNameTextView.setText(contact.getFirstName());
        holder.secondNameTextView.setText(contact.getLastName());
        Glide
                .with(holder.itemView.getContext())
                .load(contact.getAvatar())
                .centerCrop()
                .placeholder(R.drawable.avatar_placeholder)
                .into(holder.imageView);
        holder.itemView.setOnClickListener(view -> {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(contact);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (contactsList != null && contactsList.size() > 0) {
            return contactsList.size();
        } else {
            return 0;
        }
    }

    public void addItems(List<Contact> contactsList) {
        this.contactsList.addAll(contactsList);
        notifyDataSetChanged();
    }

    public interface Callback {
        void onBlogEmptyViewRetryClick();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView firstNameTextView;
        TextView secondNameTextView;
        ImageView imageView;

        public ContactViewHolder(View itemView) {
            super(itemView);
            firstNameTextView = itemView.findViewById(R.id.text_view_first_name);
            secondNameTextView = itemView.findViewById(R.id.text_view_second_name);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }

    interface ItemClickListener {
        void onItemClick(Contact contact);
    }
}
