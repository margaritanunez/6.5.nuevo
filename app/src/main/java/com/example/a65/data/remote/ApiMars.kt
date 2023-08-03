package com.example.a65.data.remote

import retrofit2.Response
import retrofit2.http.GET

/*
Paso 5.2
Recuerda que la interfaz no lleva implementación ({})
Response es un objeto de retrofit que nos permite encapsular toda la info.
Cómo no queremos que se bloquee la app cuando hacemos el consumo de la api, haremos que esta función se suspenda para que corra dentro de una corrutina
 */
interface ApiMars {
    @GET("realestate") //ejecutamos un get a la url que se encuentra aquí, que por mientras es "realestate"
    suspend fun getData() : Response<List<Marterreno>> //Aquí se ejecuta un método que se llama getData() que retorna con un Response de la lista de terrenos

}