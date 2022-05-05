package com.example.elearning;

import com.google.firebase.firestore.auth.User;

public class users {
    String Name, Email, Date_Of_Booking;

    public users(){}

    public users(String name, String email, String date_Of_Booking) {
        Name = name;
        Email = email;
        Date_Of_Booking = date_Of_Booking;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDate_Of_Booking() {
        return Date_Of_Booking;
    }

    public void setDate_Of_Booking(String date_Of_Booking) {
        Date_Of_Booking = date_Of_Booking;
    }
}
