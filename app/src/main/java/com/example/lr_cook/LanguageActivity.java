package com.example.lr_cook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {

    Button btn_ru;
    Button btn_en;
    Button btn_fr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        btn_ru = findViewById(R.id.button_id_ru);
        btn_en = findViewById(R.id.button_id_en);
        btn_fr = findViewById(R.id.button_id_fr);

        btn_ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_language("ru");
            }
        });

        btn_en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_language("en");
            }
        });

        btn_fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_language("fr");
            }
        });
    }

    private void set_language(String language_code){
        Resources resources = this.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale = new Locale(language_code);
        Locale.setDefault(locale);
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        Intent intent = new Intent(LanguageActivity.this, MainActivity.class);
        startActivity(intent);
    }
}