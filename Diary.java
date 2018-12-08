package com.example.saad.traveljournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Diary extends AppCompatActivity {

    Button btn;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        btn=findViewById(R.id.back);
        btn2=findViewById(R.id.withInCity);
        btn3=findViewById(R.id.upload);
        btn4=findViewById(R.id.outOfCity);
        btn5=findViewById(R.id.outOfState);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Home.class);
              //  finish();
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),WithInCity.class);
                //finish();
                startActivity(i);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Trips.class);
               // finish();
                startActivity(i);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),OutOfCity.class);
                //finish();
                startActivity(i);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),OutOfState.class);
               // finish();
                startActivity(i);
            }
        });




    }
}
