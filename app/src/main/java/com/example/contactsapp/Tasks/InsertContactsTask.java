package com.example.contactsapp.Tasks;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.contactsapp.Room.ContactItemEntity;
import com.example.contactsapp.Room.ContactsDatabase;

import java.util.List;

public class InsertContactsTask extends AsyncTask<Void,Void,long[]> {

    ContactsDatabase movieDatabase;
    List<ContactItemEntity> contactItemEntities;
    ContactItemEntity[] contactItemEntities1;


    public InsertContactsTask(ContactsDatabase movieDatabase, List<ContactItemEntity> contactItemEntities) {
        this.movieDatabase = movieDatabase;
        this.contactItemEntities = contactItemEntities;
        contactItemEntities1 = new ContactItemEntity[contactItemEntities.size()];
        contactItemEntities.toArray(contactItemEntities1);
        Log.d("contactinsert",contactItemEntities1[0].getFirst_name());
    }

    @Override
    protected long[] doInBackground(Void... voids) {
        long[] num = movieDatabase.contactsDAO().insertAllContacts(contactItemEntities1);
        return num;
    }

    @Override
    protected void onPostExecute(long[] aVoid) {
        Log.d("in task insert", String.valueOf(aVoid[0]));
    }
}
