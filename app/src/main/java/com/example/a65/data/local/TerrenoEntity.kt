package com.example.a65.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
// paso 28

@Entity(tableName = "tabla_terreno" )
data class TerrenoEntity(
    @PrimaryKey val id: String,
    val price: Int,
    val type: String,
    val imgMars: String
)
//primary key se declara como parámetro y no como atributo cuando no se desea que se autogenere. en este caso es un parámetro porque ya viene desde la api.
