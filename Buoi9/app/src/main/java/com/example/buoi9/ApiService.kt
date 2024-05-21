package com.example.buoi9

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("student")
    fun getAllStudent(): Call<List<Student>>

    @GET("student/{id}")
    fun getStudentById(@Path("id") id: String): Call<Student>

    @POST("/student")
    fun createStudent(@Body student: Student): Call<Student>
}