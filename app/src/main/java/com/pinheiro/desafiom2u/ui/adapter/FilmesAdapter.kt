package com.pinheiro.desafiom2u.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pinheiro.desafiom2u.R
import com.pinheiro.desafiom2u.data.remote.dto.FilmesDTO

class FilmesAdapter(private val dataSet: List<FilmesDTO>) :
    RecyclerView.Adapter<FilmesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagemFilme: ImageView


        init {
            imagemFilme = view.findViewById(R.id.imageView_filmeexibicao)

        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater
                .from(viewGroup.context)
                .inflate(R.layout.lista_filmeexibicao_item, viewGroup, false)
        )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Glide.with(viewHolder.itemView.context)
            .load("https://image.tmdb.org/t/p/w200/${dataSet[position].poster_path}")
            .placeholder(R.drawable.movie2you)
            .error(com.google.android.material.R.drawable.mtrl_ic_error)
            .into(viewHolder.imagemFilme)

    }

    override fun getItemCount() = dataSet.size
}

