package com.example.elearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText emailss, passwordss;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        emailss = findViewById(R.id.loginemail);
        passwordss = findViewById(R.id.loginpass);
        button = findViewById(R.id.loginbtn);

        button.setOnClickListener(v -> {
            loginUser();

        });
    }
    private void loginUser(){
        String email = emailss.getText().toString();
        String password = passwordss.getText().toString();
        if (TextUtils.isEmpty(email)){
            emailss.setError("Email cannot be empty");
            emailss.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            passwordss.setError("password cannot be empty");
            passwordss.requestFocus();
        }else {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(login.this, "User login Sucessfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(login.this,MainActivity.class));
                    } else{
                        Toast.makeText(login.this, "login Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }

    }
}