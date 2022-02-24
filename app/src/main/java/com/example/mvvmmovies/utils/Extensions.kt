package com.example.mvvmmovies.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class Extensions {
    companion object {
        fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(this, message, duration).show()
        }

        fun ImageView.glide(url: String) {
            Glide.with(this).load(url).fitCenter().override(1000,1200).into(this)
        }
    }
}