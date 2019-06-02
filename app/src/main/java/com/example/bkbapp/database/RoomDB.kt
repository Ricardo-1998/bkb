package com.example.bkbapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bkbapp.database.daos.MatchDao
import com.example.bkbapp.database.entities.Match


@Database(entities = [Match::class],version = 1,exportSchema = false)
public abstract class RoomDB : RoomDatabase(){

    abstract  fun repoDao():MatchDao

    companion object{
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(context : Context) : RoomDB{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                        .databaseBuilder(context, RoomDB::class.java, "match_Database")
                        .build()
                INSTANCE=instance
                return instance
            }
        }
    }
}