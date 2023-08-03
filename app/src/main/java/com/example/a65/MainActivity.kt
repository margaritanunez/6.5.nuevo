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
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}