package com.example.appplaceholder_v20.modulos.todos.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appplaceholder_v20.databinding.ActivityTodosBinding
import com.example.appplaceholder_v20.modulos.todos.ui.adapter.TodosAdapter
import com.example.appplaceholder_v20.modulos.todos.ui.viewmodel.TodosViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Todos : AppCompatActivity() {

    private lateinit var binding: ActivityTodosBinding
    private val viewModel: TodosViewModel by viewModels()
    private val miAdaptador by lazy { TodosAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
        viewModel.initApp()

    }

    private fun initUi() {
        initRv()
        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.estado.collect { estado ->
                    if(!estado.lista.isNullOrEmpty()){
                        miAdaptador.submitList(estado.lista)
                    }
                }
            }
        }
    }

    private fun initRv() {
        with(binding.rvTodos){
            layoutManager = LinearLayoutManager(this@Todos)
            adapter = miAdaptador
        }
    }
}