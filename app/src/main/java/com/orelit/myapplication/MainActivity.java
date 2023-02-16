package com.orelit.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.orelit.myapplication.activity.NewsActivity;

public class MainActivity extends AppCompatActivity {

    Handler timer = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this,NewsActivity.class);
                startActivity(i);
                finish();

            }
        },5000);
    }


}