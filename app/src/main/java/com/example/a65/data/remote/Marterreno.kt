package com.example.a65.data.remote

import com.google.gson.annotations.SerializedName

/*Paso 5.1
[{"price":450000,"id":"424905","type":"buy","img_src":"http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg"},
para identificar estructura de la api. no es necesario respetar el orden.
para hacer match entre los nombres de la data class y los nombres de la api existen dos opciones:
a) respetar los nombres que vienen en la api
b) si el nombre es distinto hacer la conversión con retrofit, para ello se debe escribir antes de la variable
@SerializedName(aquí se le pasa el nombre que viene en la api entre comillas)
*/
data class Marterreno(
    val id: String,
    val price: Int,
    val type: String,
    @SerializedName("img_src") val imgMars: String
)

