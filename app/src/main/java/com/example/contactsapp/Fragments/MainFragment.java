package com.example.contactsapp.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.contactsapp.Factories.ViewModelFactory;
import com.example.contactsapp.Room.ContactItemEntity;
import com.example.contactsapp.ViewModel.ContactsViewModel;
import com.example.contactsapp.Views.ContactsListMVC;
import com.example.contactsapp.Views.ContactsListMVCInter;

import java.util.List;

public class MainFragment extends Fragment implements ContactsListMVC.Listener  {

    ContactsViewModel contactsViewModel;
    ContactsListMVCInter contactsMVC;
    Listener listener;

    public interface Listener{
         void OnClickList(String s);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contactsMVC = new ContactsListMVC(inflater,container);
        contactsMVC.registerListener(this);

        ViewModelFactory viewModelFactory = new ViewModelFactory(getContext(),getActivity());
        contactsViewModel = viewModelFactory.create(ContactsViewModel.class);
        //contactsViewModel.insertContacts();
        contactsViewModel.getContactsList().observe(this, new Observer<List<ContactItemEntity>>() {
            @Override
            public void onChanged(List<ContactItemEntity> contactItemEntities) {
                if(contactItemEntities.size()>0) {
                    Log.d("in change", contactItemEntities.get(0).getAddress());
                    contactsMVC.bindData(contactItemEntities);
                }
            }
        });
        return  contactsMVC.getRootView();
    }

    public void onClick(String s) {
        listener.OnClickList(s);
    }

    public void addListener(Listener listener){
        this.listener = listener;
    }
}
