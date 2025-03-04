package com.giocode.newsoccer.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giocode.newsoccer.data.remote.RetrofitNews
import com.giocode.newsoccer.domain.model.NewNewsItem
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val retrofitNews by lazy {
        RetrofitNews()
    }

    private val _news = MutableLiveData<List<NewNewsItem>>()
    val news: LiveData<List<NewNewsItem>> = _news




//    init {
//        noticias()
//    }



    // Lista de notícias
//     fun noticias(){
//         //Instancia o retrofit
//         CoroutineScope(Dispatchers.Main).launch {
//             // Instancia o retrofit e cria a implementação da interface SoccerNewsAPI
//             _news.postValue(retrofitNews.retrofitSoccerNewsAPI.getNews())
//         }
//
//    }

    // Lista de notícias
    fun buscarNoticias(){
        viewModelScope.launch {
            try {
                val response = retrofitNews.retrofitSoccerNewsAPI.getNews()//Chama a função getNews() da interface SoccerNewsAPI
                response.body()?.let {
                    _news.value = it // Atualiza o valor de _news com a lista de notícias
                    Log.d("NewsViewModel", "Notícias buscadas com sucesso ${it.size}" )
                }
            }catch (e: Exception){
                e.printStackTrace()
                // Tratar erro
                Log.e("NewsViewModel", "Erro ao buscar notícias", e)
            }
        }
    }

//        _news.value = listOf(
//            News("Bola de Ouro", "Messi novamente ganha a bola de oureo"),
//            News("Bola de Prata", "Cristiano Ronaldo ganha a bola de prata"),
//            News("Palmeiras chega as semi-finais", "Palmeiras ganha e chega as semi-finais da copa"),
//            News("Copa do Mundo", "Brasil ganha a copa do mundo"),
//        )

}