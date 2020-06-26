package com.example.contactsapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.contactsapp.Factories.ViewModelFactory;
import com.example.contactsapp.Room.ContactItemEntity;
import com.example.contactsapp.ViewModel.ContactsViewModel;
import com.example.contactsapp.Views.ContactsListMVC;
import com.example.contactsapp.Views.ContactsListMVCInter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactsListMVC.Listener {

    ContactsViewModel contactsViewModel;
    ContactsListMVCInter contactsMVC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactsMVC = new ContactsListMVC(LayoutInflater.from(this),null);
        contactsMVC.registerListener(this);
        setContentView(contactsMVC.getRootView());
        ViewModelFactory viewModelFactory = new ViewModelFactory(this,this);
        contactsViewModel = viewModelFactory.create(ContactsViewModel.class);
        //contactsViewModel.insertContacts();
        contactsViewModel.getContactsList().observe(this, new Observer<List<ContactItemEntity>>() {
            @Override
            public void onChanged(List<ContactItemEntity> contactItemEntities) {
                Log.d("in change",contactItemEntities.get(0).getAddress());
                contactsMVC.bindData(contactItemEntities);
            }
        });
    }



    public void onClick() {
        Log.d("click", "in clcik");
    }

}
