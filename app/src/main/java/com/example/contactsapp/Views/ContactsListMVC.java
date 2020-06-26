package com.example.contactsapp.Views;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsapp.R;
import com.example.contactsapp.base_views.BaseObservableViewMvc;

public class ContactsListMVC extends BaseObservableViewMvc<ContactsListMVCInter.Listener> implements ContactsListMVCInter,MovieListAdapter.Listener {

    LayoutInflater layoutInflater;
    ViewGroup viewGroup;
    RecyclerView contactsList;
    MovieListAdapter movieListAdapter;


    public ContactsListMVC(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        setRootView(layoutInflater.inflate(R.layout.activity_main,viewGroup,false));
        contactsList = findViewById(R.id.contactsList);
        movieListAdapter = new MovieListAdapter(layoutInflater,this);
        contactsList.setLayoutManager(new LinearLayoutManager(getContext()));
        contactsList.setAdapter(movieListAdapter);

    }

    // from activity
    @Override
    public void bindData() {

    }

    //from rercycler adapter
    @Override
    public void onClick() {

        for(Listener listener:getListeners()){
            listener.onClick();
        }

    }
}
