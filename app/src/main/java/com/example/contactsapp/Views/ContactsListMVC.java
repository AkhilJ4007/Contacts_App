package com.example.contactsapp.Views;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsapp.R;
import com.example.contactsapp.Room.ContactItemEntity;
import com.example.contactsapp.base_views.BaseObservableViewMvc;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.List;

public class ContactsListMVC extends BaseObservableViewMvc<ContactsListMVCInter.Listener> implements ContactsListMVCInter,MovieListAdapter.Listener {

    LayoutInflater layoutInflater;
    ViewGroup viewGroup;
    RecyclerView contactsList;
    MovieListAdapter movieListAdapter;
    MaterialToolbar topAppBar;


    public ContactsListMVC(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        setRootView(layoutInflater.inflate(R.layout.activity_main,viewGroup,false));
        contactsList = findViewById(R.id.contactsList);
        topAppBar = findViewById(R.id.topAppBar);
        movieListAdapter = new MovieListAdapter(layoutInflater,this);
        contactsList.setLayoutManager(new LinearLayoutManager(getContext()));
        contactsList.setAdapter(movieListAdapter);
        topAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d("menu",String.valueOf(item.getItemId()));
                switch (item.getItemId()){
                    case R.id.search:
                        Log.d("menu","search");
                        return true;
                    case R.id.more:
                        Log.d("menu","more");
                        return true;
                }

                return false;
            }
        });

    }

    // from activity
    @Override
    public void bindData(List<ContactItemEntity> contactItemEntities) {

        movieListAdapter.bindData(contactItemEntities);

    }

    //from rercycler adapter
    @Override
    public void onClick() {

        for(Listener listener:getListeners()){
            listener.onClick();
        }

    }
}
