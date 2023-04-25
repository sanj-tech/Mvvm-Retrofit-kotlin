package com.example.retrofitusingmvvm.repository

import com.example.retrofitusingmvvm.retroServices.RetrofitService

class MainRepository (private val retrofitService: RetrofitService) {

    fun getAllMovies() = retrofitService.getMyMovies()
}