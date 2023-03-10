package com.contacts.app.data.database.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.contacts.app.data.database.DBConstants;
import com.contacts.app.data.network.model.ContactResponseModel;

import java.util.Objects;

@Entity(tableName = DBConstants.CONTACTS_TABLE_NAME)
public class Contact implements Parcelable {

    public Contact(Integer id, String uid, String password, String firstName, String lastName, String username, String email, String avatar, String gender, String avatarFile, boolean isFavourite) {
        this.id = id;
        this.uid = uid;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.avatar = avatar;
        this.gender = gender;
        this.avatarFile = avatarFile;
        this.isFavourite = isFavourite;
    }

    public Contact(ContactResponseModel contactResponseModel) {
        this(
                contactResponseModel.getId(),
                contactResponseModel.getUid(),
                contactResponseModel.getPassword(),
                contactResponseModel.getFirstName(),
                contactResponseModel.getLastName(),
                contactResponseModel.getUsername(),
                contactResponseModel.getEmail(),
                contactResponseModel.getAvatar(),
                contactResponseModel.getGender(),
                null,
                false
        );
    }


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

    @ColumnInfo(name = DBConstants.CONTACT_AVATAR_FILE)
    private String avatarFile;

    private Boolean isFavourite;


    protected Contact(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        uid = in.readString();
        password = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        username = in.readString();
        email = in.readString();
        avatar = in.readString();
        gender = in.readString();
        avatarFile = in.readString();
        byte tmpIsFavourite = in.readByte();
        isFavourite = tmpIsFavourite == 0 ? null : tmpIsFavourite == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(uid);
        dest.writeString(password);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(username);
        dest.writeString(email);
        dest.writeString(avatar);
        dest.writeString(gender);
        dest.writeString(avatarFile);
        dest.writeByte((byte) (isFavourite == null ? 0 : isFavourite ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

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

    public Boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatarFile() {
        return avatarFile;
    }

    public Uri getAvatarUri() {
        if (Objects.nonNull(avatarFile)) {
            return Uri.parse(avatarFile);
        } else {
            return Uri.parse(avatar);
        }
    }

    public void setAvatarFile(String avatarFile) {
        this.avatarFile = avatarFile;
    }

}
