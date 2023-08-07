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

    fun getTerreno(id: String): LiveData<TerrenoEntity> = terrenoDao.getTerreno(id)
    // 41 b) devuelve un solo terreno. el nombre de la fx debe ser igual al que se encuentra en dao.
}

fun Marterreno.transformar(): TerrenoEntity =
    TerrenoEntity(this.id, this.price, this.type, this.imgMars)
// paso32
// desde un terreno(Marterreno) creamos un Terreno Entity, a través de la función transformar obtenemos una instancia de terrenoEntity
// los datos se transforman en entidades, los cuáles son introducidos en la base

// la fx del repositorio es manejar fuentes de datos y administrarlas (a la bd, dao y entity).. se encarga de recopilar la información requerida .
// si queremos agregar un nuevo método para obtener uno o un listado de ´productos debemos agregarlo en view model , repository y Base de datos ( a través del dao)
// la info está en la BD, el repositorio permite acceder a la info, el vm le pide la info al repositorio porque es el encargado de comunicarse con la vista (presentation)
// vm toma la info que le proporciona el repositorio y comienza a comunicarla a través de los LiveData
//Por eso es la vista la que se suscribe como observador a alguna parte del vm
// el camino siempre es el mismo bd-> repository -> vm
// la vista solo ve al vm.
