package com.example.saad.traveljournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    Button btn;
    Button btn2;
    Button logout;
    Button diary;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn = findViewById(R.id.edit);
        btn2=findViewById(R.id.wish);
        logout = findViewById(R.id.logout);
        diary=findViewById(R.id.diary);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Update.class);
                finish();
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ExploreFairytale.class);
                finish();
                startActivity(i);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                finish();
                startActivity(i);
            }
        });

        diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Diary.class);
                finish();
                startActivity(i);
            }
        });




    }
}
