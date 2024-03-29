package com.example.ecommerce.domain.usecase

import com.example.ecommerce.domain.mapper.toEntity
import com.example.ecommerce.domain.model.CartItem
import com.example.ecommerce.domain.model.ProductItem
import com.example.ecommerce.domain.repository.ProductRepository
import javax.inject.Inject

class AddProductToCartUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(productItem: ProductItem, count: Int){
        val cartItem = CartItem(
            item = productItem,
            amount = count + 1
        )
       repository.addItemToCart(cartItem.toEntity())
    }
}