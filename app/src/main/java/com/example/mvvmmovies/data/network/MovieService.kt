package com.example.mvvmmovies.data.network

import com.example.mvvmmovies.data.model.Movie
import com.example.mvvmmovies.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class MovieService @Inject constructor(private val api:MovieApiClient){


    suspend fun getAllMovies(): Resource<List<Movie>> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<List<Movie>> = api.getAllMovies()

                Resource.Success(response.body() ?: emptyList())
            }catch(e: Exception){
                Resource.Error("There was a problem in the server")
            }
        }
    }
}