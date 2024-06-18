package com.sarrafenterprises.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sarrafenterprises.quotesapp.Screens.QuoteDetail
import com.sarrafenterprises.quotesapp.Screens.QuoteListItem
import com.sarrafenterprises.quotesapp.Screens.QuoteListScreen
import com.sarrafenterprises.quotesapp.ui.theme.QuotesAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
        DataManager.loadAssetsFromFile(applicationContext)
        }


        setContent {
            App()
        }
    }
}


@Composable
fun App() {


    if (DataManager.isDataLoaded.value) {

        if (DataManager.currentPage.value == pages.LISTING){

        QuoteListScreen(data = DataManager.data) {

            DataManager.switchPage(it)
        }
        }
        else{
            DataManager.currentQuote?.let { QuoteDetail(quotes = it) }

        }
    }
    else{
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            CircularProgressIndicator()
        }
    }
}


enum class pages{
    LISTING,
    DETAIL
}