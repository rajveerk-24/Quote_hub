package com.sarrafenterprises.quotesapp.Screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.sarrafenterprises.quotesapp.models.Quotes

@Composable
fun QuoteList(data : Array<Quotes>, onClick : (quote : Quotes) -> Unit) {

    LazyColumn(
        content = {
            items(data) {
                QuoteListItem(quotes = it, onClick)
            }
        }
    )
}