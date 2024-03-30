package com.example.apifetch.API.Models

data class CommentsDummy (
    val id :Int,
    val body:String,
    val postId:Int,
    val user:userDummy
)