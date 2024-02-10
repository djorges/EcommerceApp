package com.example.ecommerce.presentation.ui.state

import com.example.ecommerce.domain.model.ProductItem

data class HomeState(
    val products:List<ProductItem> = emptyList(),
    val isLoading:Boolean = false
)
