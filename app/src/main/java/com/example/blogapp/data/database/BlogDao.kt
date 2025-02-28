package com.example.blogapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.blogapp.data.model.Blog
import com.example.blogapp.data.model.BlogEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BlogDao {

    @Insert
    suspend fun insertBlogs(blogs: List<BlogEntity>)

    @Query("SELECT * FROM blogs")
    suspend fun getAllBlogs(): List<BlogEntity>

    @Query("DELETE FROM blogs")
    suspend fun clearBlogs()

}