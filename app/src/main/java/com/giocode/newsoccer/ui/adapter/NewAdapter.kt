package com.giocode.newsoccer.ui.adapter

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.giocode.newsoccer.databinding.ItemNewsBinding
import com.giocode.newsoccer.domain.model.NewNews
import com.giocode.newsoccer.domain.model.NewNewsItem
import com.squareup.picasso.Picasso

class NewAdapter(private var listNews: List<NewNewsItem>): RecyclerView.Adapter<NewAdapter.ViewHolder>() {

    inner class ViewHolder(itenNews: View): RecyclerView.ViewHolder(itenNews){
        private val binding: ItemNewsBinding = ItemNewsBinding.bind(itenNews)
        fun bind(news: NewNewsItem){
            binding.txtTitle.text = news.title
            binding.txtDescription.text = news.description

            //Carregar imagem da internet
            Picasso.get().load(news.image)
                .resize(1300, 800)
                .centerCrop()
                .into(binding.imageView)

            binding.btnOpenLink.setOnClickListener {
                Log.d("NewAdapter", "Link do botão clicado")
                var url = news.link.trim()
                //Verifica se o link começa com http:// ou https://
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://" + url
                }
                // Abre o navegador com a URL fornecida Cria uma Intent do tipo ACTION_VIEW, que indica que irá abrir um conteúdo.
                //Uri.parse(url): Converte a String da URL em um objeto Uri, que o Android consegue interpretar.
               try {
                   val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                   //Intent.FLAG_ACTIVITY_NEW_TASK: Essa flag indica que o navegador deve ser aberto em uma nova "tarefa" separada do app.
                   browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)//
                   itemView.context.startActivity(browserIntent)

               }catch (e: Exception){
                   e.printStackTrace()
                   Log.e("NewAdapter", "Erro ao abrir o navegador", e)
               }


            }
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
    fun updateList(list: List<NewNewsItem>){
        listNews = list
        notifyDataSetChanged()

    }

}