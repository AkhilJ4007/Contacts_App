package com.example.contactsapp.ViewModel;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.example.contactsapp.Repository.ContactsRepo;
import com.example.contactsapp.Room.ContactItemEntity;

import java.util.List;

public class ContactsViewModel extends ViewModel {

    private static ContactsViewModel contactsViewModel = null;
    private ContactsRepo contactsRepo;

    public ContactsViewModel(Context context, LifecycleOwner lifecycleOwner){
        contactsRepo = new ContactsRepo(context,lifecycleOwner);
    }


    public LiveData<List<ContactItemEntity>> getContactsList(){
        return contactsRepo.getContactsList();
    }


    public void insertContacts(){
        contactsRepo.insertContacts();
    }




}
