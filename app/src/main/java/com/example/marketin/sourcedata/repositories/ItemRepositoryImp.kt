package com.example.marketin.sourcedata.repositories

import com.example.marketin.sourcedata.ItemResponse
import com.example.marketin.sourcedata.network.ItemApi
import com.example.marketin.sourcedata.network.RetrofitInstance
import javax.inject.Inject

class ItemRepositoryImp  {
    private val appApi= RetrofitInstance.api

    suspend fun showItems(): ItemResponse{
        return appApi.getItems()
    }
}