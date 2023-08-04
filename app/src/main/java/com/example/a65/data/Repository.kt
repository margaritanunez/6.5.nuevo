package com.example.a65.data

import androidx.lifecycle.LiveData
import com.example.a65.data.local.TerrenoDao
import com.example.a65.data.local.TerrenoEntity
import com.example.a65.data.remote.ApiMars
import com.example.a65.data.remote.Marterreno

/*
Paso 6
entrega de parámetros a repository de la interfaz Api
 */
class Repository(private val apiMars: ApiMars, private val terrenoDao: TerrenoDao) { //terreno dao paso 31

    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDao.obtenerTerrenos() //paso 31
//si queremos obtener los terrenos, escuchamos este LiveData
    suspend fun chargeMarterrenos() { //borrar : List<Marterreno> paso 31
    // se encarga de consumir desde la api y meter la BD
        val respuesta = apiMars.getData() //paso 16
        if(respuesta.isSuccessful){
            val resp = respuesta.body()
            resp?.let {terrenos->
                val terrenosEntity = terrenos.map { it.transformar() }
                terrenoDao.insertarTerrenos(terrenosEntity)
            }//hacer una transformación del terreno de remote a terreno emptity a tráves de map.
            //map es una fx de extensión para hacer la transformación. paso 32
        }
    } // borrar return it y return empty list p.31

}

fun Marterreno.transformar(): TerrenoEntity =
    TerrenoEntity(this.id, this.price, this.type, this.imgMars)
// paso32
// desde un terreno(Marterreno) creamos un Terreno Entity, a través de la función transformar obtenemos una instancia de terrenoEntity
// los datos se transforman en entidades, los cuáles son introducidos en la base

