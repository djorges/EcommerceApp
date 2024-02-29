package com.example.ecommerce.domain.usecase

import com.example.ecommerce.domain.mapper.toEntity
import com.example.ecommerce.domain.model.CartItem
import com.example.ecommerce.domain.model.ProductItem
import com.example.ecommerce.domain.repository.ProductRepository
import javax.inject.Inject

class MinusProductToCartUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(productItem: ProductItem, count: Int){
        if(count <= 0) return
        
        val newCount = count - 1
        val cartItem = CartItem(
            item = productItem,
            amount = newCount
        )

        if(newCount == 0){
            repository.removeItemFromCart(cartItem.toEntity())
        }else {
            repository.addItemToCart(cartItem.toEntity())
        }
    }
}