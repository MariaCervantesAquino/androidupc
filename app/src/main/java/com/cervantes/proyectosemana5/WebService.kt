package com.cervantes.proyectosemana5

import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object AppConstantes {
    const val BASE_URL = "http://192.168.0.9:3000"
}
interface WebService {
    @GET("/personas")
    suspend fun obtenerPersonas():Response<PersonasResponse>

    }

    object RetrofitClient{
        val webService: WebService by lazy {
            Retrofit.Builder()
                .baseUrl(AppConstantes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
                .create(WebService::class.java)
        }

    }
