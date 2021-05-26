package com.everis.filmescoroutines.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.everis.filmescoroutines.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            MainViewModel.MainViewModelFactory(MainRepository())
        ).get(MainViewModel::class.java)

        viewModel.filmesLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer { filmes ->
            textViewFilmes.text = filmes[0].titulo
        })

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getFilmesCoroutines()
        }
    }
}