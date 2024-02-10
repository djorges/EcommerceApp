package com.example.ecommerce.domain.usecase

import com.example.ecommerce.domain.mapper.toModel
import com.example.ecommerce.domain.model.ProductItem
import com.example.ecommerce.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
   private val repository: ProductRepository
) {
    suspend operator fun invoke(): Result<List<ProductItem>>{
        return try{
            val items = repository.getProducts().map { it.toModel() }

            Result.success(items)
        }catch(e:Exception){
            Result.failure(e)
        }
    }
}