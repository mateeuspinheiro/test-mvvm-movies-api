package com.pinheiro.desafiom2u

import android.app.Application
import com.pinheiro.desafiom2u.data.remote.IFilmesRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.TimeUnit


class FilmesApplication : Application() {

    companion object {

        lateinit var retrofit : Retrofit
    }

    override fun onCreate() {
        super.onCreate()

    }

}