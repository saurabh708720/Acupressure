package com.example.elearning;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class AppointmentHistory extends AppCompatActivity {


    FirebaseFirestore db;
    RecyclerView recyclerView;
    ArrayList<users>usersArrayList;
    myAdapter MyAdapter;
    String userid;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_history);

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data...");
        progressDialog.show();

        recyclerView = findViewById(R.id.recyclerViewss);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        usersArrayList = new ArrayList<users>();
        MyAdapter = new myAdapter(AppointmentHistory.this,usersArrayList);
        recyclerView.setAdapter(MyAdapter);


        EventChangeListner();



    }

    private void EventChangeListner() {

        db.collection("Booking Details")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error!=null){
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                            Log.e("Error",error.getMessage());
                            return;
                        }

                        for(DocumentChange dc: value.getDocumentChanges()){
                            if (dc.getType()==DocumentChange.Type.ADDED){
                                usersArrayList.add(dc.getDocument().toObject(users.class));

                            }

                        }

                    }
                });
    }
}