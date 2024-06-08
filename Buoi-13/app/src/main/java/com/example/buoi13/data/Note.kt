package com.example.buoi13.data

import java.util.Date

data class Note(
    val id: Int? = null,
    val title: String?,
    val createdOn: Date?,
    val content: String?
)