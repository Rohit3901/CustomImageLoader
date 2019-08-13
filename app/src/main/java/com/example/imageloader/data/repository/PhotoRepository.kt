package com.example.imageloader.data.repository

import com.example.imageloader.BuildConfig
import com.example.imageloader.data.remote.NetworkService
import com.example.imageloader.data.remote.response.PhotosResponse
import io.reactivex.Single
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val networkService: NetworkService
){
    fun fetchPhotos():Single<List<PhotosResponse>> = networkService.getPhotos(BuildConfig.CLIENT_ID)
}