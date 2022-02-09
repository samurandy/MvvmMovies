package com.example.mvvmrecycler.domain

import com.example.mvvmrecycler.data.MovieRepository
import com.example.mvvmrecycler.data.model.Movie

class GetMoviesUseCase {
    private val repository = MovieRepository()

    suspend operator fun invoke(): List<Movie>? {
        return repository.getAllMovies()
    }
}