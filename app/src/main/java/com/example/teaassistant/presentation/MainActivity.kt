package com.example.teaassistant.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teaassistant.R
import com.example.teaassistant.presentation.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}