package com.example.ecommerce.data.repository

import com.example.ecommerce.data.api.ProductApi
import com.example.ecommerce.data.api.ProductDto
import com.example.ecommerce.domain.model.ProductItem
import com.example.ecommerce.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi
): ProductRepository {
    override suspend fun getProducts(): List<ProductDto>{
        return api.getProducts().products
    }

    override suspend fun getCart(): List<ProductItem> {
        TODO("Not yet implemented")
    }

    override suspend fun addItemToCart(item: ProductItem) {
        TODO("Not yet implemented")
    }

}