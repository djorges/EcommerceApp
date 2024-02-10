package com.example.ecommerce.data.api

import com.google.gson.annotations.SerializedName

data class ProductListDto(
    @field:SerializedName("products")
    val products: List<ProductDto>
)