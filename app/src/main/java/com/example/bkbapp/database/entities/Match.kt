package com.example.bkbapp.database.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "match_table")
data class Match(

        @PrimaryKey
        @field:Json(name = "id")
        @ColumnInfo(name = "id")
        val id : Long,

        @field:Json(name="team1")
        val team1: String,

        @field:Json(name="team2")
        val team2: String,

        @field:Json(name="point1")
        val point1: String,

        @field:Json(name="point1")
        val point2: String,

        @field:Json(name="winner1")
        val winner: String,

        @field:Json(name="date")
        val date: String,

        @field:Json(name="time")
        val time: String


)