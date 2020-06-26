package com.example.contactsapp.Factories;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.contactsapp.ViewModel.ContactsViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private Context context;
    private LifecycleOwner lifecycleOwner;

    public ViewModelFactory(Context context,LifecycleOwner lifecycleOwner) {
        this.context = context;
        this.lifecycleOwner = lifecycleOwner;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if(modelClass == ContactsViewModel.class){
            return (T) new ContactsViewModel(context,lifecycleOwner);
        }
        else {
            throw new RuntimeException("View model class not available");
        }
    }
}