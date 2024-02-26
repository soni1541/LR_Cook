package com.example.lr_cook;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Lunch1Activity extends AppCompatActivity {

    Button btn_start;

    long minutes;

    private TextView timer_text_view;

    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch1);

        btn_start = findViewById(R.id.button_start_lunch1);
        timer_text_view = findViewById(R.id.textView_timer_lunch1);

        minutes = 2400000;
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timer!=null)
                {
                    timer.cancel();
                    timer = null;
                    timer_text_view.setText("40:00");

                    btn_start.setText(getString(R.string.start));
                    btn_start.setBackgroundColor(Color.parseColor("#FF9800"));

                    return;
                }
                btn_start.setText("Сброс");
                btn_start.setBackgroundColor(Color.BLACK);

                timer = new CountDownTimer(minutes, 1000) {
                    @Override
                    public void onTick(long l) {
                        NumberFormat f = new DecimalFormat("00");
                        long sec = l/1000;
                        long min = sec/60;
                        sec = sec%60;
                        String time = f.format(min) + ":" + f.format(sec);
                        timer_text_view.setText(time);
                    }

                    @Override
                    public void onFinish() {
                        btn_start.setText(getString(R.string.start));
                        btn_start.setBackgroundColor(Color.parseColor("#FF9800"));
                    }
                };
                timer.start();
            }
        });
    }
}