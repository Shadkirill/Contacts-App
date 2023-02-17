package com.contacts.app.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class ContactResponseModel {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("uid")
    @Expose
    private String uid;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("first_name")
    @Expose
    private String firstName;

    @SerializedName("last_name")
    @Expose
    private String lastName;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("avatar")
    @Expose
    private String avatar;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;

    @SerializedName("social_insurance_number")
    @Expose
    private String socialInsuranceNumber;

    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSocialInsuranceNumber() {
        return socialInsuranceNumber;
    }

    public void setSocialInsuranceNumber(String socialInsuranceNumber) {
        this.socialInsuranceNumber = socialInsuranceNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactResponseModel)) return false;
        ContactResponseModel contactResponseModel = (ContactResponseModel) o;
        return Objects.equals(id, contactResponseModel.id) && Objects.equals(uid, contactResponseModel.uid) && Objects.equals(password, contactResponseModel.password) && Objects.equals(firstName, contactResponseModel.firstName) && Objects.equals(lastName, contactResponseModel.lastName) && Objects.equals(username, contactResponseModel.username) && Objects.equals(email, contactResponseModel.email) && Objects.equals(avatar, contactResponseModel.avatar) && Objects.equals(gender, contactResponseModel.gender) && Objects.equals(phoneNumber, contactResponseModel.phoneNumber) && Objects.equals(socialInsuranceNumber, contactResponseModel.socialInsuranceNumber) && Objects.equals(dateOfBirth, contactResponseModel.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, password, firstName, lastName, username, email, avatar, gender, phoneNumber, socialInsuranceNumber, dateOfBirth);
    }
}
