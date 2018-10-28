package com.example.saad.cloud_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.Profile;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       // TextView textView= findViewById(R.id.textView);
//        textView.setText(Profile.getCurrentProfile().getFirstName());
        Toast.makeText(getApplicationContext(), Profile.getCurrentProfile().getFirstName(), Toast.LENGTH_SHORT).show();

    }
}
