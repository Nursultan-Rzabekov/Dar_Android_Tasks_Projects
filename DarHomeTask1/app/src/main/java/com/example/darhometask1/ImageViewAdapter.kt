package com.example.darhometask1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_row.view.*


class ImageViewAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {


    // numberOfItems
    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): CustomViewHolder {
        // how do we even create a view
        val layoutInflater = LayoutInflater.from(p0?.context)
        val cellForRow = layoutInflater.inflate(R.layout.image_row, p0, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(p0: CustomViewHolder, position: Int) {
//        val videoTitle = videoTitles.get(position)
        val video = homeFeed.videos.get(position)
        Picasso.with(p0?.view?.context).load(video.imageUrl).into(p0.imageview)
    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val imageview = view.imageview
}















