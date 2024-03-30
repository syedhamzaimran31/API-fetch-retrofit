package com.example.apifetch.API.Models

data class CommentsResponse(

    val comments:List<CommentsDummy>,
    val total:Int,
    val skip:Int,
    val limit:Int

)
