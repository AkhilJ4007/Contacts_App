package com.example.contactsapp.Tasks;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.contactsapp.Room.ContactItemEntity;
import com.example.contactsapp.Room.ContactsDatabase;

import java.util.List;

public class GetContactsTask extends AsyncTask<Void,Void, LiveData<List<ContactItemEntity>>> {

    ContactsDatabase movieDatabase;
    Listener listener;

    public  interface Listener{
        void gotContactListfromDB(LiveData<List<ContactItemEntity>> movieItemEntities);
    }

    public GetContactsTask(ContactsDatabase movieDatabase, Listener listener) {
        this.movieDatabase = movieDatabase;
        this.listener = listener;
    }

    @Override
    protected LiveData<List<ContactItemEntity>> doInBackground(Void... voids) {
        return movieDatabase.contactsDAO().getContactsList();
    }

    @Override
    protected void onPostExecute(LiveData<List<ContactItemEntity>> listLiveData) {
        super.onPostExecute(listLiveData);
        listener.gotContactListfromDB(listLiveData);
    }
}
