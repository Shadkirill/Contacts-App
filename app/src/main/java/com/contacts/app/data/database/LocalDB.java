package com.contacts.app.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.contacts.app.data.database.model.Contact;

@Database(entities = {Contact.class}, version = 1, exportSchema = false)
public abstract class LocalDB extends RoomDatabase {

    public abstract ContactsDao contactsDao();

}
