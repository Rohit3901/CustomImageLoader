package com.example.imageloader

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.customimageloader.DoubleCache
import com.example.customimageloader.ImageLoader

class ImageAdapter(private val items: ArrayList<String>, private val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        ImageLoader.setCache(DoubleCache(context))
        //ImageLoader.with(context).load(holder.imageView, items[position])
        ImageLoader.displayImage(items[position], holder.imageView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imageView = view.findViewById(R.id.item_imageView) as ImageView
}