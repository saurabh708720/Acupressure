package com.example.elearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView bookappoint = findViewById(R.id.bookappointbtn);
        bookappoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,bookappointment.class);
                startActivity(intent);
            }
        });

        CardView elearnigbtn = findViewById(R.id.videolebtn);
        elearnigbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FirebaseVideoStreaming.class);
                startActivity(intent);
            }
        });

        CardView esupport = findViewById(R.id.supportbtn);
        esupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,supportpage.class);
                startActivity(intent);
            }
        });

        CardView chatboats = findViewById(R.id.chatbotbtn);
        chatboats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,chatbot.class);
                startActivity(intent);
            }
        });

        CardView ebooks = findViewById(R.id.ebookss);
        ebooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Ebook.class);
                startActivity(intent);
            }
        });


    }
}