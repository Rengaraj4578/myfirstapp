package com.example.myfirstapp

import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Integer.parseInt
import kotlin.random.Random
import kotlin.random.nextInt

class MyViewModel : ViewModel() {
    var count : MutableLiveData<String>? = null
    var randomNum : MutableLiveData<String>? = null

    fun getNumber() : MutableLiveData<String>{
        if (count==null){
            count = MutableLiveData<String>()
            count!!.value = "0"
        }
        return count!!
    }

//    fun incrementNumber(){
//        var number = (count?.value).toString().toInt()
//        count!!.value = (++number).toString()
//    }

    fun setNumber(counts : Int){
        count!!.value = counts.toString()
    }

//    fun getRandom() : MutableLiveData<String>{
//        if (randomNum==null){
//            randomNum = MutableLiveData<String>()
//            generateRandom()
//        }else{
//            generateRandom()
//        }
//        return randomNum!!
//    }


//    fun generateRandom() {
//        var createRan = ( count!!.value )?.toInt()?.let { Random.nextInt(it)+1 }
//        randomNum!!.value = createRan.toString()
//    }
//
//    fun getRandomNumber() : MutableLiveData<String>{
//        return randomNum!!
//    }

    fun setRandom(randomNumber: Int){
        randomNum!!.value = randomNumber.toString()
    }

    fun getRandom() : MutableLiveData<String>{
        if (randomNum==null){
            randomNum = MutableLiveData<String>()
            randomNum!!.value = "0"
        }
        return randomNum!!
    }
}


