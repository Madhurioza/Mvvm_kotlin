package com.example.mvvm_archi_kotlin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [subscriber::class], version = 1)

abstract  class subscriberDatabase: RoomDatabase() {

    abstract val subscriberDAO : subscriberDAO

    companion object{
        @Volatile
        private var INSTANCE : subscriberDatabase? = null
        fun getIstance(context: Context): subscriberDatabase{
            synchronized(this){
                var instance:subscriberDatabase? = INSTANCE
                if(instance==null){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        subscriberDatabase::class.java,
                        "subsciber_data_database"
                    ).build()
                    }
                    return instance
            }
        }

    }
}