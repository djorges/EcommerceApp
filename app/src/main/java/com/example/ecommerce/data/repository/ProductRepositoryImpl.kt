package com.example.ecommerce.data.repository

import com.example.ecommerce.data.api.ProductApi
import com.example.ecommerce.data.api.ProductDto
import com.example.ecommerce.data.db.ProductDao
import com.example.ecommerce.data.db.ProductEntity
import com.example.ecommerce.domain.mapper.toModel
import com.example.ecommerce.domain.model.CartItem
import com.example.ecommerce.domain.model.ProductItem
import com.example.ecommerce.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi,
    private val dao: ProductDao
): ProductRepository {
    override suspend fun getProducts(): List<ProductDto>{
        return api.getProducts().products
    }

    override suspend fun getCart(): List<ProductEntity> {
        return dao.getProducts()
    }

    override suspend fun addItemToCart(entity: ProductEntity) {
        dao.insertProduct(entity)
    }

    override suspend fun getItemCount(code:String): Int?{
        return dao.getItemCount(code)
    }
    override suspend fun removeItemFromCart(entity: ProductEntity){
        return dao.removeProduct(entity)
    }
}