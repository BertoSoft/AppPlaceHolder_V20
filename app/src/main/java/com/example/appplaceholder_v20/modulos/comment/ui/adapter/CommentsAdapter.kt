package com.example.appplaceholder_v20.modulos.comment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appplaceholder_v20.databinding.ItemCommentsBinding
import com.example.appplaceholder_v20.modulos.comment.domain.model.DatosComments
import javax.inject.Inject

class CommentsAdapter @Inject constructor(

): ListAdapter<DatosComments, CommentsAdapter.CommentesViewHolder>(DiffCalckback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommentesViewHolder {
// 🔄 Inflamos el layout específico de la celda usando su propio Binding
        val binding = ItemCommentsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CommentesViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CommentesViewHolder,
        position: Int
    ) {
        val item = getItem(position)
        holder.render(item)    }

    inner class CommentesViewHolder(
        private val binding: ItemCommentsBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun render(dato: DatosComments){

            with(binding){
                tvId.text = dato.id
                tvPostId.text = dato.postId
                tvName.text = dato.name
                tvMail.text = dato.email
                tvBody.text = dato.body
            }

        }

    }


    companion object DiffCalckback: DiffUtil.ItemCallback<DatosComments>(){
        override fun areItemsTheSame(
            oldItem: DatosComments,
            newItem: DatosComments
        ): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(
            oldItem: DatosComments,
            newItem: DatosComments
        ): Boolean {
            return newItem == oldItem
        }

    }
}