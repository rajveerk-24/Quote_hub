package com.sarrafenterprises.quotesapp.Screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarrafenterprises.quotesapp.DataManager
import com.sarrafenterprises.quotesapp.R
import com.sarrafenterprises.quotesapp.models.Quotes

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuoteDetail(quotes: Quotes){

    BackHandler {
        DataManager.switchPage(null)
    }

    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
            Brush.linearGradient(
                colors = listOf(
                    Color(0xFFffffff),
                    Color(0xFF29B6F6)
                )
            )
        )){


    Box( contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
//            .fillMaxSize(1f)
) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            modifier = Modifier.padding(32.dp)
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
//                    .align(Alignment.Center)
                    .padding(16.dp, 24.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Quote Image",
                    alignment = Alignment.TopStart,
                    modifier = Modifier
                        .size(60.dp)
//                    .rotate(180F)
                        .background(Color.Transparent)
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = quotes.quote,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "- ${quotes.author}", style = MaterialTheme.typography.displayMedium,
                    color = Color.Black,
//                    fontWeight = FontWeight.Thin,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )

            }


        }
    }
        Text(text = "Made with ❤ in India by Rajveer",
            style = MaterialTheme.typography.displayMedium,
            fontSize = 8.sp,
            textAlign = TextAlign.End,

        )
    }
}