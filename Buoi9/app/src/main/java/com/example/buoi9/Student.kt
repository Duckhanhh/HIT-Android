package com.example.buoi9

import com.google.gson.annotations.SerializedName

data class Student(
    @SerializedName("id")
    val id : String,
    @SerializedName("name")
    val nameStudent: String,
    @SerializedName("age")
    val ageStudent: Int,
    @SerializedName("address")
    val addressStudent: String,
)
