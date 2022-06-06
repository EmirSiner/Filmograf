package com.example.filmograf.ui.fragment.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.filmograf.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


class MoviesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val genresCG = view?.findViewById<ChipGroup>(R.id.movieGenresCG)

        val genres = listOf("Horror", "Adventure", "Action")

        /*
        {
         "genres": [
           {
              "id": 28,
              "name": "Action"
           }
          ]
        }
         */
        // Response gelen genres listesini kullanarak chip'leri yarat.
        genres.forEach { genre ->
            /*
            Örnek response
             {
                 "id": 28,
                 "name": "Action"
            }
             */
            val newChip = Chip(requireContext()).apply {
                text = genre // name değerini yaz
                setOnClickListener {
                    // id değeri istek atıp filmleri filtrele
                }
            }
            genresCG?.addView(newChip)
        }
    }
}