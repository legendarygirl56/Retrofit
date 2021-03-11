package com.ayushidoshi56.retrofit.api

import com.ayushidoshi56.retrofit.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface SimpleApi {
    @GET("posts/1")
    fun getPost(): Call<ApiResponse>
}