package com.example.appplaceholder_v20.modulos.home.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appplaceholder_v20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}