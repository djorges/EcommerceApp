package com.example.ecommerce.domain.repository

import com.example.ecommerce.data.api.ProductDto
import com.example.ecommerce.domain.model.ProductItem

interface ProductRepository {
    suspend fun getProducts(): List<ProductDto>
    suspend fun getCart(): List<ProductItem>
    suspend fun addItemToCart(item:ProductItem)
}