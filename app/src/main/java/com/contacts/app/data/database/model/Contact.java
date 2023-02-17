package com.contacts.app.data.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.contacts.app.data.database.DBConstants;

@Entity(tableName = DBConstants.CONTACTS_TABLE_NAME)
public class Contact {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DBConstants.CONTACT_ID)
    private Integer id;

    @ColumnInfo(name = DBConstants.CONTACT_UID)
    private String uid;

    @ColumnInfo(name = DBConstants.CONTACT_PASSWORD)
    private String password;

    @ColumnInfo(name = DBConstants.CONTACT_FIRST_NAME)
    private String firstName;

    @ColumnInfo(name = DBConstants.CONTACT_LAST_NAME)
    private String lastName;

    @ColumnInfo(name = DBConstants.CONTACT_USERNAME)
    private String username;

    @ColumnInfo(name = DBConstants.CONTACT_EMAIL)
    private String email;

    @ColumnInfo(name = DBConstants.CONTACT_AVATAR)
    private String avatar;

    @ColumnInfo(name = DBConstants.CONTACT_GENDER)
    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
