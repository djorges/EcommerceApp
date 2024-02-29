package com.example.ecommerce.domain.usecase

import com.example.ecommerce.domain.mapper.toModel
import com.example.ecommerce.domain.model.CartItem
import com.example.ecommerce.domain.model.ProductItem
import com.example.ecommerce.domain.repository.ProductRepository
import javax.inject.Inject

class GetCartUseCase @Inject constructor(
    private val repository: ProductRepository
){
    suspend operator fun invoke(): List<CartItem>{
        return repository.getCart().map { it.toModel() }
    }
}