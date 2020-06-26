package com.example.contactsapp.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ContactItemEntity.class}, version = 2, exportSchema = false)
public abstract class ContactsDatabase extends RoomDatabase {
    private static String DB_Name = "ContactsDB";

    private static ContactsDatabase contactsDatabase;

    public static synchronized ContactsDatabase getDB(Context context){
        if (contactsDatabase==null){
            contactsDatabase = Room.databaseBuilder(context,ContactsDatabase.class,DB_Name).fallbackToDestructiveMigration().build();
        }
        return contactsDatabase;
    }

    public abstract ContactsDAO contactsDAO();

}
