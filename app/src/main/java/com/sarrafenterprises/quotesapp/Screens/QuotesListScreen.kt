package com.sarrafenterprises.quotesapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.shape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarrafenterprises.quotesapp.models.Quotes

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuoteListScreen(data : Array<Quotes>, onClick: (quote : Quotes) -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
    ) {
            Text(text = "Quote hub",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp, 24.dp)
                    .fillMaxWidth(1f),
                style = MaterialTheme.typography.titleLarge,
                fontFamily = FontFamily.Cursive,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold)




        QuoteList(data = data, onClick)
    }
}
