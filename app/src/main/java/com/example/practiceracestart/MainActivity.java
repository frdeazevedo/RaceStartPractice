package com.example.practiceracestart;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        this.light1 = (CircleView)findViewById(R.id.light1);
        this.light2 = (CircleView)findViewById(R.id.light2);
        this.light3 = (CircleView)findViewById(R.id.light3);
        this.light4 = (CircleView)findViewById(R.id.light4);
        this.light5 = (CircleView)findViewById(R.id.light5);

        this.beepPlayer = MediaPlayer.create(this, R.raw.beep);
        this.longBeepPlayer = MediaPlayer.create(this, R.raw.longbeep);

        this.startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLights();
            }
        });
    }

    protected void startLights() {
        int randomTime = 500+ (new Random().nextInt(3001));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.light1.setColor(MainActivity.redColorHex);
                MainActivity.light1.invalidate();
                MainActivity.beepPlayer.start();
            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.light2.setColor(MainActivity.redColorHex);
                MainActivity.light2.invalidate();
                MainActivity.beepPlayer.start();
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.light3.setColor(MainActivity.redColorHex);
                MainActivity.light3.invalidate();
                MainActivity.beepPlayer.start();
            }
        }, 3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.light4.setColor(MainActivity.redColorHex);
                MainActivity.light4.invalidate();
                MainActivity.beepPlayer.start();
            }
        }, 4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.light5.setColor(MainActivity.redColorHex);
                MainActivity.light5.invalidate();
                MainActivity.beepPlayer.start();
            }
        }, 5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.light1.setColor(MainActivity.greenColorHex);
                MainActivity.light1.invalidate();
                MainActivity.light2.setColor(MainActivity.greenColorHex);
                MainActivity.light2.invalidate();
                MainActivity.light3.setColor(MainActivity.greenColorHex);
                MainActivity.light3.invalidate();
                MainActivity.light4.setColor(MainActivity.greenColorHex);
                MainActivity.light4.invalidate();
                MainActivity.light5.setColor(MainActivity.greenColorHex);
                MainActivity.light5.invalidate();
                MainActivity.longBeepPlayer.start();
            }
        }, 5000+randomTime);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.light1.setColor(MainActivity.blackColorHex);
                MainActivity.light1.invalidate();
                MainActivity.light2.setColor(MainActivity.blackColorHex);
                MainActivity.light2.invalidate();
                MainActivity.light3.setColor(MainActivity.blackColorHex);
                MainActivity.light3.invalidate();
                MainActivity.light4.setColor(MainActivity.blackColorHex);
                MainActivity.light4.invalidate();
                MainActivity.light5.setColor(MainActivity.blackColorHex);
                MainActivity.light5.invalidate();
            }
        }, 8000+randomTime);
    }

    protected static CircleView light1;
    protected static CircleView light2;
    protected static CircleView light3;
    protected static CircleView light4;
    protected static CircleView light5;
    protected Button startButton;

    private static final String redColorHex = "#E74000";
    private static final String greenColorHex = "#00E740";
    private static final String blackColorHex = "#000000";

    private static MediaPlayer beepPlayer;
    private static MediaPlayer longBeepPlayer;
}