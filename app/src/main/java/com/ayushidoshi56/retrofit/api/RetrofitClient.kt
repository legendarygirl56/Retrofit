package com.ayushidoshi56.retrofit.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    val simpleApi:SimpleApi
    companion object{
        private var retrofitClient:RetrofitClient? = null
        val instance:RetrofitClient
        get() {
            if (retrofitClient == null)
            {
                retrofitClient= RetrofitClient()
            }
            return retrofitClient as RetrofitClient
        }
    }
    init {
        val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        val retrofit= Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
        simpleApi=retrofit.create(SimpleApi::class.java)
    }
}