package com.example.a65

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
/*
Pasos para hacer esta cosa:
1.. Commit inicial
2.. agregar dependencias de retrofit
3.. traducir elementos de  la api a dataclass/POJO
4.. crear paquete data.remote
5.. construir los tres componentes que necesitamos para hacer consumo
    5.1.. POJO... construir data class. Aquí es dónde necesitamos traducir los elementos de la api a dataclass
    5.2.. interfaz de operaciones, crear una nueva interface
    5.3.. cliente de retrofit, hacer una clase nueva que se llame retrofit client.
6.. Crear clase repositorio, pero solo en el paquete data, queda en esta carpeta porque sirve como director de orquesta entre las clases local y remote
7.. Crear package presentation, en dónde irá clase VM
8.. Agregar dependencia de VM
9.. Seguir con VM
10.. Agregar viewBinding
11.. Construir un ListFragment en el package presentation
12.. agregar dependencias de navigation
13.. Crear navigation y nav_graph
14.. Diseñar en layout de fragment_list, en este caso se implementó un botón
15.. Dar funcionalidad al botón
16.. crear val respuesta en Repository y función if
17.. agregar permisos de internet
18.. crear rv en fragment_list
19.. crear item layout... recuerda que constraint layout ppal debe tener en altura wrap_content
20.. crear adapter e implementar rv. Si rv utiliza imagenes de internet, agregar las dependencias para ello.
21.. agregar setData en Adapter
22.. agregar layoutmanager donde se encuentre el rv
23.. agregar init adapter en list fragment.
24..falta agregar cosas por aquí de la clase 83
25.. crear package data.local para room (dao, database, entity)
26.. crear data class entity, abstract class database, e  interface dao.
27.. dependencias de room
28.. entity
29.. dao
30.. database
31.. implementar algo en el repositorio
32.. map, para transformar
33.. arreglar errores del view model
34.. ir a ListFragment
35.. RESOLUCIÓN DE CONFLICTOS EN DAO
36.. Detalle fragment donde se mostrarán los detalles del terreno.
37.. construir binding en DetalleFragment
38.. agregar feagment_detalle a navegación
39-- agregar on click listener en adapter para que cardview seleccionado muestre los detalles de la imagen (pasar navigation). también crear bundle
40.. obtener valor del bundle en detalle fragment, para ello se debe cambiar valor del ARG_PARAM1 donde en vez de "param1" este se llamará  "id"
41.. para agregar un nvo. método para obtener un listado o un elemento de la lista, entonces deberemos configurarlo en:
     a) base de datos (específicamente en dao)
     b)  repository
     c) view model
42.. desde detalle fragmento debemos utilizar al view model para poder obtener la información. Desplegar la información a través de los binding.

 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}