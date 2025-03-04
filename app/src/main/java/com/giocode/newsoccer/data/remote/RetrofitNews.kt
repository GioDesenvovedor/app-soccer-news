package com.giocode.newsoccer.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitNews {

    companion object{
        const val baseUrl = "https://giodesenvovedor.github.io/soccer-news-API/"
    }

    private val retrofitService by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Cria a implementação da interface SoccerNewsAPI
    //retrofitSoccerNewsAPI é para acessar a api
    val retrofitSoccerNewsAPI: SoccerNewsAPI by lazy {
        retrofitService.create(SoccerNewsAPI::class.java)

    }

}