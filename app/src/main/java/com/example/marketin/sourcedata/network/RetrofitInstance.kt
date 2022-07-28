package com.example.marketin.sourcedata.network

import com.example.marketin.BuildConfig
import com.example.marketin.sourcedata.network.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {


    val moshi= Moshi.Builder().add(KotlinJsonAdapterFactory()).build()


    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder().also { client ->
                    if (BuildConfig.DEBUG){
                        val logging= HttpLoggingInterceptor()
                        logging.setLevel((HttpLoggingInterceptor.Level.BODY))
                        client.addInterceptor(logging)
                    }

                }.build()
            )
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .build()
    }

    val api:ItemApi by  lazy {
        retrofit.create(ItemApi::class.java)
    }
}