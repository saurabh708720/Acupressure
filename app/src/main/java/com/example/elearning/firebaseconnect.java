package com.example.elearning;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class firebaseconnect {

    private DatabaseReference databaseReference;
    public firebaseconnect(){
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        databaseReference = db.getReference(gethelp.class.getSimpleName());
    }
    public Task<Void> add(gethelp gh){
        return databaseReference.push().setValue(gh);
    }
}
