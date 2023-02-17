package com.contacts.app.data.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.contacts.app.data.database.model.Contact;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;


@Dao
public interface ContactDao {

    @Insert
    Completable insert(Contact contact);

    @Update
    Completable update(Contact contact);

    @Delete
    Completable delete(Contact contact);

    @Query("SELECT * FROM " + DBConstants.CONTACTS_TABLE_NAME + " ORDER BY id DESC")
    public Observable<List<Contact>> getAllContacts();

}
