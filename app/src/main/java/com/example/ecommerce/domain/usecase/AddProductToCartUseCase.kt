package com.example.ecommerce.domain.usecase

import com.example.ecommerce.domain.model.ProductItem
import com.example.ecommerce.domain.repository.ProductRepository
import javax.inject.Inject

class AddProductToCartUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(productItem: ProductItem){
       repository.addItemToCart(productItem)
    }
}