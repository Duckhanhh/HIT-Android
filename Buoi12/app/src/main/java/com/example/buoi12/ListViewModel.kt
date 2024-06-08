package com.example.buoi12

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    //var result = 0
    private val _result = MutableLiveData<Int>(0)
    val result: LiveData<Int> get() = _result

    fun plus(){
        if (_result.value != null)
            _result.value = _result.value!! + 1
    }
    fun minus(){
        if (_result.value != null)
            _result.value = _result.value!! - 1
    }
}