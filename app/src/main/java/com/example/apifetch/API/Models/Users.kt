package com.example.apifetch.API.Models

import org.json.JSONObject

data class Users(

    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: JSONObject,
    val street:String

)
