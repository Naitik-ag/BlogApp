package com.example.blogapp.data.network

import com.example.blogapp.data.model.Blog
import retrofit2.http.GET
import retrofit2.http.Query

interface BlogApi{
    @GET("posts")
    suspend fun getBlogs(
        @Query("per_page") perPage: Int = 10,
        @Query("page") page: Int
    ): List<Blog>

}