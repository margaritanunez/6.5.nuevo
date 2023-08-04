package com.example.a65.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.a65.data.Repository
import com.example.a65.data.local.TerrenoDataBase
import com.example.a65.data.remote.Marterreno
import com.example.a65.data.remote.RetrofitClient
import kotlinx.coroutines.launch

/*
Parte 7
 */

class MarterrenoViewModel (application: Application) : AndroidViewModel(application){
    private val repository: Repository //nombre de la clase repositorio
    fun marterrenosLiveData() = repository.obtenerTerrenos() ////eliminar mutableLiveData y agregar .obtenerTerrenos(), cambiar val por fun. p33

    init{
        val api = RetrofitClient.getRetrofitClient() //nombre del retrofit cliente
        val terrenoDataBase = TerrenoDataBase.getDataBase(application).getTerrenoDao() //p33
        repository = Repository(api, terrenoDataBase) //p33 repository recibe como parámetro también terrenoDataBase
    }
    fun getAllMarterrenos() = viewModelScope.launch{
       repository.chargeMarterrenos() //eliminar  lo de antes de la asignación p33
    }
}