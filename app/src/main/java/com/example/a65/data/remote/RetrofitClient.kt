package com.example.a65.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/*
punto 5.3
 */

class RetrofitClient { //declaración de una clase
    companion object { // declaración de un estático
        private const val URL_BASE = "https://android-kotlin-fun-mars-server.appspot.com/" //declaración de una URL
        fun getRetrofitClient(): ApiMars {//nombre de la interface
            val mRetrofit = Retrofit.Builder().baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create()).build()
            //función para obtener el cliente de retrofit, se agregan los conversores para transformar de json a pojo
            return mRetrofit.create(ApiMars::class.java)
        }
    }
}