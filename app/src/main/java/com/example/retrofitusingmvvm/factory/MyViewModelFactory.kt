package com.example.retrofitusingmvvm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitusingmvvm.repository.MainRepository
import com.example.retrofitusingmvvm.viewModel.MainViewModel

class MyViewModelFactory(private val repository: MainRepository?): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            this.repository?.let { MainViewModel(it) } as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}