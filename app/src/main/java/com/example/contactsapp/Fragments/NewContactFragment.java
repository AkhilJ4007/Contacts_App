package com.example.contactsapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.contactsapp.R;
import com.example.contactsapp.Room.ContactItemEntity;

public class NewContactFragment extends Fragment {
    TextView firstName;
    TextView lastName;

    TextView email;

    TextView phone;

    Button submit;

    public interface Listener{
        void detailsEntered(ContactItemEntity contactItemEntity);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.new_contact_layout,container,false);
        firstName = v.findViewById(R.id.firstNameText);
        lastName = v.findViewById(R.id.lastNameText);
        email = v.findViewById(R.id.email);
        phone = v.findViewById(R.id.phoneNumber);
        submit = v.findViewById(R.id.submit);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               getActivity().onBackPressed();

            }
        });

    }


}
