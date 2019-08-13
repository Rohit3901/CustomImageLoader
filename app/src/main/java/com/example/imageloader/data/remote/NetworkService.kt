package com.example.imageloader.data.remote

import com.example.imageloader.data.remote.response.PhotosResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(Endpoints.PHOTOS)
    fun getPhotos(
        @Query("client_id") clientId: String
    ): Single<List<PhotosResponse>>

}