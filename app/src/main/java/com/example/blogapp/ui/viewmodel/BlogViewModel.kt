package com.example.blogapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blogapp.data.model.Blog
import com.example.blogapp.data.repository.BlogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlogViewModel @Inject constructor(
    private val blogRepository: BlogRepository
) : ViewModel() {

    private var _blogs = MutableStateFlow<List<Blog>>(emptyList()) // ✅ Correct declaration
    val blogs: StateFlow<List<Blog>> = _blogs

    private var isFetching = false
    private var page = 1

    init {
        fetchBlogs()
    }

    fun fetchBlogs() {
        if(isFetching) return
        isFetching = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val blogList = blogRepository.getBlog(page)
                _blogs.value += blogList
                page++
                Log.d("BlogViewModel", "Fetched Page: $page, Blogs: ${blogList.size}")
            } catch (e: Exception) {
                Log.e("BlogViewModel", "Error Fetching Blogs", e)
            } finally {
                isFetching = false
            }
        }
    }
}
