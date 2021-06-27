package com.example.mvvm_archi_kotlin


import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_archi_kotlin.db.subscriber
import com.example.mvvm_archi_kotlin.db.subscriberRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class subscriberVewModel(private val repository: subscriberRepository): ViewModel(), Observable {
    val subscribers = repository.subscribers
    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val saveOrUpadteButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init{
        saveOrUpadteButtonText.value= "Save"
        clearAllOrDeleteButtonText.value="Clear All"
    }

    fun saveOrUpdate(){
        val name:String =inputName.value!!
        val email:String= inputEmail.value!!
        insert(subscriber(0,name,email))
        inputName.value=null
        inputEmail.value=null


    }

    fun clearAllOrDelete(){
        clearAll()

    }

    fun insert(subscriber: subscriber):Job= viewModelScope.launch {
        repository.insert(subscriber)
    }

    fun update(subscriber: subscriber): Job= viewModelScope.launch {
        repository.update(subscriber)
    }

    fun delete(subscriber: subscriber):Job = viewModelScope.launch {
        repository.delete(subscriber)
    }

    fun clearAll():Job= viewModelScope.launch {
        repository.deleteAll()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }


}