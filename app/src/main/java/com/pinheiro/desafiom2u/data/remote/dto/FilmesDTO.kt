package com.pinheiro.desafiom2u.data.remote.dto

data class FilmesDTO(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int,


)