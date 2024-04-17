package com.example.test

import java.util.Date

class DataItem{
    companion object{
        val list: MutableList<Note> = mutableListOf(
            Note("Nguyen Duc Khanh", "Duckk", Date(), true),
            Note("Nguyen ", "Duckdfdfdfk", Date(), false),
        )
    }
}
