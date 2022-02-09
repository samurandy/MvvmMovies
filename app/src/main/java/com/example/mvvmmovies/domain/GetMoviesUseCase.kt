package com.example.mvvmmovies.domain

import com.example.mvvmmovies.data.MovieRepository
import com.example.mvvmmovies.data.model.Movie

class GetMoviesUseCase {
    private val repository = MovieRepository()

    suspend operator fun invoke(): List<Movie>? {
        return repository.getAllMovies()
    }
}