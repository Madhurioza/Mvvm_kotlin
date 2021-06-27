package com.example.mvvm_archi_kotlin.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface subscriberDAO {

    @Insert
    suspend fun insertsubscriber(subscriber: subscriber): Long

    @Update
    suspend fun updatesubcriber(subscriber: subscriber)

    @Delete
    suspend fun deletesubcriber(subscriber: subscriber)

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM subscriber_data_table")
    fun getAllsubscribers():LiveData<List<subscriber>>


}