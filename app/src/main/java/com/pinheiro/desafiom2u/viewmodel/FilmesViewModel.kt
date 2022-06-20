package com.pinheiro.desafiom2u.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pinheiro.desafiom2u.data.remote.FilmesRepository
import com.pinheiro.desafiom2u.data.remote.IFilmesRepository
import com.pinheiro.desafiom2u.data.remote.dto.FilmesDTO
import com.pinheiro.desafiom2u.data.remote.dto.Result
import com.pinheiro.desafiom2u.data.remote.dto.RetrofitClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FilmesViewModel(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) : ViewModel() {

    //(private val dispatcher: CoroutineDispatcher = Dispatchers.IO)

    private val repository: IFilmesRepository = FilmesRepository(RetrofitClient())

    private val _listarFilmesExibicao: MutableLiveData<List<Result>> = MutableLiveData()
    var listaFilme: LiveData<List<Result>> = _listarFilmesExibicao

    fun listarFilmesExibicao() {

        viewModelScope.launch(dispatcher) {
            repository.listarFilmesExbibicao().enqueue(object : Callback<List<Result>> {
                override fun onResponse(
                    call: Call<List<Result>>,
                    response: Response<List<Result>>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { list ->
                            _listarFilmesExibicao.postValue(list)
                        }
                    }
                }

                override fun onFailure(call: Call<List<Result>>, t: Throwable) {
                    _listarFilmesExibicao.value = listOf()
                    Log.e(FilmesViewModel::class.java.name, t.toString())
                }

            })
        }
    }
}

