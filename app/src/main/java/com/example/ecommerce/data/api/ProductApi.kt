package com.example.ecommerce.data.api

import retrofit2.http.GET

interface ProductApi {
    @GET("products.json")
    suspend fun getProducts(): ProductListDto
}