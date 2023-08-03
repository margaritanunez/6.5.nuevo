package com.example.a65.data

import com.example.a65.data.remote.ApiMars
import com.example.a65.data.remote.Marterreno

/*
Paso 6
entrega de parámetros a repository de la interfaz Api
 */
class Repository(private val apiMars: ApiMars) {

    suspend fun chargeMarterrenos() {
        val respuesta = apiMars.getData() //paso 16
        if(respuesta.isSuccessful){
            val resp = respuesta.body()
            resp?.let {
                return it
            }
        }
        return emptyList<>()
    }


}