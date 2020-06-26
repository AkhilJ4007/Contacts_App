package com.example.contactsapp.Views;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsapp.Room.ContactItemEntity;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> implements ContactsListItemMVCInter.Listener {

    Listener listener;
    LayoutInflater layoutInflater;
    private List<ContactItemEntity> contactItems = new ArrayList<>();


    // click from item
    @Override
    public void onClick() {
        listener.onClick();

    }

    public interface Listener{
        void onClick();
    }

    public MovieListAdapter(LayoutInflater layoutInflater, Listener listener) {
        this.layoutInflater = layoutInflater;
        this.listener = listener;
    }

    public void bindData(List<ContactItemEntity> contactItemEntities){
      this.contactItems = contactItemEntities;
      notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactsListItemMVCInter contactsListItemMVCInter = new ContactsListItemMVC(parent,layoutInflater);

        return new MyViewHolder(contactsListItemMVCInter);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.contactsListItemMVCInter.registerListener(this);
        holder.contactsListItemMVCInter.bindMovies(contactItems.get(position));

    }

    @Override
    public int getItemCount() {
        return contactItems != null ? contactItems.size(): 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ContactsListItemMVCInter contactsListItemMVCInter;

        public MyViewHolder(ContactsListItemMVCInter contactsListItemMVCInter) {
            super(contactsListItemMVCInter.getRootView());
            this.contactsListItemMVCInter = contactsListItemMVCInter;
        }
    }

}
