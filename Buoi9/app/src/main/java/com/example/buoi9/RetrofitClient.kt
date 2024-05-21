package com.example.buoi9

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASEURL = "https://663b532dfee6744a6ea139c8.mockapi.io/api/"
    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}