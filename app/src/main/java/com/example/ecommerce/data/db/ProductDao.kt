package com.example.ecommerce.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(productEntity: ProductEntity)

    @Query("SELECT * FROM product WHERE amount > 0")
    suspend fun getProducts(): List<ProductEntity>

    @Query("SELECT amount FROM product WHERE code = :code")
    suspend fun getItemCount(code: String) : Int?

    @Delete
    suspend fun removeProduct(productEntity: ProductEntity)
}