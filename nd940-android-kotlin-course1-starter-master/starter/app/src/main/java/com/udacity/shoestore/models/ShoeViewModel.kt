package com.udacity.shoestore.models

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel(){

    private var _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList : LiveData<ArrayList<Shoe>>
    get() = _shoeList
    init {
        _shoeList.value= ArrayList()
    }
    fun onSaveClick(v: View,shoe : Shoe){
        _shoeList.value?.add(shoe)
        navigateUp(v)
    }
    fun navigateUp(v: View){
        v.findNavController().navigateUp()
    }

    fun logout(v: View){
        v.findNavController().navigateUp()
    }
}