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
6.. Crear clase repositorio, pero solo en el paquete data
7.. Crear package presentation, en dónde irá clase VM
8.. Agregar dependencia de VM
9.. Seguir con VM
10.. Agregar viewBinding
11.. Construir un ListFragment en el package presentation
12.. agregar dependencias de navigation
13.. Crear navigation y nav_graph

 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}