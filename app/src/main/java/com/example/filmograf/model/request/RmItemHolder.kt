package com.example.filmograf.model.request

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmograf.R
import com.example.filmograf.model.response.MovieResult

open class RmItemHolder private constructor(holderView: View) : RecyclerView.ViewHolder(holderView) {

    companion object {
        fun createHolder(parent: ViewGroup): RmItemHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val holderView = layoutInflater.inflate(R.layout.custom_tab,parent,false)
            return RmItemHolder(holderView)
        }
    }
    fun bind(
        movieResult: MovieResult,
        ffItemListener: RmItemListener
    ) {
        val fftwname = itemView.findViewById<TextView>(R.id.rmItemName)
        val ffImgView = itemView.findViewById<ImageView>(R.id.rmImageView)
        fftwname.text = movieResult.name
        Glide.with(ffImgView).load(movieResult.imageUrl).into(ffImgView)
        itemView.setOnClickListener {
            ffItemListener.onItemClicked(

                movieResult.id
            )
        }
    }

}