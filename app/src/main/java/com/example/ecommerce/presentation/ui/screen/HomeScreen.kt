package com.example.ecommerce.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecommerce.presentation.ui.compos.HomeProductItem
import com.example.ecommerce.presentation.ui.compos.StoreButton
import com.example.ecommerce.presentation.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onCartClick: () -> Unit
){
    val state = viewModel.state
    if(state.isLoading){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }

    if(state.products.isNotEmpty()){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp)
            ){
                items(state.products){
                    HomeProductItem(
                        title = it.name,
                        price = it.price,
                        modifier = Modifier.padding(16.dp),
                        onClick = {viewModel.onItemClick(it)}
                    )
                }
            }
            StoreButton(
                text = "Go to cart",
                onClick = onCartClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}