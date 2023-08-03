package com.example.a65.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.a65.data.Repository
import com.example.a65.data.remote.Marterreno
import com.example.a65.data.remote.RetrofitClient
import kotlinx.coroutines.launch

/*
Parte 7
 */

class MarterrenoViewModel (application: Application) : AndroidViewModel(application){
    private val repository: Repository //nombre de la clase repositorio
    val marterrenosLiveData = MutableLiveData<List<Marterreno>>()

    init{
        val api = RetrofitClient.getRetrofitClient() //nombre del retrofit cliente
        repository = Repository(api)
    }
    fun getAllMarterrenos() = viewModelScope.launch{
       marterrenosLiveData.value = repository.chargeMarterrenos()
    }
}