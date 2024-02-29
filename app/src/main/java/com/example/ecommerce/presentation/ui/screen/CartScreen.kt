package com.example.ecommerce.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecommerce.domain.model.CartItem
import com.example.ecommerce.presentation.ui.compos.StoreButton
import com.example.ecommerce.presentation.viewmodel.CartViewModel

@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    viewModel: CartViewModel = hiltViewModel()
){
    val state = viewModel.state

    if(state.isLoading){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator(
                color = Color.Blue
            )
        }
    }

    if(state.items.isNotEmpty()){
        LazyColumn(modifier = modifier.fillMaxSize()){
            items(state.items){
                CartItem(
                    cartItem = it,
                    onAddItemToCart = { viewModel.addItemToCart(it)},
                    onDeleteItemToCart = { viewModel.minusItemToCart(it)}
                )
            }
        }
    }
}

@Composable
fun CartItem(
    cartItem: CartItem,
    modifier: Modifier = Modifier,
    onAddItemToCart: () -> Unit = {},
    onDeleteItemToCart: () -> Unit = {}
){
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        //Details
        Column{
            Text(text = cartItem.item.name)
            Text(text = "$${cartItem.item.price}")
        }
        //Actions
        Row(verticalAlignment = Alignment.CenterVertically){
            Column {
                StoreButton(text = "+", onClick = onAddItemToCart)
                StoreButton(text = "-", onClick = onDeleteItemToCart)
            }
            Text(text = "x${cartItem.amount}")
        }
    }
}