package com.example.anitime;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.anitime.databinding.ActivityMainBinding;

public class Pet_details extends AppCompatActivity {
    //private ActivityMainBinding binding;
    //int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_details);
        //binding = DataBindingUtil.setContentView(this, R.layout.pet_details);
    }
}