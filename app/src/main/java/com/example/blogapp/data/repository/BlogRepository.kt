package com.example.blogapp.data.repository

import com.example.blogapp.data.database.BlogDao
import com.example.blogapp.data.model.Blog
import com.example.blogapp.data.model.BlogEntity
import com.example.blogapp.data.model.Excerpt
import com.example.blogapp.data.model.Title
import com.example.blogapp.data.network.BlogApi
import javax.inject.Inject

class BlogRepository @Inject constructor(
    private val api: BlogApi,
    private val blogDao: BlogDao
) {
    suspend fun getBlog(page: Int): List<Blog> {
        return try {
            val response = api.getBlogs(perPage = 10, page = page)
            val blogEntities = response.map { blog ->
                BlogEntity(
                    id = blog.id,
                    title = blog.title.rendered,
                    date = blog.date,
                    link = blog.link,
                    excerpt = blog.excerpt.rendered,
                    imageUrl = blog.imageUrl
                )
            }
            blogDao.insertBlogs(blogEntities)
            response
        } catch (e: Exception) {
            blogDao.getAllBlogs().map { blog->
                Blog(
                    id = blog.id,
                    title = Title(blog.title),
                    date = blog.date,
                    link = blog.link,
                    excerpt = Excerpt(blog.excerpt),
                    imageUrl = blog.imageUrl
                )
            }
        }
    }
}