package com.simple.ibnuqarib.api;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

@SuppressLint("Registered")
public class MainActivity extends AppCompatActivity {

    public static final String ROOT_URL = "http://192.168.43.177/suportivo-api/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
