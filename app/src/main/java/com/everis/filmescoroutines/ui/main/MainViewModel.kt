package com.everis.filmescoroutines.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    val filmesLiveData = MutableLiveData<List<Filme>>()

    fun getFilmes() {
        repository.getFilmes { filmes ->
            filmesLiveData.postValue(filmes)
        }
    }
     fun getFilmesCoroutines() {
        CoroutineScope(Dispatchers.Main).launch {
            val filmes = withContext(Dispatchers.Default) {
                repository.getFilmesCoroutines()
            }
            filmesLiveData.value = filmes
        }

    }

    class MainViewModelFactory(
            private val repository: MainRepository
    ) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }

    }

}



