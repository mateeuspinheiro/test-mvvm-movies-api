package com.pinheiro.desafiom2u.data.remote

import com.pinheiro.desafiom2u.data.remote.dto.FilmesDTO
import com.pinheiro.desafiom2u.data.remote.dto.Result
import retrofit2.Call
import retrofit2.http.GET

interface IFilmesRepository {

    @GET("movie/now_playing?api_key=d5ae671e4f276368156fb42e8fdb4b47&language=pt-Br&page=1")
    fun listarFilmesExbibicao() : Call<FilmesDTO>

    fun listarFilmesRated()
    fun listarFilmesLancamentos()
    fun listarFilmesPopular()
    fun likeFilmes()

}