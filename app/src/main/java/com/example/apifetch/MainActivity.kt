package com.example.apifetch

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apifetch.API.Models.Albums
import com.example.apifetch.API.Models.Comments
import com.example.apifetch.API.Models.CommentsResponse
import com.example.apifetch.API.Models.Post
import com.example.apifetch.API.Models.ProductsResponse
import com.example.apifetch.API.Models.QuotesResponse
import com.example.apifetch.API.Models.RecipesResponse
import com.example.apifetch.API.Models.Todos
import com.example.apifetch.API.Models.TodosDummyResponse
import com.example.apifetch.API.Models.TodosResponse
import com.example.apifetch.API.Models.UserResponse
import com.example.apifetch.API.RetrofitClient
import com.example.apifetch.databinding.ActivityMainBinding
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val fetchApi: Button = findViewById<Button>(R.id.fetchApi)
//
//        // getting the recyclerview by its id
//        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
//
//        // this creates a vertical layout Manager
//        recyclerview.layoutManager = LinearLayoutManager(this)
//
//        // ArrayList of class ItemsViewModel
//        val data = ArrayList<ItemsViewModel>()
//
//        // This loop will create 20 Views containing
//        // the image with the count of view
//        for (i in 1..5) {
//            data.add(ItemsViewModel(R.drawable.cc, "Item " + i))
//        }
//
//        // This will pass the ArrayList to our Adapter
//        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
//        recyclerview.adapter = adapter

        binding.fetchApi.setOnClickListener {
//            fetchPostsData()
//            fetchCommentsData()
//            fetchUsersData()
//            fetchAlbumsData()
            fetchtodosData()
//            fetchProductsData()
//            fetchQuotes()
//            fetchProductsData()
//              fetchCommentsData2()
//            fetchRecipesData()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG","Message")

    }
