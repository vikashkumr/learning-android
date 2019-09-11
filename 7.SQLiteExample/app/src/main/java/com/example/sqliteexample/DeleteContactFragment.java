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
public class DeleteContactFragment extends Fragment {
    private EditText Delete_id;
    private Button Delete_bn;

    public DeleteContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_contact, container, false);
        Delete_id = view.findViewById(R.id.id_contact_delete);
        Delete_bn = view.findViewById(R.id.bn_save_delete);
        Delete_bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteContact();
            }
        });
        return view;
    }

    private void deleteContact(){
        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase database = contactDbHelper.getWritableDatabase();
        int id = Integer.parseInt(Delete_id.getText().toString());
        contactDbHelper.deleteContact(id,database);
        contactDbHelper.close();
        Delete_id.setText("");
        Toast.makeText(getActivity(), "contact deleted successfully...", Toast.LENGTH_SHORT).show();
    }

}
