package com.ayushidoshi56.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ayushidoshi56.retrofit.model.ApiResponse
import com.ayushidoshi56.retrofit.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository):ViewModel() {

    var myResponse:MutableLiveData<ApiResponse> = MutableLiveData()
    fun getPostViewModel()
    {
        viewModelScope.launch {
            repository.getPost()
            myResponse=repository._downloadedData
        }
    }
}