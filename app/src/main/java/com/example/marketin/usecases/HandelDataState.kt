package com.example.marketin.usecases

sealed class HandelDataState <out T>(val data:T?=null , val message:String?=null) {
    class Success<T>(data:T): HandelDataState<T>(data)

    class Error<T>(message: String?,data: T?=null):HandelDataState<T>(data,message)
}

