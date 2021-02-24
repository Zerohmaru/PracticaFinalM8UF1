package com.practica.practicafinalm8uf1.Interface

import com.practica.practicafinalm8uf1.Model.Marca
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("courses.json")
    fun getModelList(): Call<MutableList<Marca>>
}