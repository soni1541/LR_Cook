package com.example.lr_cook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);
    }

    public void show_dinner1(View view) {
        Intent intent = new Intent(DinnerActivity.this, Dinner1Activity.class);
        startActivity(intent);
    }
}