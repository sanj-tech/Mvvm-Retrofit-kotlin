package com.example.retrofitusingmvvm

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitusingmvvm.adapters.MainAdapter
import com.example.retrofitusingmvvm.databinding.ActivityMainBinding
import com.example.retrofitusingmvvm.factory.MyViewModelFactory
import com.example.retrofitusingmvvm.repository.MainRepository
import com.example.retrofitusingmvvm.retroServices.RetrofitService
import com.example.retrofitusingmvvm.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
       // setContentView(binding.root)
        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(retrofitService?.let { MainRepository(it) })
        ).get(MainViewModel::class.java)

        getMoviesList()

    }

    private fun getMoviesList() {
        binding.recyclerview.adapter = adapter
        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setMovieList(it)
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getAllMovies()
    }
}

