package com.practica.practicafinalm8uf1.Common

import com.practica.practicafinalm8uf1.Interface.RetrofitService
import com.practica.practicafinalm8uf1.Retrofit.RetroFitClient

object Common {
    private val BASE_URL = "http://www.xtec.cat/~jmendez1/forteco/courses.json/"

    val retrofitService: RetrofitService
        get() = RetroFitClient.getClient(BASE_URL).create(RetrofitService::class.java)


}