package com.example.movie.remote

import android.content.Context
import com.example.movie.model.MovieListResponse
import com.google.gson.Gson
import java.io.IOException

object SampleData {


    fun getMovieList(context: Context, position: Int): MovieListResponse {

        lateinit var jsonString: String
        try {
            when (position) {
                1 -> {
                    jsonString =
                        context.assets.open("CONTENTLISTINGPAGE-PAGE1.json").bufferedReader()
                            .use { it.readText() }
                }

                2 -> {
                    jsonString =
                        context.assets.open("CONTENTLISTINGPAGE-PAGE2.json").bufferedReader()
                            .use { it.readText() }
                }

                3 -> {
                    jsonString =
                        context.assets.open("CONTENTLISTINGPAGE-PAGE3.json").bufferedReader()
                            .use { it.readText() }
                }
            }

        } catch (_: IOException) {

        }
        val gson = Gson()
        return gson.fromJson(jsonString, MovieListResponse::class.java
        )
    }
}


