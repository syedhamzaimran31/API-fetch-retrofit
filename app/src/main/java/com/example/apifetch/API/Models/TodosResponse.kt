package com.example.apifetch.API.Models

data class TodosResponse(

    val todos:List<TodosDummyResponse>,
    val total:Int,
    val skip:Int,
    val limit:Int
)
