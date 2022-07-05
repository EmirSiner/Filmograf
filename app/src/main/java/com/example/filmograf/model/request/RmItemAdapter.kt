package com.example.filmograf.model.request

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.filmograf.model.response.MovieResult

class RmItemAdapter(val rmItemListener: RmItemListener) : ListAdapter<MovieResult,RmItemHolder>(MovieResultDiffUtil) {

    private companion object MovieResultDiffUtil : DiffUtil.ItemCallback<MovieResult>() {
        override fun areItemsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean {
           return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RmItemHolder {
        return RmItemHolder.createHolder(parent)
    }

    override fun onBindViewHolder(holder: RmItemHolder, position: Int) {
        val rmText = getItem(position)
        holder.bind(rmText, rmItemListener)
    }
}