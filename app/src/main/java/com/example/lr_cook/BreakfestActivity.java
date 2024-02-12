package com.example.lr_cook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BreakfestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfest);
    }

    public void show_breakfest1(View view)
    {
        Intent intent = new Intent(BreakfestActivity.this, Breakfest1Activity.class);
        startActivity(intent);
    }
    public void show_breakfest2(View view)
    {
        Intent intent = new Intent(BreakfestActivity.this, Breakfest2Activity.class);
        startActivity(intent);
    }
    public void show_breakfest3(View view)
    {
        Intent intent = new Intent(BreakfestActivity.this, Breakfest3Activity.class);
        startActivity(intent);
    }
}