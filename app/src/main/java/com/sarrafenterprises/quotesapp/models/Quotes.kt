package com.sarrafenterprises.quotesapp.models

import kotlinx.serialization.Serializable

@Serializable
data class Quotes(
    val quote : String,
    val author : String
)
