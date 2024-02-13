package com.example.lr_cook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
    }

    public void show_lunch1(View view){
        Intent intent = new Intent(LunchActivity.this, Lunch1Activity.class);
        startActivity(intent);
    }
}