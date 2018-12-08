package com.example.saad.traveljournal;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Trips extends AppCompatActivity {

    ImageView img;
    private static Bitmap Image = null;
    private static final int GALLERY = 1;
    private static final int LOCATION = 2;
    Uri mImageUri;
    EditText edt;
    EditText edt2;
    Button btn;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private DatabaseReference reference;
    public static final String path_storage="image/";
    String uid;
    Spinner spn;
    RatingBar rtn;
    String spinner;
    String description;
    String location;
    Float rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);

        img=findViewById(R.id.pic);
        edt=findViewById(R.id.loc);
        btn=findViewById(R.id.upload);
        edt2=findViewById(R.id.desc);
        spn=findViewById(R.id.spinner1);
        rtn=findViewById(R.id.ratingbar);
        mStorageRef= FirebaseStorage.getInstance().getReference();

        mDatabaseRef= FirebaseDatabase.getInstance().getReference();

        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                img.setImageBitmap(null);
                if (Image != null)
                    Image.recycle();
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERY);

            }
        });
        edt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivityForResult(intent,LOCATION);

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                location=edt.getText().toString();
                description=edt2.getText().toString();
                spinner=spn.getSelectedItem().toString();
                rating=rtn.getRating();

                if (mImageUri != null) {
                    StorageReference ref = mStorageRef.child(path_storage + System.currentTimeMillis() + "." + getImgExt(mImageUri));

                    ref.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Toast.makeText(getApplicationContext(), "Succesfully uploaded picture.",
                                    Toast.LENGTH_SHORT).show();
                            String downloadURL = taskSnapshot.getDownloadUrl().toString();

                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            uid = user.getUid();
                            if (spinner.equals("With In City")) {
                                reference = mDatabaseRef.child("Users").child(uid).child("WithInCity");
                            } else if (spinner.equals("Out Of City")) {

                                reference = mDatabaseRef.child("Users").child(uid).child("OutOfCity");


                            } else {
                                reference = mDatabaseRef.child("Users").child(uid).child("OutOfState");

                            }

                            Post p = new Post(downloadURL, description, location, rating);

                            reference.push().setValue(p);

                            Intent intent = new Intent(getApplicationContext(), Diary.class);
                            finish();
                            startActivity(intent);
                        }

                    });


                }

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GALLERY && resultCode != 0) {
            mImageUri = data.getData();
            try {
                Image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), mImageUri);
                img.setImageBitmap(Image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(requestCode==LOCATION && resultCode != 0) {
            String x=data.getStringExtra("result");
            edt.setText(x);
        }
    }

    public String getImgExt(Uri uri)   //to get .jpeg etc
    {
        ContentResolver contentResolver=getContentResolver();
        MimeTypeMap mimeTypeMap= MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }


}

