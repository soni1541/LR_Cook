package com.example.lr_cook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void change_lang(View view) {
        Intent intent = new Intent(MainActivity.this, LanguageActivity.class);
        startActivity(intent);
    }
    public void show_breakfest(View view) {
        Intent intent = new Intent(MainActivity.this, BreakfestActivity.class);
        startActivity(intent);
    }
    public void show_lunch(View view) {
        Intent intent = new Intent(MainActivity.this, LunchActivity.class);
        startActivity(intent);
    }
    public void show_dinner(View view) {
        Intent intent = new Intent(MainActivity.this, DinnerActivity.class);
        startActivity(intent);
    }

}