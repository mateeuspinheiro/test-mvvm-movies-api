package com.pinheiro.desafiom2u.data.remote.dto

import com.pinheiro.desafiom2u.data.remote.IFilmesRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    companion object {
        private var instance: RetrofitClient? = null
    }

    private var filmesRepository: IFilmesRepository

    init {
        /*val gson = GsonBuilder().registerTypeAdapter(
            LocalDate::class.java,
            LocalDateAdapter().nullSafe()
        ).create()*/

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.themoviedb.org/3/")
            .client(createOkHttpClient())
            .build()

        filmesRepository = retrofit.create(IFilmesRepository::class.java)
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(15L, TimeUnit.SECONDS)
            .readTimeout(15L, TimeUnit.SECONDS)
            .writeTimeout(15L, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor { msg ->
                println("LOG APP: $msg")
            }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).addNetworkInterceptor(HttpLoggingInterceptor { msg ->
                println("LOG NTW: $msg")
            }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Synchronized
    fun getInstance(): RetrofitClient {
        if (instance == null) {
            instance = RetrofitClient()
        }
        return instance as RetrofitClient
    }

    fun getFilmesAPI() = filmesRepository
}