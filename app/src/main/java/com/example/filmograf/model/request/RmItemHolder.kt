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
    fun bind(movieResult: MovieResult,  rmItemListener: RmItemListener) {
        val rmtwname = itemView.findViewById<TextView>(R.id.rmItemName)
        val rmImgView = itemView.findViewById<ImageView>(R.id.rmImageView)
        rmtwname.text = movieResult.name
        Glide.with(rmImgView).load(movieResult.imageUrl).into(rmImgView)
        itemView.setOnClickListener {
            rmItemListener.onItemClicked(
                movieResult.id
            )
        }
    }

}