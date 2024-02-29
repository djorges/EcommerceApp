package com.example.ecommerce.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ecommerce.domain.model.ProductCode

@Entity(
    tableName = "product"
)
data class ProductEntity (
    @PrimaryKey(autoGenerate = false)
    val code:ProductCode,
    val name: String,
    val price: Double,
    val amount: Int
)