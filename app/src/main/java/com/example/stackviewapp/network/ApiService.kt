package com.example.stackviewapp.network

import retrofit2.http.GET

data class StackItemResponse(val id: Int, val title: String)

interface ApiService {
    @GET("test_mint")
    suspend fun getStackItems(): List<StackItemResponse>
}
