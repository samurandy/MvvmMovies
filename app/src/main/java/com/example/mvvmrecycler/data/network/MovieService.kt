package com.example.mvvmrecycler.data.network

import com.example.mvvmrecycler.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class MovieService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllMovies():List<Movie>{
        return withContext(Dispatchers.IO) {
            val response: Response<List<Movie>> =
                retrofit.create(MovieApiClient::class.java).getAllMovies()
            response.body() ?: emptyList()
        }
    }
}