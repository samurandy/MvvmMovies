package com.example.mvvmmovies.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmmovies.data.model.Movie
import com.example.mvvmmovies.domain.GetMoviesUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()
    private val getMoviesUseCase = GetMoviesUseCase()

    suspend fun getAllMovies() {
        viewModelScope.launch {
            val movie = getMoviesUseCase()
            if (movie != null) {
                movieList.postValue(movie)
            }
        }
    }
}