package com.sarrafenterprises.quotesapp.Screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarrafenterprises.quotesapp.R
import com.sarrafenterprises.quotesapp.models.Quotes

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun QuoteListItem(quotes: Quotes, onClick: (quote: Quotes) -> Unit){
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp),
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .background(Color.White)
            .clickable { onClick(quotes) }

    ) {

        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Quote Image",
                alignment = Alignment.TopStart,
                modifier = Modifier
                    .size(40.dp)
//                    .rotate(180F)
                    .background(Color.Transparent)
            )
            Spacer(modifier = Modifier.padding(5.dp))

            Column(
                modifier = Modifier.weight(1f)
            ){
                Text(text = quotes.quote,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    fontSize = 15.sp)

                Spacer(modifier = Modifier.height(3.dp))

                Box(modifier = Modifier
                    .background(Color(0xFFEEEEEE))
                    .fillMaxWidth(.4f)
                    .height(1.dp)
                )
                Text(text = quotes.author
                    , style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                    fontWeight = FontWeight.Thin,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 4.dp))
            }


        }


    }
}


