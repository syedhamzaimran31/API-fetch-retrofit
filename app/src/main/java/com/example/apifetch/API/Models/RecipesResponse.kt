package com.example.apifetch.API.Models

data class RecipesResponse (

    val recipes:List<Recipes>,
    val total:Int,
    val skip:Int,
    val limit:Int
)