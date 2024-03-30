package com.example.apifetch.API.Models

data class UserResponse (

    val id:Int,
    val name:String,
    val username:String,
    val email:String,
    val address: Address,
    val phone:String,
    val website:String,
    val company:Company

)