package com.example.contactsapp.Repository;


import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.example.contactsapp.Room.ContactItemEntity;
import com.example.contactsapp.Room.ContactsDatabase;
import com.example.contactsapp.Tasks.GetContactsTask;
import com.example.contactsapp.Tasks.InsertContactsTask;

import java.util.ArrayList;
import java.util.List;

public class ContactsRepo implements GetContactsTask.Listener {

   private MediatorLiveData<List<ContactItemEntity>> contacts = new MediatorLiveData<>();
   private ContactsDatabase contactsDatabase;
   private List<ContactItemEntity> contactItemEntities =  new ArrayList<>();
   private LifecycleOwner lifecycleOwner;


    public ContactsRepo(Context context,LifecycleOwner lifecycleOwner) {

        this.lifecycleOwner = lifecycleOwner;
        this.contactsDatabase = ContactsDatabase.getDB(context);
        ContactItemEntity contactItemEntity = new ContactItemEntity(1,"sdf","sdf","sdfsd","sdfdsf",12342);
        contactItemEntities.add(contactItemEntity);
    }


    public LiveData<List<ContactItemEntity>> getContactsList() {
        fetchContacts();
        return contacts;
    }

    // db returned value
    @Override
    public void gotContactListfromDB(LiveData<List<ContactItemEntity>> movieItemEntities) {
       movieItemEntities.observe(lifecycleOwner, new Observer<List<ContactItemEntity>>() {
           @Override
           public void onChanged(List<ContactItemEntity> contactItemEntities) {
               contacts.postValue(contactItemEntities);
           }
       });
    }

    public void fetchContacts(){
        GetContactsTask getContactsTask = new GetContactsTask(contactsDatabase,this);
        getContactsTask.execute();
    }

    public void insertContacts() {
        Log.d("insert","in here");
        InsertContactsTask insertContactsTask = new InsertContactsTask(contactsDatabase,contactItemEntities);
        insertContactsTask.execute();

    }
}
