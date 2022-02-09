package com.example.mvvmrecycler.data.network

import com.example.mvvmrecycler.data.model.Movie
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiClient {

    @GET("movielist.json")
    suspend fun getAllMovies() : Response<List<Movie>>
}