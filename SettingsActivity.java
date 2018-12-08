package com.example.saad.traveljournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SettingsActivity extends AppCompatActivity {

    EditText name;
    EditText age;
    EditText city;
    EditText country;
    EditText phone;
    private DatabaseReference mDatabaseRef;

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mDatabaseRef= FirebaseDatabase.getInstance().getReference();

        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        city=findViewById(R.id.city);
        country=findViewById(R.id.country);
        phone=findViewById(R.id.phone);
        btn=findViewById(R.id.svbutton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String name1= name.getText().toString().trim();
                 String age1= age.getText().toString().trim();
                 String city1= city.getText().toString().trim();
                 String country1= country.getText().toString().trim();
                 String phone1= phone.getText().toString().trim();

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid=user.getUid();

                DatabaseReference ref= mDatabaseRef.child("Users").child(uid).child("Profile");
                String key=ref.push().getKey();

                ProfileInfo prof=new ProfileInfo(uid,key,name1,age1,city1,country1,phone1);


                ref.setValue(prof);

                Intent i = new Intent(getApplicationContext(),Home.class);
                finish();
                startActivity(i);
            }
        });



    }
}
