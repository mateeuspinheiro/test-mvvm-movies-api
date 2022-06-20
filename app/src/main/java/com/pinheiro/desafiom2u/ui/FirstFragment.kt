package com.pinheiro.desafiom2u.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pinheiro.desafiom2u.databinding.FragmentFirstBinding
import com.pinheiro.desafiom2u.ui.adapter.FilmesAdapter
import com.pinheiro.desafiom2u.viewmodel.FilmesViewModel

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null


    private val binding get() = _binding!!

    private val viewModel: FilmesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerFilmes.layoutManager = LinearLayoutManager(view.context)
        binding.recyclerFilmes.addItemDecoration(
            DividerItemDecoration(
                view.context,
                DividerItemDecoration.VERTICAL
            )
        )

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.listarFilmesExibicao()
        }
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.listaFilme.observe(viewLifecycleOwner) {
                if (!it.isNullOrEmpty()) {
                    binding.recyclerFilmes.adapter = FilmesAdapter(it)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}