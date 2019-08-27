package com.example.fragmentruntimeexample;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    Button button;
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        button = view.findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment();
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,secondFragment,null).addToBackStack(null).commit();
            }
        });
        return view;
    }

}
