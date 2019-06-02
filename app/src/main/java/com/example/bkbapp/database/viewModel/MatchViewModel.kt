package com.example.bkbapp.database.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.bkbapp.database.RoomDB
import com.example.bkbapp.database.entities.Match
import com.example.bkbapp.database.repositories.MatchRepository
import kotlinx.coroutines.launch

class MatchViewModel(private val app:Application) : AndroidViewModel(app) {
    private val repository : MatchRepository

    init {
        val repoDao = RoomDB.getInstance(app).repoDao()
        repository = MatchRepository(repoDao)
    }

    fun retrieveRepo(id: Long) = viewModelScope.launch {
        this@MatchViewModel.nuke()

        val response = repository.retrieveReposAsync(id).await()
        if(response.isSuccessful) with(response){
            this.body()?.forEach {
                this@MatchViewModel.insert(it)
            }
        }else with(response){
            when(this.code()){
                404 ->{
                    Toast.makeText(app, "partido no encontrado", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private suspend fun insert(match: Match) = repository.insert(match)
    private suspend fun nuke() = repository.delete()

    fun getAll(): LiveData<List<Match>> {
        return repository.getAllMatch()
    }

    fun getOne(id:Long): LiveData<Match> {
        return repository.getOneMatch(id)
    }

    fun deleteOne(id:Long) {
        return repository.deleteOneMatch(id)
    }
}