package com.example.saad.traveljournal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    Button btn;
    EditText Email;
    EditText Password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Email = findViewById(R.id.email2);
        Password = findViewById(R.id.password2);
        btn = findViewById(R.id.button2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                signUp(email, password);
            }
        });

        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();


    }

    private void signUp(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            // Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "User created succesfully.",
                                    Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            finish();
                            startActivity(i);
                            // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            // Log.w(TAG, "signInWithEmail:failure", task.getException());
                            //
                            // updateUI(null);
                            Toast.makeText(getApplicationContext(), "User created Failed."+task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });




    }
}
