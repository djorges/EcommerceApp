package com.example.ecommerce.domain.repository

import com.example.ecommerce.data.api.ProductDto
import com.example.ecommerce.data.db.ProductEntity
import com.example.ecommerce.domain.model.CartItem
import com.example.ecommerce.domain.model.ProductItem

interface ProductRepository {
    suspend fun getProducts(): List<ProductDto>
    suspend fun getCart(): List<ProductEntity>
    suspend fun addItemToCart(entity: ProductEntity)
    suspend fun getItemCount(code: String): Int?
    suspend fun removeItemFromCart(entity: ProductEntity)
}