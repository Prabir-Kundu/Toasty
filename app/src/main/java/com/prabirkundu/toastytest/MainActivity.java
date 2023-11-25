package com.prabirkundu.toastytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.prabirkundu.toasty.Toaster;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toaster.simpleToast(MainActivity.this,"This is toasty :)");
    }
}