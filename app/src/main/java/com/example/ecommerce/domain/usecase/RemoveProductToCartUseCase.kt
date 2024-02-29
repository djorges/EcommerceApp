package com.example.ecommerce.domain.usecase

import com.example.ecommerce.domain.mapper.toEntity
import com.example.ecommerce.domain.model.CartItem
import com.example.ecommerce.domain.repository.ProductRepository
import javax.inject.Inject


class RemoveProductToCartUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(cartItem: CartItem){
        repository.removeItemFromCart(cartItem.toEntity())
    }
}