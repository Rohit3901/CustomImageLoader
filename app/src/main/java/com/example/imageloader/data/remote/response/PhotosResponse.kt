package com.example.imageloader.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PhotosResponse(
    val id:String,
    val width:Int,
    val height:Int,
    @SerializedName("urls")
    val urls: UrlsData

):Parcelable

@Parcelize
data class UrlsData(
    val raw:String,
    val full:String,
    val regular:String,
    val small:String
):Parcelable