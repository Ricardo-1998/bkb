package com.example.bkbapp.database.retrofit



import com.example.bkbapp.database.entities.Match
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


const val API_BASE_URL = ""

interface MatchService{

    @GET("/models/Match")
    fun getMatchs(@Path("idMatch")idMatch : Long) : Deferred<Response<List<Match>>>

    companion object{
        fun getMatchService():MatchService{
            return Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build().create(MatchService::class.java)
        }
    }
}