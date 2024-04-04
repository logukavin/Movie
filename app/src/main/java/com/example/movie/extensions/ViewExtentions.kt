package com.example.movie.extensions

import androidx.appcompat.widget.AppCompatImageView
import coil.load
import com.example.movie.R


fun AppCompatImageView.loadUrl(url: String?) {
    if (url != null) {
        when (url) {
            "poster1.jpg" -> {
                load(R.drawable.poster1)
            }
            "poster2.jpg" -> {
                load(R.drawable.poster2)
            }
            "poster3.jpg" -> {
                load(R.drawable.poster3)
            }
            "poster4.jpg" -> {
                load(R.drawable.poster4)
            }
            "poster5.jpg" -> {
                load(R.drawable.poster5)
            }
            "poster6.jpg" -> {
                load(R.drawable.poster6)
            }
            "poster7.jpg" -> {
                load(R.drawable.poster7)
            }
            "poster8.jpg" -> {
                load(R.drawable.poster8)
            }
            "poster9.jpg" -> {
                load(R.drawable.poster9)
            }
            else -> {
                load(R.drawable.placeholder_for_missing_posters)
            }
        }

    } else {
        load(R.drawable.placeholder_for_missing_posters)
    }
}





