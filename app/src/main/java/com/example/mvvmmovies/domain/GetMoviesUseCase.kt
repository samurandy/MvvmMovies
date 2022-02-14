package com.example.mvvmmovies.domain

import com.example.mvvmmovies.data.MovieRepository
import com.example.mvvmmovies.data.model.Movie
import com.example.mvvmmovies.utils.Resource
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {


    suspend operator fun invoke(): Resource<List<Movie>> {
        return repository.getAllMovies()
    }
}