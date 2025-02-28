package com.example.blogapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "blogs")
data class BlogEntity(
    @PrimaryKey val id: Int,
    val date: String,
    val link: String,
    val title: String,
    val excerpt: String,
    val imageUrl: String?
)

