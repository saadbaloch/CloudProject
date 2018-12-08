package com.example.saad.traveljournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Update extends AppCompatActivity {

    EditText name;
    EditText age;
    EditText city;
    EditText country;
    EditText phone;
    Button btn;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        name=findViewById(R.id.name1);
        age=findViewById(R.id.age1);
        city=findViewById(R.id.city1);
        country=findViewById(R.id.country1);
        phone=findViewById(R.id.phone1);
        btn=findViewById(R.id.upbutton);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid= user.getUid();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
         ref= database.getReference("Users/"+uid+"/Profile");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               //  Toast.makeText(getApplicationContext(), "On data changed", Toast.LENGTH_SHORT).show();
                ProfileInfo pro = dataSnapshot.getValue(ProfileInfo.class);

                name.setText(pro.getName());
                age.setText(pro.getAge());
                city.setText(pro.getCity());
                country.setText(pro.getCountry());
                phone.setText(pro.getPhone());


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });


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
