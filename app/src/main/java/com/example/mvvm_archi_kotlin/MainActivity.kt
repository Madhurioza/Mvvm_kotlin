package com.example.mvvm_archi_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.mvvm_archi_kotlin.databinding.ActivityMainBinding
import com.example.mvvm_archi_kotlin.db.subscriberDAO
import com.example.mvvm_archi_kotlin.db.subscriberDatabase
import com.example.mvvm_archi_kotlin.db.subscriberRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberVewModel: subscriberVewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao:subscriberDAO = subscriberDatabase.getIstance(application).subscriberDAO
        val repository = subscriberRepository(dao)
        val factory = subcriberViewModelFactory(repository)
        subscriberVewModel = ViewModelProvider(this,factory).get(subscriberVewModel::class.java)
       binding.myViewModel = subscriberVewModel

        binding.lifecycleOwner = this
        displaysubscriberList()

    }

    private fun displaysubscriberList(){
        subscriberVewModel.subscribers.observe(this, Observer {
            Log.i("MYTAG",it.toString())
        })
    }

}

