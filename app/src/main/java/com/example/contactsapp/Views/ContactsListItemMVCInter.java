package com.example.contactsapp.Views;

import com.example.contactsapp.base_views.ObservableViewMvc;

public interface ContactsListItemMVCInter extends ObservableViewMvc<ContactsListItemMVCInter.Listener> {

    interface Listener{
        void onClick();
    }
    void bindMovies();
}
