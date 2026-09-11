package com.example.appplaceholder_v20.modulos.home.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appplaceholder_v20.databinding.ActivityMainBinding
import com.example.appplaceholder_v20.modulos.comment.ui.Comments
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners() {
        with(binding){
            cardSalir.setOnClickListener {
                finish()
            }
            cardComments.setOnClickListener {
                val intent = Intent(this@MainActivity, Comments::class.java)
                startActivity(intent)
            }
        }
    }

}