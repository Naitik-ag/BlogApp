package com.example.blogapp.di

import android.content.Context
import androidx.room.Room
import com.example.blogapp.data.database.BlogDao
import com.example.blogapp.data.database.BlogDatabase
import com.example.blogapp.data.network.BlogApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://blog.vrid.in/wp-json/wp/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideBlogApi(retrofit: Retrofit): BlogApi {
        return retrofit.create(BlogApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): BlogDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            BlogDatabase::class.java,
            "blog_database"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideBlogDao(database: BlogDatabase): BlogDao {
        return database.blogDao()
    }

}