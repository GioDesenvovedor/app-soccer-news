package com.giocode.newsoccer.data.remote

import com.giocode.newsoccer.domain.model.NewNews
import com.giocode.newsoccer.domain.model.NewNewsItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface SoccerNewsAPI {

    // Lista de notícias
    @GET("soccernews.json")
   suspend fun getNews(): Response<List<NewNewsItem>>




}