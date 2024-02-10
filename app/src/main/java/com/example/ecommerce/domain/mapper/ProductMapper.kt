package com.example.ecommerce.domain.mapper

import com.example.ecommerce.data.api.ProductDto
import com.example.ecommerce.domain.model.ProductCode
import com.example.ecommerce.domain.model.ProductItem

fun ProductDto.toModel(): ProductItem{
    return ProductItem(
        code = ProductCode.valueOf(this.code),
        name = this.name,
        price = this.price
    )
}