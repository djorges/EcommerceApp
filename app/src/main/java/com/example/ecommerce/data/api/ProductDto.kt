package com.example.ecommerce.data.api

import com.google.gson.annotations.SerializedName

data class ProductDto(
    @field:SerializedName("code")
    val code:String,
    @field:SerializedName("name")
    val name:String,
    @field:SerializedName("price")
    val price:Double
)