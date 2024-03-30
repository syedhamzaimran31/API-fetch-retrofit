package com.example.apifetch.API.Models

data class QuotesResponse(
    val limit: Int,
    val quotes: List<Quotes>,
    val skip: Int,
    val total: Int
)
