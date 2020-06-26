package com.example.contactsapp.Views;


import com.example.contactsapp.base_views.ObservableViewMvc;

public interface ContactsListMVCInter extends ObservableViewMvc<ContactsListMVCInter.Listener> {

    interface Listener{
        void onClick();
    }

    void bindData();

}
