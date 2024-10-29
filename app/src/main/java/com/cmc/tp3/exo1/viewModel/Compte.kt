package com.cmc.tp3.exo1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CompteViewModel : ViewModel() {

    private var count: MutableLiveData<Int> = MutableLiveData(0)

    init {
        var count = 0
    }

    fun addNumber(){
       count.value = (count.value)?.plus(1)
    }

    fun minNumber(){
       count.value = (count.value)?.minus(1)
    }

    fun getCount(): LiveData<Int> = count

}