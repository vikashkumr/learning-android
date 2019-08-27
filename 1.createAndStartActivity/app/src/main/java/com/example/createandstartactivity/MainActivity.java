package com.example.createandstartactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        //Intent is used to execute the intention of android eg. start new activity, send broadcast etc
        //it takes two argument context "this" in this case and target class
        Intent intent = new Intent(this,MessageActivity.class);

        //used to start activity takes intent object as argument
        startActivity(intent);
    }
}
