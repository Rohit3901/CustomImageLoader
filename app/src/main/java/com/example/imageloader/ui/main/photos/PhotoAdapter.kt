package com.example.imageloader.ui.main.photos


import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.example.imageloader.data.remote.response.PhotosResponse
import com.example.imageloader.ui.base.BaseAdapter

class PhotoAdapter (
    parentLifecycle: Lifecycle,
    photos:ArrayList<PhotosResponse>
): BaseAdapter<PhotosResponse, PhotoItemViewHolder>(parentLifecycle,photos){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= PhotoItemViewHolder(parent)


}