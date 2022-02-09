package com.example.mvvmmovies.data

import com.example.mvvmmovies.data.network.MovieService


class MovieRepository {
    private val api = MovieService()

    suspend fun getAllMovies() = api.getAllMovies()
}