package com.example.ecommerce.domain.usecase

import com.example.ecommerce.domain.model.ProductItem
import com.example.ecommerce.domain.repository.ProductRepository
import javax.inject.Inject

class GetItemCountUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(productItem: ProductItem):Int{
        return repository.getItemCount(productItem.code.name) ?: 0
    }
}