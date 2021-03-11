package com.ayushidoshi56.retrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ayushidoshi56.retrofit.api.RetrofitClient
import com.ayushidoshi56.retrofit.model.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    var _downloadedData=MutableLiveData<ApiResponse>()
    fun getPost(){
        RetrofitClient.instance.simpleApi.getPost()
            .enqueue(object : Callback<ApiResponse> {
                override fun onResponse(
                    call: Call<ApiResponse>,
                    response: Response<ApiResponse>
                ){
                    if (response.isSuccessful) {
                        _downloadedData.postValue(response.body())
                    } else {

                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {

                }
            })

    }

}