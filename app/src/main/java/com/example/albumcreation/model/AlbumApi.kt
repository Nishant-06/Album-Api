package com.example.albumcreation.model

import io.reactivex.Single
import retrofit2.http.GET

interface AlbumApi {

    @GET("albums")
    fun getAlbums(): Single<List<Album>>
}