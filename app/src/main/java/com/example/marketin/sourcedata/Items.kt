package com.example.marketin.sourcedata

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.parcelize.Parcelize

@Parcelize
data class Items (
    val name:String,
    val price:String,
    val image_urls:List<String>,
    val image_urls_thumbnails:List<String>

        ):Parcelable


@Parcelize
 data class ItemResponse(  val results:List<Items>  ):Parcelable
