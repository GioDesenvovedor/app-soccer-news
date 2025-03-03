package com.giocode.newsoccer.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giocode.newsoccer.databinding.ItemNewsBinding
import com.giocode.newsoccer.domain.model.News

class NewAdapter(private var listNews: List<News>): RecyclerView.Adapter<NewAdapter.ViewHolder>() {

    inner class ViewHolder(itenNews: View): RecyclerView.ViewHolder(itenNews){
        private val binding: ItemNewsBinding = ItemNewsBinding.bind(itenNews)
        fun bind(news: News){
            binding.txtTitle.text = news.title
            binding.txtDescription.text = news.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewAdapter.ViewHolder {
        Log.d("NewAdapter", "onCreateViewHolder iniciado")
       val itemNews = ItemNewsBinding.inflate(
           LayoutInflater.from(parent.context),
           parent, false)
        return ViewHolder(itemNews.root)
    }

    override fun onBindViewHolder(holder: NewAdapter.ViewHolder, position: Int) {
        Log.d("NewAdapter", "onBindViewHolder iniciado")
        holder.bind(listNews[position])

    }

    override fun getItemCount(): Int {
        Log.d("NewAdapter", "getItemCount iniciado")
        return listNews.size

    }
    fun updateList(list: List<News>){
        listNews = list
        notifyDataSetChanged()

    }

}