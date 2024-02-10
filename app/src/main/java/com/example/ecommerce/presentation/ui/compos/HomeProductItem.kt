package com.example.ecommerce.presentation.ui.compos

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeProductItem(
    title: String,
    price: Double,
    modifier: Modifier = Modifier,
    onClick:() -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .clickable {
                onClick()
            }
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(text = title)
        Text(text = "$$price")
    }
}

@Preview
@Composable
fun HomeProductItemPreview(){
    HomeProductItem(title = "Coffee Mug", price = 7.5, onClick = {})
}