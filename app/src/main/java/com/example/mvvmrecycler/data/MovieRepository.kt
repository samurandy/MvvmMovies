package com.example.mvvmrecycler.data

import com.example.mvvmrecycler.data.network.MovieService


class MovieRepository {
    private val api = MovieService()

    suspend fun getAllMovies() = api.getAllMovies()
}