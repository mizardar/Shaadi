
package com.mizardar.shaaditest.model.network;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Result {
//
//    @PrimaryKey(autoGenerate = true)
//    @SerializedName("column_id_auto")
//    @Expose
//    private int column_id_auto;

    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("name")
    @Expose
    @Embedded(prefix = "name_")
    private Name name;
    @SerializedName("location")
    @Expose
    @Embedded(prefix = "location_")
    private Location location;
    @SerializedName("email")
    @Expose
    @PrimaryKey
    @NonNull
    private String email;
    @SerializedName("login")
    @Expose
    @Embedded(prefix = "login_")
    private Login login;
    @SerializedName("dob")
    @Expose
    @Embedded(prefix = "dob_")
    private Dob dob;
    @SerializedName("registered")
    @Expose
    @Embedded(prefix = "registered_")
    private Registered registered;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("cell")
    @Expose
    private String cell;
    @SerializedName("id")
    @Expose
    @Embedded(prefix = "id_")
    private Id id;
    @SerializedName("picture")
    @Expose
    @Embedded(prefix = "picture_")
    private Picture picture;
    @SerializedName("nat")
    @Expose
    private String nat;
    @SerializedName("isAccepted")
    @Expose
    private boolean isAccepted;
    @SerializedName("isDeclined")
    @Expose
    private boolean isDeclined;

//    public int getColumn_id_auto() {
//        return column_id_auto;
//    }
//
//    public void setColumn_id_auto(int column_id_auto) {
//        this.column_id_auto = column_id_auto;
//    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }

    public Registered getRegistered() {
        return registered;
    }

    public void setRegistered(Registered registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public boolean isDeclined() {
        return isDeclined;
    }

    public void setDeclined(boolean declined) {
        isDeclined = declined;
    }
}
