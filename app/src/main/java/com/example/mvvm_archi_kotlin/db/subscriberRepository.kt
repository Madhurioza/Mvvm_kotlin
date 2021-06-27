package com.example.mvvm_archi_kotlin.db

class subscriberRepository(private val dao: subscriberDAO) {

    val subscribers= dao.getAllsubscribers()

    suspend fun insert(subscriber: subscriber)
    {
        dao.insertsubscriber(subscriber)
    }

    suspend fun update(subscriber: subscriber)
    {
        dao.updatesubcriber(subscriber)
    }

    suspend fun delete(subscriber: subscriber)
    {
        dao.deletesubcriber(subscriber)


    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }



}