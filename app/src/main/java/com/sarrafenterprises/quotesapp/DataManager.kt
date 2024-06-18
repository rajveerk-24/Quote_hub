package com.sarrafenterprises.quotesapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.sarrafenterprises.quotesapp.models.Quotes

object DataManager {

var data = emptyArray<Quotes>()

    var currentPage = mutableStateOf(pages.LISTING)
    var currentQuote  : Quotes? = null

    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context: Context){
        val inputStream = context.assets.open("quote.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quotes>::class.java)
        isDataLoaded.value = true

    }

    fun switchPage(quote : Quotes?){
        if (currentPage.value == pages.LISTING){
            currentQuote = quote
            currentPage.value = pages.DETAIL
        }else{
            currentPage.value = pages.LISTING
        }
    }

}