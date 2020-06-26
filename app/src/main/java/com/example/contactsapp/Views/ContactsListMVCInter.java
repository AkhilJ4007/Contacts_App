package com.example.contactsapp.Views;


import com.example.contactsapp.Room.ContactItemEntity;
import com.example.contactsapp.base_views.ObservableViewMvc;

import java.util.List;

public interface ContactsListMVCInter extends ObservableViewMvc<ContactsListMVCInter.Listener> {

    interface Listener{
        void onClick(String s);
    }

    void bindData(List<ContactItemEntity> contactItemEntities);

}
