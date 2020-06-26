package com.example.contactsapp.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "contactItem")
public class ContactItemEntity implements Serializable {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;
    @ColumnInfo(name = "first_name")
    private String first_name;
    @ColumnInfo(name = "last_name")
    private String last_name;
    @ColumnInfo(name = "address")
    private String address;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "phone_number")
    private Integer phone_number;

    public ContactItemEntity(Integer id, String first_name, String last_name, String address, String email, Integer phone_number) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.email = email;
        this.phone_number = phone_number;
    }

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPhone_number() {
        return phone_number;
    }
}