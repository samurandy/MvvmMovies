package com.example.mvvmmovies.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    @SerializedName("category") var category: String? = null,
    @SerializedName("imageUrl") var imageUrl: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("desc") var description: String? = null
): Parcelable
