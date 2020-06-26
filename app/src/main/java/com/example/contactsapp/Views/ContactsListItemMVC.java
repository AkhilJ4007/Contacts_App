package com.example.contactsapp.Views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contactsapp.R;
import com.example.contactsapp.Room.ContactItemEntity;
import com.example.contactsapp.base_views.BaseObservableViewMvc;

public class ContactsListItemMVC extends BaseObservableViewMvc<ContactsListItemMVCInter.Listener> implements ContactsListItemMVCInter {

    private View rootView;
    private ImageView imageView;
    private TextView textView;
    public ContactsListItemMVC(ViewGroup viewGroup, LayoutInflater layoutInflater) {
        rootView = layoutInflater.inflate(R.layout.contact_item,viewGroup,false);
        setRootView(rootView);
        imageView = findViewById(R.id.contactImage);
        textView = findViewById(R.id.contactName);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Listener listener:getListeners()){
                    listener.onClick();
                }
            }
        });


    }

    @Override
    public void bindMovies(ContactItemEntity contactItemEntity) {

        textView.setText(contactItemEntity.getFirst_name());

    }
}
