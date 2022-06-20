package com.pinheiro.desafiom2u.data.remote

import com.pinheiro.desafiom2u.data.remote.dto.FilmesDTO
import com.pinheiro.desafiom2u.data.remote.dto.Result
import com.pinheiro.desafiom2u.data.remote.dto.RetrofitClient
import retrofit2.Call

class FilmesRepository(private val retrofitClient: RetrofitClient) : IFilmesRepository {
    override fun listarFilmesExbibicao(): Call<FilmesDTO> =
        retrofitClient.getInstance().getFilmesAPI().listarFilmesExbibicao()

    override fun listarFilmesRated() {
        TODO("Not yet implemented")
    }

    override fun listarFilmesLancamentos() {
        TODO("Not yet implemented")
    }

    override fun listarFilmesPopular() {
        TODO("Not yet implemented")
    }

    override fun likeFilmes() {
        TODO("Not yet implemented")
    }


}