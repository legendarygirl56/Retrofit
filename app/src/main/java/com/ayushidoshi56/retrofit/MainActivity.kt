package com.ayushidoshi56.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ayushidoshi56.retrofit.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository=Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPostViewModel()
        val text = findViewById<TextView>(R.id.txt1)
        viewModel.myResponse.observe(this, Observer { response ->
            Log.d("THE", response.userId.toString())
            Log.d("THE", response.id.toString())
            Log.d("TAGGGG", response.toString())
            text.text=response.toString()
        });

        Log.d("TAGGGG","ayu" )
    }
}