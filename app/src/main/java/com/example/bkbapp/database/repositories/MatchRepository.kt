package com.example.bkbapp.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.bkbapp.database.daos.MatchDao
import com.example.bkbapp.database.entities.Match
import com.example.bkbapp.database.retrofit.MatchService
import kotlinx.coroutines.Deferred
import retrofit2.Response


class MatchRepository (private val repoDao:MatchDao){

    fun retrieveReposAsync(idMatch: Long): Deferred<Response<List<Match>>> {
        return MatchService.getMatchService().getMatchs(idMatch)
    }

    @WorkerThread
    suspend fun insert(match:Match){
        repoDao.insert(match)
    }

    @WorkerThread
    suspend fun delete(){
        repoDao.delete()
    }

    fun getAllMatch():LiveData<List<Match>>{
        return repoDao.getAllMatch()
    }

    fun getOneMatch(idMatch:Long):LiveData<Match>{
        return repoDao.getOne(idMatch)
    }

    fun deleteOneMatch(idMatch:Long){
        repoDao.deleteOne(idMatch)
    }

}