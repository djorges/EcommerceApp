package com.example.ecommerce.domain.mapper

import com.example.ecommerce.data.api.ProductDto
import com.example.ecommerce.data.db.ProductEntity
import com.example.ecommerce.domain.model.CartItem
import com.example.ecommerce.domain.model.ProductCode
import com.example.ecommerce.domain.model.ProductItem

fun ProductDto.toModel(): ProductItem{
    return ProductItem(
        code = ProductCode.valueOf(this.code),
        name = this.name,
        price = this.price
    )
}

fun CartItem.toEntity(): ProductEntity{
    return ProductEntity(
        name = this.item.name,
        code =  this.item.code,
        price = this.item.price,
        amount = this.amount
    )
}

fun ProductEntity.toModel(): CartItem{
    val item = ProductItem(
        name = this.name,
        code = this.code,
        price = this.price
    )
    return CartItem(
        item = item,
        amount = this.amount
    )
}