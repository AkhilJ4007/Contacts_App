package com.example.contactsapp.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ContactsDAO {

    @Query("SELECT * FROM contactItem")
    LiveData<List<ContactItemEntity>> getContactsList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertAllContacts(ContactItemEntity... items);

}
