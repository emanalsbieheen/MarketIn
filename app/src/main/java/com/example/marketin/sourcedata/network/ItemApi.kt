package com.example.marketin.sourcedata.network

import com.example.marketin.BuildConfig
import com.example.marketin.sourcedata.ItemResponse
import com.example.marketin.sourcedata.Items
import com.example.marketin.sourcedata.network.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ItemApi {

    @GET("default/dynamodb-writer")
    suspend fun getItems():ItemResponse








}