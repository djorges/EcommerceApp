package com.example.ecommerce.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.domain.model.ProductItem
import com.example.ecommerce.domain.usecase.AddProductToCartUseCase
import com.example.ecommerce.domain.usecase.GetProductsUseCase
import com.example.ecommerce.presentation.ui.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val addProductToCartUseCase: AddProductToCartUseCase
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init{
        getProducts()
    }

    fun onItemClick(productItem: ProductItem){
        viewModelScope.launch {
            addProductToCartUseCase.invoke(productItem)
        }
    }

    private fun getProducts(){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )

            getProductsUseCase.invoke()
                .onSuccess {
                    state = state.copy(
                        products = it
                    )
                }
                .onFailure {

                }

            state = state.copy(
                isLoading = false
            )
        }
    }
}