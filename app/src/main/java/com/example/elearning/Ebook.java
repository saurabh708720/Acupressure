package com.example.elearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.joanzapata.pdfview.PDFView;

public class Ebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);
        PDFView pafView = findViewById(R.id.pdfviews);
        pafView.fromAsset("ebookss.pdf").load();

    }
}