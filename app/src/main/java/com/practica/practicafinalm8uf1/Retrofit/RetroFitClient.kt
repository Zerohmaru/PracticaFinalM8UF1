package com.practica.practicafinalm8uf1.Retrofit

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String) : Retrofit{
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit!!
    }
}