package com.example.mvvmmovies.data

import com.example.mvvmmovies.data.network.MovieService
import javax.inject.Inject


class MovieRepository @Inject constructor(
    private val api: MovieService
) {


    suspend fun getAllMovies() = api.getAllMovies()
}