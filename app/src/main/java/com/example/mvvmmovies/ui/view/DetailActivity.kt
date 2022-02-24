package com.example.mvvmmovies.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.mvvmmovies.data.model.Movie
import com.example.mvvmmovies.databinding.ActivityDetailBinding
import kotlinx.coroutines.launch
import com.example.mvvmmovies.utils.Extensions.Companion.glide

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_ID = "superhero"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillSuperheroDetail()
    }

    private fun fillSuperheroDetail() {
        intent.getParcelableExtra<Movie>(EXTRA_ID).let {
            with(binding) {
                nameDetail.text = it?.name
                descriptionDetail.text = it?.description

                lifecycleScope.launch {
                    imageDetail.glide("${it?.imageUrl}")
                }
            }
        }
    }


}
