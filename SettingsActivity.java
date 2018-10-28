package com.example.saad.cloud_project;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.Profile;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageView img= findViewById(R.id.imageView);
        EditText editText= findViewById(R.id.editText2);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getApplicationContext());

        if (acct != null) {
            Toast.makeText(getApplicationContext(),"Through google.", Toast.LENGTH_SHORT).show();
            String personName = acct.getDisplayName();
            Uri personPhoto = acct.getPhotoUrl();

            editText.setText(personName);
            new ImageDownloaderAsync(img,getApplicationContext()).execute(acct.getPhotoUrl().toString());


        }

        else if(Profile.getCurrentProfile()!=null) {
            Toast.makeText(getApplicationContext(),"Through facebook.", Toast.LENGTH_SHORT).show();

            editText.setText(Profile.getCurrentProfile().getName());


        }

    }

    public void onClick()
    {

    }
}
