package com.example.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.contactsapp.Views.ContactsListMVC;
import com.example.contactsapp.Views.ContactsListMVCInter;

public class MainActivity extends AppCompatActivity implements ContactsListMVC.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContactsListMVCInter contactsMVC = new ContactsListMVC(LayoutInflater.from(this),null);
        contactsMVC.registerListener(this);
        setContentView(contactsMVC.getRootView());

    }

    @Override
    public void onClick() {

    }
}
