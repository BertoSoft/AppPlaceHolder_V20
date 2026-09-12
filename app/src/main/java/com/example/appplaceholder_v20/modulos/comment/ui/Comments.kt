package com.example.appplaceholder_v20.modulos.comment.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appplaceholder_v20.R
import com.example.appplaceholder_v20.databinding.ActivityCommentsBinding
import com.example.appplaceholder_v20.modulos.comment.ui.adapter.CommentsAdapter
import com.example.appplaceholder_v20.modulos.comment.ui.viewmodel.CommentsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class Comments() : AppCompatActivity() {

    private lateinit var binding: ActivityCommentsBinding
    private val viewModel: CommentsViewModel by viewModels()
    private val miAdapter by lazy { CommentsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
    }

    private fun initUi() {
        initRv()
        initObservers()
        viewModel.initApp()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.estado.collect { estado ->
                    if(!estado.lista.isNullOrEmpty()){
                        miAdapter.submitList(estado.lista)
                    }
                }
            }
        }

    }

    private fun initRv() {

        with(binding.rvComments){
            layoutManager = LinearLayoutManager(this@Comments)
            adapter = miAdapter
        }

    }
}