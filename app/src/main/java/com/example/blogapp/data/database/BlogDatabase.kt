package com.example.blogapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.blogapp.data.model.Blog
import com.example.blogapp.data.model.BlogEntity

@Database(entities = [BlogEntity::class],version = 1, exportSchema = false)
abstract class BlogDatabase : RoomDatabase(){
    abstract fun blogDao(): BlogDao

}