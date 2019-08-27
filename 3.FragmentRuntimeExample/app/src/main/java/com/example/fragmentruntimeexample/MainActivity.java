package com.example.fragmentruntimeexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        //to check whether a container is available or not
        if(findViewById(R.id.fragment_container)!=null){

            //to check whether any instance is running
            if(savedInstanceState!=null){
                //if running then return if forget this condition overlapping of fragment occur
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HomeFragment homeFragment = new HomeFragment();
            fragmentTransaction.add(R.id.fragment_container,homeFragment,null);
            fragmentTransaction.addToBackStack(null).commit();
        }
    }
}
