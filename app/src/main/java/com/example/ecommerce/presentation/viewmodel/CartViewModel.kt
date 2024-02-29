package com.example.ecommerce.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.domain.model.CartItem
import com.example.ecommerce.domain.usecase.AddProductToCartUseCase
import com.example.ecommerce.domain.usecase.GetCartUseCase
import com.example.ecommerce.domain.usecase.GetItemCountUseCase
import com.example.ecommerce.domain.usecase.MinusProductToCartUseCase
import com.example.ecommerce.domain.usecase.RemoveProductToCartUseCase
import com.example.ecommerce.presentation.ui.state.CartState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getCartUseCase: GetCartUseCase,
    private val addProductToCartUseCase: AddProductToCartUseCase,
    private val minusProductToCartUseCase: MinusProductToCartUseCase,
    private val getItemCountUseCase: GetItemCountUseCase
) : ViewModel(){
    var state by mutableStateOf(CartState())
        private set

    init {
        getCart()
    }

    private fun getCart() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)

            val cartItems = getCartUseCase()

            state = state.copy(isLoading = false, items = cartItems)
        }
    }

    fun addItemToCart(item:CartItem) {
        viewModelScope.launch {
            val count = getItemCountUseCase(item.item)
            addProductToCartUseCase(item.item, count)
        }
    }
    fun minusItemToCart(item:CartItem) {
        viewModelScope.launch {
            val count = getItemCountUseCase(item.item)
            minusProductToCartUseCase(item.item, count)
        }
    }


}