package com.example.apifetch.API.Models

data class ProductsResponse(
    val products:List<Products>,
    val total:Int,
    val skip:Int,
    val limit:Int
)