//    fun fetchRecords() {
////        val call: Call<JSONArray> = RetrofitClient.apiService.superHeroesData()
//
//        call.enqueue(object : Callback<JSONArray> {
//            override fun onResponse(call: Call<JSONArray>, response: Response<JSONArray>) {
//                if (response.isSuccessful) {
//                    val superHeroesData: JSONArray? = response.body()
//                    println("Response:${superHeroesData}")
//                } else {
//                    print("Failed")
//                }
//            }
//
//            override fun onFailure(call: Call<JSONArray>, t: Throwable) {
//                print(t.message)
//            }
//        })
//
//    }

    fun fetchPostsData() {
        val call: Call<List<Post>> = RetrofitClient.apiService.postsData()

        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val superHeroesData: List<Post>? = response.body()
                    println("Response:${superHeroesData}")
                    val postObject = superHeroesData?.get(0)
                    println("The json Object is ${postObject}")
                    Toast.makeText(applicationContext, "Success on Response", Toast.LENGTH_SHORT)
                        .show()

                } else {
//                    print("Failed")
                    Toast.makeText(applicationContext, "Failure on else", Toast.LENGTH_SHORT).show()

                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(applicationContext, "Failure", Toast.LENGTH_SHORT).show()
//                print(t.message)
            }
        })
    }

    fun fetchCommentsData() {
        val call: Call<List<Comments>> = RetrofitClient.apiService.commentsData()

        call.enqueue(object : Callback<List<Comments>> {
            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {
                val apiTV = binding.apiResponseTV

                if (response.isSuccessful) {
                    val superHeroesData: List<Comments>? = response.body()
                    println("Response:${superHeroesData}")

                    val commentObj = superHeroesData?.get(0)
                    println("The json Object is ${commentObj}")
                    apiTV.text = "Response: ${commentObj?.toString() ?: "No data"}"

                    Toast.makeText(applicationContext, "Success on Response", Toast.LENGTH_SHORT)
                        .show()

//                    val json = JSONArray(superHeroesData)
//                    val jsonObj = json.getJSONObject(0)
//                    println("Json Object at index 0${jsonObj}")
//                    Log.d("TAg", "${jsonObj}")

                } else {
                    apiTV.text = "Failed to fetch data"
                    print("Failed")
                }
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                val apiTV = binding.apiResponseTV
                apiTV.text = "Failure: ${t.message}"
//                print(t.message)
            }
        })
    }

    fun fetchUsersData() {
        val call: Call<List<UserResponse>> = RetrofitClient.apiService.usersData()

        call.enqueue(object : Callback<List<UserResponse>> {
            override fun onResponse(
                call: Call<List<UserResponse>>,
                response: Response<List<UserResponse>>
            ) {
                val apiTV = binding.apiResponseTV

                if (response.isSuccessful) {
                    val usersData: List<UserResponse>? = response.body()
                    println("Response: $usersData")

                    val userObject = usersData?.get(0)
                    val userAddress = userObject?.address ?: "No data"
                    val userGeo = userObject?.address?.geo ?: "No data"

                    val userName = userObject?.name ?: "No data"
                    apiTV.text = "User Name: $userName \n Address: $userAddress "

                    Toast.makeText(applicationContext, "Success on Response", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    apiTV.text = "Failed to fetch user data"
                    println("Failed")
                }
            }

            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
                val apiTV = binding.apiResponseTV
                apiTV.text = "Failure: ${t.message}"
                println("Failure: ${t.message}")
            }
        })
    }

    fun fetchProductsData() {
        val call: Call<ProductsResponse> = RetrofitClient.apiService.productsData()
        val apiTV = binding.apiResponseTV

        call.enqueue(object : Callback<ProductsResponse> {
            override fun onResponse(
                call: Call<ProductsResponse>,
                response: Response<ProductsResponse>
            ) {
                if (response.isSuccessful) {
                    val productsData: ProductsResponse? = response.body()
                    println("Response: $productsData")

                    val productsObject = productsData?.products
                    val productsValue = productsObject?.get(0) ?: "No data"
//                    val userGeo = userObject?.address?.geo ?: "No data"

//                    val userName = userObject?.name ?: "No data"
                    runOnUiThread {
                        apiTV.text = "Total: $productsValue"
                        Toast.makeText(
                            applicationContext,
                            "Success on Response",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    apiTV.text = "Failed to fetch user data"
                    Toast.makeText(applicationContext, "Fail on Response", Toast.LENGTH_SHORT)
                        .show()

                    println("Failed")
                }
            }

            override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Fail", Toast.LENGTH_SHORT).show()
                apiTV.text = "${t.message}"
                print("API Call Failed: ${t.message}")
                t.printStackTrace()

            }

        })
    }

    private fun fetchQuotes() {
        val call: Call<QuotesResponse> = RetrofitClient.apiService.quotesData()
        call.enqueue(object : Callback<QuotesResponse> {
            override fun onResponse(
                call: Call<QuotesResponse>,
                response: Response<QuotesResponse>
            ) {
                val apiTV = binding.apiResponseTV
                if (response.isSuccessful) {
                    val quotesData = response.body()
                    println("Response : ${quotesData}")
                    val quotesList = quotesData!!.quotes
                    println("The quotes list is : ${quotesList}")
                    val quotesObject = quotesList.get(0)
                    println("Quotes Obj: ${quotesObject}")

                    apiTV.text =
                        "${quotesObject.toString()}  Limit: ${quotesData.limit} Skip: ${quotesData.skip} Total: ${quotesData.total}"
                } else {
                    println("Failed")
                }
            }

            override fun onFailure(call: Call<QuotesResponse>, t: Throwable) {
                println("Failed : ${t.printStackTrace()}")

            }
        })
    }
    fun fetchAlbumsData() {
        val call: Call<List<Albums>> = RetrofitClient.apiService.albumsData()
        call.enqueue(object : Callback<List<Albums>> {
            override fun onResponse(call: Call<List<Albums>>, response: Response<List<Albums>>) {
                if (response.isSuccessful) {
                    val albumsData: List<Albums>? = response.body()
                    println("Response:${albumsData}")

                    val albumsObj = albumsData?.get(0)
                    println("The json Object is ${albumsObj}")
                    Toast.makeText(applicationContext, "Success on Response", Toast.LENGTH_SHORT)
                        .show()
//                    val superHeroesData: List<Albums>? = response.body()
//                    println("Response:${superHeroesData}")
                } else {
                    print("Failed")
                }
            }

            override fun onFailure(call: Call<List<Albums>>, t: Throwable) {
                print(t.message)
            }
        })
    }

    fun fetchtodosData() {
        val call: Call<TodosResponse> = RetrofitClient.apiService.todosData()
        val apiTv=binding.apiResponseTV
        call.enqueue(object : Callback<TodosResponse> {
            override fun onResponse(call: Call<TodosResponse>, response: Response<TodosResponse>) {
                if (response.isSuccessful) {
                    val todosData: TodosResponse? = response.body()

                    val todosObj = todosData?.todos?.get(0)
                    apiTv.text="ToDos : $todosObj"
                    Toast.makeText(applicationContext, "Success on Response", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    print("Failed")
                }
            }

            override fun onFailure(call: Call<TodosResponse>, t: Throwable) {
                print(t.message)
            }
        })
    }


    fun fetchTodosData2() {
        val call: Call<JSONObject> = RetrofitClient.apiService.todosData2()
        call.enqueue(object : Callback<JSONObject> {
            override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
                if (response.isSuccessful) {
                    val todosData2: JSONObject? = response.body()
                    println("isSuccesful")
                } else {
                    println("isFailed")

                }
            }

            override fun onFailure(call: Call<JSONObject>, t: Throwable) {
                print(t.message)

            }

        })
    }

    fun fetchRecipesData() {
        val call: Call<RecipesResponse> = RetrofitClient.apiService.recipesData()
        val apiTV = binding.apiResponseTV

        call.enqueue(object : Callback<RecipesResponse> {
            override fun onResponse(
                call: Call<RecipesResponse>,
                response: Response<RecipesResponse>
            ) {
                if (response.isSuccessful) {
                    val recipesData: RecipesResponse? = response.body()
                    val recipesobj = recipesData?.recipes?.get(0)?.instructions
                    apiTV.text = "Instructions : $recipesobj"
                    Toast.makeText(applicationContext, "Success on Response", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(applicationContext, "Failure on Response", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<RecipesResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Failure", Toast.LENGTH_SHORT).show()
                apiTV.text = "$t.message"
                Log.d("ABCDEFG","${t.message}")
                print(t.message)

            }

        })
    }

    fun fetchCommentsData2() {
        val call: Call<CommentsResponse> = RetrofitClient.apiService.commentsData2()
        val apiTV = binding.apiResponseTV

        call.enqueue(object : Callback<CommentsResponse> {
            override fun onResponse(
                call: Call<CommentsResponse>,
                response: Response<CommentsResponse>
            ) {
                if (response.isSuccessful) {
                    val commentsData: CommentsResponse? = response.body()

                    val commentsObject = commentsData?.comments
                    val commentsValue = commentsObject?.get(0) ?: "No data"
                    val commentsUser = commentsObject?.get(0)?.user
                    runOnUiThread {
                        apiTV.text = "Comments Response $commentsData"
                        Toast.makeText(
                            applicationContext,
                            "Success on Response",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    apiTV.text = "Failed to fetch user data"
                    Toast.makeText(applicationContext, "Fail on Response", Toast.LENGTH_SHORT)
                        .show()

                    println("Failed")
                }
            }

            override fun onFailure(call: Call<CommentsResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Fail", Toast.LENGTH_SHORT).show()
                apiTV.text = "${t.message}"
                print("API Call Failed: ${t.message}")
                t.printStackTrace()

            }


        })
    }

}


