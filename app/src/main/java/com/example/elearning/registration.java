package com.example.elearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registration extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText emails, passwords;
    private Button button, buttons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);



        mAuth = FirebaseAuth.getInstance();
        emails = findViewById(R.id.singupemail);
        passwords = findViewById(R.id.ainguppass);
        button = findViewById(R.id.singupbtn);
        buttons = findViewById(R.id.loginupbtn);


        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(registration.this,login.class);
                startActivity(intent);
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

    }
    private void createUser(){
        String email = emails.getText().toString();
        String password = passwords.getText().toString();
        if (TextUtils.isEmpty(email)){
            emails.setError("Email cannot be empty");
            emails.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            passwords.setError("password cannot be empty");
            passwords.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(registration.this, "User Registered Sucessfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(registration.this,login.class));
                    } else{
                        Toast.makeText(registration.this, "Registration Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}