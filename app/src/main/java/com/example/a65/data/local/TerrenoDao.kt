package com.example.a65.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query



@Dao // paso 29
interface TerrenoDao {

    @Insert
    suspend fun insertarTerreno (terrenoEntity: TerrenoEntity) // p29

    @Insert
    suspend fun insertarTerrenos (terrenosEntity: List<TerrenoEntity>) //p32

    @Query ("SELECT * FROM tabla_terreno order by id ASC") // p29
    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>>

}