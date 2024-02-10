package com.example.ecommerce.data.di

import com.example.ecommerce.data.repository.ProductRepositoryImpl
import com.example.ecommerce.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{

    @Singleton
    @Binds
    abstract fun bindProductRepository(
        repoImpl: ProductRepositoryImpl
    ): ProductRepository
}