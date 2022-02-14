package com.example.mvvmmovies.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvmmovies.data.model.Movie
import com.example.mvvmmovies.domain.GetMoviesUseCase
import com.example.mvvmmovies.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application,
    private val getMoviesUseCase: GetMoviesUseCase
) : AndroidViewModel(app) {

    val movieList = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<String>()


    val checkConnectivity: ConnectivityLiveData by lazy {
        ConnectivityLiveData(getApplication<Application>())
    }

    suspend fun getAllMovies() {
        viewModelScope.launch {
            val resource = getMoviesUseCase()
            when (resource){
                is Resource.Success -> movieList.postValue(resource.data)
                is Resource.Error -> error.postValue(resource.message)
            }
        }
    }
}
