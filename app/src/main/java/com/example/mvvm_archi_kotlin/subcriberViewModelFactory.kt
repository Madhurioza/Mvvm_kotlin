package com.example.mvvm_archi_kotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_archi_kotlin.db.subscriberRepository

class subcriberViewModelFactory(private val repository: subscriberRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(subscriberVewModel::class.java)){
            return subscriberVewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}