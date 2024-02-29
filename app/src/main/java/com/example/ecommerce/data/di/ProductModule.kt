package com.example.ecommerce.data.di

import android.content.Context
import androidx.room.Room
import com.example.ecommerce.data.api.ProductApi
import com.example.ecommerce.data.db.ProductDao
import com.example.ecommerce.data.db.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ProductModule{
    @Provides
    @Singleton
    fun provideApi(): ProductApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDao(
        @ApplicationContext context: Context
    ): ProductDao{
        return Room.databaseBuilder(
            context,
            ProductDatabase::class.java,
            DB_NAME
        ).build().dao
    }
    private const val DB_NAME = "product_db"
    private const val BASE_URL = "https://raw.githubusercontent.com/djorges/EcommerceApp/master/app/src/main/res/raw/"
}