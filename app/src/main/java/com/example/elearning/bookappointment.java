package com.example.elearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class bookappointment extends AppCompatActivity {

    EditText mname, mage, madress, msex, mphoneno, memail, madate, msex2 ;
    Button msubmit;
    private Button buttonns;
    ArrayList<User> userArrayList;



    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookappointment);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        mname = findViewById(R.id.editTextTextPersonName3);
        mage = findViewById(R.id.editTextage);
        madress = findViewById(R.id.editadress);
        msex = findViewById(R.id.sex);
        mphoneno = findViewById(R.id.editmobileno);
        memail = findViewById(R.id.emailadresss);
        madate = findViewById(R.id.editTextDate);
        msubmit = findViewById(R.id.submitt);
        buttonns = findViewById(R.id.bookinghis);
        userArrayList = new ArrayList<User>();




        buttonns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bookappointment.this,AppointmentHistory.class);
                startActivity(intent);
            }
        });




        msubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = mname.getText().toString();
                String Age = mage.getText().toString();
                String Address = madress.getText().toString();
                String Sex = msex.getText().toString();
                String Phonon = mphoneno.getText().toString();
                String Email = memail.getText().toString();
                String Date = madate.getText().toString();

                CollectionReference userDataa = db.collection("Booking Details");
                Map <String, Object> user = new HashMap<>();
                user.put("Name", Name);
                user.put("Age", Age);
                user.put("Address", Address);
                user.put("Sex", Sex);
                user.put("Mobile No", Phonon);
                user.put("Email", Email);
                user.put("Date Of Booking", Date);
                userDataa.document("SF").set(user);



                db.collection("Booking Details")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(bookappointment.this, "Booked successfully",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(bookappointment.this, "Booking Failed",Toast.LENGTH_SHORT).show();

                    }
                });



            }
        });

    }
}