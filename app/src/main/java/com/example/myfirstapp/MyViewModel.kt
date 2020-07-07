package com.example.myfirstapp

import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var count : Int = 0

    fun getNumber() :Int{
        return count
    }


    fun setNumber(counts : Int){
        count = counts
    }

}


