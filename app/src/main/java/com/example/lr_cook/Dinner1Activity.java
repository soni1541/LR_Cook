package com.example.lr_cook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Dinner1Activity extends AppCompatActivity {

    Button btn_start;

    long minutes;

    private TextView timer_text_view;

    CountDownTimer timer;

    private Vibrator vibrator;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner1);

        btn_start = findViewById(R.id.button_start_lunch1);
        timer_text_view = findViewById(R.id.textView_timer_lunch1);

        minutes = 420000;
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timer!=null)
                {
                    timer.cancel();
                    timer = null;
                    timer_text_view.setText("07:00");

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

                        mediaPlayer = MediaPlayer.create(view.getContext(),R.raw.timer);

                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer = MediaPlayer.create(view.getContext(),R.raw.timer);
                        }
                        mediaPlayer.start();

                        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            long[] pattern = {0, 400, 200, 400, 200, 400, 200, 400};
                            vibrator.vibrate(VibrationEffect.createWaveform(pattern,-1));
                        }
                        else {
                            vibrator.vibrate(5000);
                        }

                        btn_start.setText(getString(R.string.start));
                        btn_start.setBackgroundColor(Color.parseColor("#FF9800"));
                    }
                };
                timer.start();
            }
        });
    }
}