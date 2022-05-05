package com.example.elearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class supportpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supportpage);

        final EditText editText = findViewById(R.id.editTextTextPersonName);
        final EditText editPhone = findViewById(R.id.editTextPhone2);
        final EditText editEmail = findViewById(R.id.editTextTextEmailAddress2);
        final EditText editMsg = findViewById(R.id.editTextTextMultiLine);
        Button btn = findViewById(R.id.gethelpbtn);
        firebaseconnect fbconnect = new firebaseconnect();
        btn.setOnClickListener(v->{
            gethelp gh = new gethelp(editText.getText().toString(),editText.getText().toString(),editEmail.getText().toString(),editPhone.getText().toString());
            fbconnect.add(gh).addOnSuccessListener(suc->{
                Toast.makeText(this,"Request is Sent Successfully",Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();

            });



        });
    }
}