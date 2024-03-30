package com.example.apifetch.API

import com.example.apifetch.API.Models.Albums
import com.example.apifetch.API.Models.Comments
import com.example.apifetch.API.Models.CommentsResponse
import com.example.apifetch.API.Models.Post
import com.example.apifetch.API.Models.Products
import com.example.apifetch.API.Models.ProductsResponse
import com.example.apifetch.API.Models.QuotesResponse
import com.example.apifetch.API.Models.RecipesResponse
import com.example.apifetch.API.Models.Todos
import com.example.apifetch.API.Models.TodosResponse
import com.example.apifetch.API.Models.UserResponse
import com.example.apifetch.API.Models.Users
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

//    @GET("marvel/")
//    fun superHeroesData(): Call<JSONArray>

    @GET("posts")
    fun postsData(): Call<List<Post>>

    @GET("comments")
    fun commentsData(): Call<List<Comments>>

    @GET("/users")
    fun usersData(): Call<List<UserResponse>>

    @GET("/albums")
    fun albumsData(): Call<List<Albums>>

    @GET("/todos")
    fun todosData(): Call<TodosResponse>

    @GET("/products")
    fun productsData(): Call<ProductsResponse>

    @GET("/todos")
    fun todosData2(): Call<JSONObject>

    @GET("/recipes")
    fun recipesData(): Call<RecipesResponse>

    @GET("/quotes")
    fun quotesData(): Call<QuotesResponse>

    @GET("/comments")
    fun commentsData2(): Call<CommentsResponse>

}