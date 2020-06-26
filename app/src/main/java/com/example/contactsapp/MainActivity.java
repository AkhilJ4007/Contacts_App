package com.example.contactsapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import com.example.contactsapp.Fragments.MainFragment;
import com.example.contactsapp.Fragments.NewContactFragment;
import com.example.contactsapp.Room.ContactItemEntity;
import com.example.contactsapp.ViewModel.ContactsViewModel;
import com.example.contactsapp.Views.ContactsListMVC;
import com.example.contactsapp.Views.ContactsListMVCInter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainFragment.Listener,NewContactFragment.Listener{

    ContactsViewModel contactsViewModel;
    ContactsListMVCInter contactsMVC;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainFragment mainFragment = new MainFragment();
        mainFragment.addListener(this);
        goToFragment(mainFragment);
        setContentView(R.layout.wrapper_layout);
    }


    public void goToFragment(Fragment fragment){
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        Log.d("back stack",String.valueOf(getBackStackEntry()));

    }

    public int getBackStackEntry(){
        return fragmentManager.getBackStackEntryCount();
    }

    @Override
    public void OnClickList(String s) {
        switch (s){
            case "FAB":
                NewContactFragment newContactFragment = new NewContactFragment();
                goToFragment(newContactFragment);
                break;
            case "recycler":
                Log.d("clcik","recycler");
                break;

        }
    }

    @Override
    public void onBackPressed() {
        int count = getBackStackEntry();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }


    @Override
    public void detailsEntered(ContactItemEntity contactItemEntity) {

    }
}
