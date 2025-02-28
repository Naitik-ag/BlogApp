package com.example.blogapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Blog(
    val id: Int,
    val date: String,
    val link: String,
    val title: Title,
    val excerpt: Excerpt,
    @SerializedName("jetpack_featured_media_url") val imageUrl: String?
)

data class Title(val rendered: String)
data class Excerpt(val rendered: String)