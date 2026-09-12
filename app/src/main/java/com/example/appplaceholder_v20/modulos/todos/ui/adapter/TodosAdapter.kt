package com.example.appplaceholder_v20.modulos.todos.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appplaceholder_v20.databinding.ItemTodosBinding
import com.example.appplaceholder_v20.modulos.todos.domain.model.DatosTodos
import javax.inject.Inject

class TodosAdapter@Inject constructor(

): ListAdapter<DatosTodos, TodosAdapter.TodosViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodosViewHolder {
        // 🔄 Inflamos el layout específico de la celda usando su propio Binding
        val binding = ItemTodosBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TodosViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TodosViewHolder,
        position: Int
    ) {
        val item = getItem(position)
        holder.render(item)
    }

    inner class TodosViewHolder(
        private val binding: ItemTodosBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun render(dato: DatosTodos){

            with(binding){
                tvUserId.text = dato.userId
                tvId.text = dato.id
                tvTitle.text = dato.title
                tvCompleted.text = dato.completed
            }
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<DatosTodos>(){
        override fun areItemsTheSame(
            oldItem: DatosTodos,
            newItem: DatosTodos
        ): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(
            oldItem: DatosTodos,
            newItem: DatosTodos
        ): Boolean {
            return newItem == oldItem
        }
    }
}