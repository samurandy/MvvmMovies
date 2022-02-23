package com.example.mvvmmovies.ui.view

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.mvvmmovies.R
import com.example.mvvmmovies.databinding.ActivityMainBinding
import com.example.mvvmmovies.ui.viewmodel.MainViewModel
import com.example.mvvmmovies.ui.viewmodel.ConnectivityLiveData
import com.example.mvvmmovies.utils.Extensions.Companion.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    private lateinit var connectivityLiveData: ConnectivityLiveData
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = MainAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectivityLiveData = ConnectivityLiveData(application)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.adapter = adapter

        initialConnectionCheck()
        onMovieListObserve()
        onConnectionObserve()

        viewModel.error.observe(this,{
            toast(it)
        })

        viewModel.isLoading.observe(this, {
            binding.progressBar.isVisible = it
        })
    }

    private fun onMovieListObserve() {
        viewModel.movieList.observe(this, {
            Log.d(TAG, "onCreate: $it")
            adapter.setMovieList(it)
        })
    }

    private fun onConnectionObserve() {
        viewModel.checkConnectivity.observe(this, { isAvailable ->
            when (isAvailable) {
                true -> {
                    lifecycleScope.launch {
                        viewModel.getAllMovies()
                    }
                }
                false -> toast("No network connection available")
            }
        })
    }

    private fun initialConnectionCheck() {
        lifecycleScope.launch {
            delay(3000)
            if (viewModel.checkConnectivity.value == true) {

                viewModel.getAllMovies()

            } else {
                toast("No network connection available")
            }
        }
    }
}

