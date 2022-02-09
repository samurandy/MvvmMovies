package com.example.mvvmmovies.data.network

import com.example.mvvmmovies.data.model.Movie
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiClient {

    @GET("movielist.json")
    suspend fun getAllMovies() : Response<List<Movie>>
}