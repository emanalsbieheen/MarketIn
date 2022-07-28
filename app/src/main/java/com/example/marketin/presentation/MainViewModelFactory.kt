package com.example.marketin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marketin.sourcedata.repositories.ItemRepositoryImp



@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val repositoryImp: ItemRepositoryImp): ViewModelProvider.Factory

{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(repositoryImp) as T
            else -> throw IllegalArgumentException(" ViewModel Class is not found")


        }
    }
}