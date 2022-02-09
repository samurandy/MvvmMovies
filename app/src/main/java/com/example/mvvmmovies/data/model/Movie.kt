package com.example.mvvmmovies.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("category") var category: String? = null,
    @SerializedName("imageUrl") var imageUrl: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("desc") var desc: String? = null
)
