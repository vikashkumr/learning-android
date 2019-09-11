package com.example.sqliteexample;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends Fragment {
    private Button bnSave;
    EditText Id,Name,Email;

    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);
        bnSave = view.findViewById(R.id.bn_save_delete);
        Id = view.findViewById(R.id.id_contact_update);
        Name = view.findViewById(R.id.name_contact_update);
        Email = view.findViewById(R.id.id_contact_delete);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = Id.getText().toString();
                String name = Name.getText().toString();
                String email = Email.getText().toString();

                ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
                SQLiteDatabase database = contactDbHelper.getWritableDatabase();
                contactDbHelper.addContact(Integer.parseInt(id),name,email,database);
                contactDbHelper.close(); //to close the database connection
                Id.setText("");
                Name.setText("");
                Email.setText("");
                Toast.makeText(getActivity(), "Contact saved successfully", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
