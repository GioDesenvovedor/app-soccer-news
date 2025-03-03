package com.giocode.newsoccer.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.giocode.newsoccer.domain.model.News

class HomeViewModel : ViewModel() {
    private val _news = MutableLiveData<List<News>>()
    val news: LiveData<List<News>> = _news

//    init {
//        noticias()
//    }



    //mock listagem de noticias
     fun noticias(){
        _news.value = listOf(
            News("Bola de Ouro", "Messi novamente ganha a bola de oureo"),
            News("Bola de Prata", "Cristiano Ronaldo ganha a bola de prata"),
            News("Palmeiras chega as semi-finais", "Palmeiras ganha e chega as semi-finais da copa"),
            News("Copa do Mundo", "Brasil ganha a copa do mundo"),
        )
    }
}