package com.example.bkbapp.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bkbapp.database.entities.Match


@Dao
interface MatchDao {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun insert(match : Match)

    @Query("SELECT * FROM match_table")
    fun getAllMatch() : LiveData<List<Match>>

    @Query("SELECT * FROM match_table WHERE id LIKE :idMatch")
    fun getOne(idMatch : Long) : LiveData<Match>

    @Query("DELETE FROM match_table WHERE id LIKE :idMatch")
    fun deleteOne(idMatch: Long)

    @Query("DELETE FROM match_table")
    suspend fun delete()
}